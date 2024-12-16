package org.jeecg.modules.uporder.user.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.crypto.SecureUtil;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
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
 * @Description: 用户管理
 * @Author: jeecg-boot
 * @Date:   2024-12-11
 * @Version: V1.0
 */
@Api(tags="用户管理")
@RestController
@RequestMapping("/user/uporderUser")
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
	//@AutoLog(value = "用户管理-分页列表查询")
	@ApiOperation(value="用户管理-分页列表查询", notes="用户管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<UporderUser>> queryPageList(UporderUser uporderUser,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<UporderUser> queryWrapper = QueryGenerator.initQueryWrapper(uporderUser, req.getParameterMap());
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
	@AutoLog(value = "用户管理-添加")
	@ApiOperation(value="用户管理-添加", notes="用户管理-添加")
	@RequiresPermissions("user:uporder_user:add")
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
	@AutoLog(value = "用户管理-编辑")
	@ApiOperation(value="用户管理-编辑", notes="用户管理-编辑")
	@RequiresPermissions("user:uporder_user:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderUser uporderUser) {

		if (ObjUtil.isNotNull(uporderUser.getPassword())){
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
	@AutoLog(value = "用户管理-通过id删除")
	@ApiOperation(value="用户管理-通过id删除", notes="用户管理-通过id删除")
	@RequiresPermissions("user:uporder_user:delete")
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
	@AutoLog(value = "用户管理-批量删除")
	@ApiOperation(value="用户管理-批量删除", notes="用户管理-批量删除")
	@RequiresPermissions("user:uporder_user:deleteBatch")
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
	//@AutoLog(value = "用户管理-通过id查询")
	@ApiOperation(value="用户管理-通过id查询", notes="用户管理-通过id查询")
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
    @RequiresPermissions("user:uporder_user:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderUser uporderUser) {
        return super.exportXls(request, uporderUser, UporderUser.class, "用户管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("user:uporder_user:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, UporderUser.class);
    }

}
