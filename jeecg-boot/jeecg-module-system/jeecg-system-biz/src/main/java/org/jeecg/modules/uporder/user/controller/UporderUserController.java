package org.jeecg.modules.uporder.user.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.PermissionData;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.PasswordUtil;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import org.jeecg.modules.uporder.user.service.IUporderUserService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 报单用户表
 * @Author: jeecg-boot
 * @Date:   2024-11-16
 * @Version: V1.0
 */
@Api(tags="报单用户表")
@RestController
@RequestMapping("/uporderUser/uporderUser")
@Slf4j
public class UporderUserController extends JeecgController<UporderUser, IUporderUserService> {
	@Autowired
	private IUporderUserService uporderUserService;
	
	/**
	 * 分页列表查询
	 *
	 * @param uporderUser
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "报单用户表-分页列表查询")
	@ApiOperation(value="报单用户表-分页列表查询", notes="报单用户表-分页列表查询")
	@GetMapping(value = "/list")
	@PermissionData(pageComponent="uporder/user/UporderUserList")
	public Result<IPage<UporderUser>> queryPageList(UporderUser uporderUser,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("accountType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<UporderUser> queryWrapper = QueryGenerator.initQueryWrapper(uporderUser, req.getParameterMap(),customeRuleMap);
		queryWrapper.apply("1 = 1");

		Page<UporderUser> page = new Page<UporderUser>(pageNo, pageSize);
		IPage<UporderUser> pageList = uporderUserService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderUser
	 * @return
	 */
	@AutoLog(value = "报单用户表-添加")
	@ApiOperation(value="报单用户表-添加", notes="报单用户表-添加")
	@RequiresPermissions("uporderUser:uporder_user:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderUser uporderUser) {

		String s = SecureUtil.md5(uporderUser.getPassword());
		uporderUser.setPassword(s);
		uporderUserService.save(uporderUser);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderUser
	 * @return
	 */
	@AutoLog(value = "报单用户表-编辑")
	@ApiOperation(value="报单用户表-编辑", notes="报单用户表-编辑")
	@RequiresPermissions("uporderUser:uporder_user:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderUser uporderUser) {

		if (ObjUtil.isNotNull(uporderUser.getPassword())) {
			String s = SecureUtil.md5(uporderUser.getPassword());
			uporderUser.setPassword(s);
		}

		uporderUserService.updateById(uporderUser);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "报单用户表-通过id删除")
	@ApiOperation(value="报单用户表-通过id删除", notes="报单用户表-通过id删除")
	@RequiresPermissions("uporderUser:uporder_user:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		uporderUserService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "报单用户表-批量删除")
	@ApiOperation(value="报单用户表-批量删除", notes="报单用户表-批量删除")
	@RequiresPermissions("uporderUser:uporder_user:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uporderUserService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "报单用户表-通过id查询")
	@ApiOperation(value="报单用户表-通过id查询", notes="报单用户表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<UporderUser> queryById(@RequestParam(name="id",required=true) String id) {
		UporderUser uporderUser = uporderUserService.getById(id);
		if(uporderUser==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(uporderUser);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param uporderUser
    */
    @RequiresPermissions("uporderUser:uporder_user:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderUser uporderUser) {
        return super.exportXls(request, uporderUser, UporderUser.class, "报单用户表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("uporderUser:uporder_user:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, UporderUser.class);
    }

	 @ApiOperation(value="报单用户表-已删除分页列表查询", notes="报单用户表-已删除分页列表查询")
	 @GetMapping(value = "/dellist")
	 public Result<IPage<UporderUser>> queryDelPageList(UporderUser uporderUser,
													 @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
													 @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
													 HttpServletRequest req) {
//		 // 自定义查询规则
		 Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
//		 // 自定义多选的查询规则为：LIKE_WITH_OR
		 customeRuleMap.put("accountType", QueryRuleEnum.LIKE_WITH_OR);
		 customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
		 QueryWrapper<UporderUser> queryWrapper = QueryGenerator.initQueryWrapper(uporderUser, req.getParameterMap(),customeRuleMap);
		 Page<UporderUser> page = new Page<UporderUser>(pageNo, pageSize);
		 IPage<UporderUser> pageList = uporderUserService.delList(page, queryWrapper);
		 return Result.OK(pageList);
	 }

	 @AutoLog(value = "报单用户表-恢复")
	 @ApiOperation(value="报单用户表-恢复", notes="报单用户表-恢复")
	 @RequiresPermissions("uporderUser:uporder_user:recover")
	 @RequestMapping(value = "/recover", method = {RequestMethod.PUT,RequestMethod.POST})
	 public Result<String> recover( String id) {
		 uporderUserService.recover(id);
		 return Result.OK("编辑成功!");
	 }


 }
