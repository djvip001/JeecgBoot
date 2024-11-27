package org.jeecg.modules.uporder.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import org.jeecg.modules.uporder.user.mapper.UporderUserMapper;
import org.jeecg.modules.uporder.user.service.IUporderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 报单用户表
 * @Author: jeecg-boot
 * @Date:   2024-11-16
 * @Version: V1.0
 */
@Service
public class UporderUserServiceImpl extends ServiceImpl<UporderUserMapper, UporderUser> implements IUporderUserService {

    @Autowired
    private UporderUserMapper uporderUserMapper;

    @Override
    public IPage<UporderUser> delList(Page<UporderUser> page, QueryWrapper<UporderUser> queryWrapper) {

        queryWrapper.apply(" del_flag=1");
        List<UporderUser> uporderUsers = uporderUserMapper.delList(page,queryWrapper);



        return page.setRecords(uporderUsers);
    }

    @Override
    public void recover(String uporderUser) {

        uporderUserMapper.recover(uporderUser);
    }

    @Override
    public Result<?> checkUserIsEffective(UporderUser uporderUser) {
        Result<?> result = new Result<Object>();
        //情况1：根据用户信息查询，该用户不存在
        if (uporderUser == null) {
            result.error500("该用户不存在，请注册");
            return result;
        }
        //情况2：根据用户信息查询，该用户已注销
        //update-begin---author:王帅   Date:20200601  for：if条件永远为falsebug------------
        if (CommonConstant.DEL_FLAG_1.equals(uporderUser.getDelFlag())) {
            //update-end---author:王帅   Date:20200601  for：if条件永远为falsebug------------
            result.error500("该用户已注销");
            return result;
        }
        //情况3：根据用户信息查询，该用户已冻结
        if (CommonConstant.USER_FREEZE.equals(uporderUser.getStatus())) {
            result.error500("该用户已冻结");
            return result;
        }
        return result;
    }

    @Override
    public UporderUser getUserByName(String username) {

        return uporderUserMapper.getUserByName(username);
    }
}
