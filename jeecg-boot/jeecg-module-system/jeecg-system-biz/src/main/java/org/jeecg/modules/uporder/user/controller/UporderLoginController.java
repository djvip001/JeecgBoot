package org.jeecg.modules.uporder.user.controller;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.constant.CacheConstant;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.system.util.JwtUtil;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.PasswordUtil;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecg.modules.system.entity.SysDepart;
import org.jeecg.modules.system.entity.SysUser;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import org.jeecg.modules.uporder.user.model.UporderUserLoginModel;
import org.jeecg.modules.uporder.user.service.IUporderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author jin_deng
 */
@RestController
@RequestMapping("/uporder/auth")
@Api(tags="报单用户登录")
@Slf4j

public class UporderLoginController {

    @Autowired
    private IUporderUserService uporderUserService;
    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation("登录接口")
    @PostMapping(value = "/login")
    @IgnoreAuth
    public Result<JSONObject> login(@RequestBody UporderUserLoginModel uporderUserLoginModel, HttpServletRequest request){
        Result<JSONObject> result = new Result<JSONObject>();
        String username = uporderUserLoginModel.getAccount();
        String password = uporderUserLoginModel.getPassword();

        // step.2 校验用户是否存在且有效

        UporderUser uporderUser = uporderUserService.getUserByName(username);
        result = uporderUserService.checkUserIsEffective(uporderUser);
        if(!result.isSuccess()) {
            return result;
        }

        // step.3 校验用户名或密码是否正确
        String userpassword = SecureUtil.md5(password);
        String syspassword = uporderUser.getPassword();
        if (!syspassword.equals(userpassword)) {
            addLoginFailOvertimes(username);
            result.error500("用户名或密码错误");
            return result;
        }

        // step.4  登录成功获取用户信息
        userInfo(uporderUser, result, request);


        return result;
    }


    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @ApiOperation("退出接口")
    @PostMapping(value = "/logout")
    @IgnoreAuth
    public Result<Object> logout(HttpServletRequest request, HttpServletResponse response) {
        //用户退出逻辑
        String token = request.getHeader(CommonConstant.X_ACCESS_TOKEN);
        if(oConvertUtils.isEmpty(token)) {
            return Result.error("退出登录失败！");
        }
        String username = JwtUtil.getUsername(token);
        UporderUser uporderUser = uporderUserService.getUserByName(username);
        if(uporderUser!=null) {
            log.info(" 用户名:  "+uporderUser.getAccount()+",退出成功！ ");
            //清空用户登录Token缓存
            redisUtil.del(CommonConstant.PREFIX_UPORDER_USER_TOKEN + token);
            return Result.ok("退出登录成功！");
        }else {
            return Result.error("Token无效!");
        }
    }



    /**
     * 记录登录失败次数
     * @param username
     */
    private void addLoginFailOvertimes(String username){
        String key = CommonConstant.LOGIN_FAIL + username;
        Object failTime = redisUtil.get(key);
        Integer val = 0;
        if(failTime!=null){
            val = Integer.parseInt(failTime.toString());
        }
        // 10分钟，一分钟为60s
        redisUtil.set(key, ++val, 600);
    }

    /**
     * 用户信息
     *
     * @param result
     * @return
     */
    private Result<JSONObject> userInfo(UporderUser uporderUser, Result<JSONObject> result, HttpServletRequest request) {
        String username = uporderUser.getAccount();
        String syspassword = uporderUser.getPassword();
        // 获取用户部门信息
        JSONObject obj = new JSONObject(new LinkedHashMap<>());

        //1.生成token
        String token = JwtUtil.sign(username, syspassword);

        // 设置token缓存有效时间
        redisUtil.set(CommonConstant.PREFIX_UPORDER_USER_TOKEN + token, token);
        redisUtil.expire(CommonConstant.PREFIX_UPORDER_USER_TOKEN + token, JwtUtil.EXPIRE_TIME * 2 / 1000);
        obj.put("token", token);

        //3.设置登录用户信息
        obj.put("userInfo", uporderUser);


        result.setResult(obj);
        result.success("登录成功");
        return result;
    }
}
