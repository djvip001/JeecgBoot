package org.jeecg.modules.uporder.usertype.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.uporder.usertype.entity.UporderUserType;
import org.jeecg.modules.uporder.usertype.service.IUporderUserTypeService;

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
 * @Description: 用户类型
 * @Author: jeecg-boot
 * @Date:   2024-12-11
 * @Version: V1.0
 */
@Api(tags="用户类型")
@RestController
@RequestMapping("/usertype/uporderUserType")
@Slf4j
public class UporderUserTypeController extends JeecgController<UporderUserType, IUporderUserTypeService> {
	@Autowired
	private IUporderUserTypeService uporderUserTypeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param uporderUserType
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "用户类型-分页列表查询")
	@ApiOperation(value="用户类型-分页列表查询", notes="用户类型-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<UporderUserType>> queryPageList(UporderUserType uporderUserType,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<UporderUserType> queryWrapper = QueryGenerator.initQueryWrapper(uporderUserType, req.getParameterMap());
		Page<UporderUserType> page = new Page<UporderUserType>(pageNo, pageSize);
		IPage<UporderUserType> pageList = uporderUserTypeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderUserType
	 * @return
	 */
	@AutoLog(value = "用户类型-添加")
	@ApiOperation(value="用户类型-添加", notes="用户类型-添加")
	@RequiresPermissions("usertype:uporder_user_type:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderUserType uporderUserType) {
		uporderUserTypeService.save(uporderUserType);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderUserType
	 * @return
	 */
	@AutoLog(value = "用户类型-编辑")
	@ApiOperation(value="用户类型-编辑", notes="用户类型-编辑")
	@RequiresPermissions("usertype:uporder_user_type:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderUserType uporderUserType) {
		uporderUserTypeService.updateById(uporderUserType);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "用户类型-通过id删除")
	@ApiOperation(value="用户类型-通过id删除", notes="用户类型-通过id删除")
	@RequiresPermissions("usertype:uporder_user_type:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		uporderUserTypeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "用户类型-批量删除")
	@ApiOperation(value="用户类型-批量删除", notes="用户类型-批量删除")
	@RequiresPermissions("usertype:uporder_user_type:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uporderUserTypeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "用户类型-通过id查询")
	@ApiOperation(value="用户类型-通过id查询", notes="用户类型-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<UporderUserType> queryById(@RequestParam(name="id",required=true) String id) {
		UporderUserType uporderUserType = uporderUserTypeService.getById(id);
		if(uporderUserType==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(uporderUserType);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param uporderUserType
    */
    @RequiresPermissions("usertype:uporder_user_type:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderUserType uporderUserType) {
        return super.exportXls(request, uporderUserType, UporderUserType.class, "用户类型");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("usertype:uporder_user_type:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, UporderUserType.class);
    }

}
