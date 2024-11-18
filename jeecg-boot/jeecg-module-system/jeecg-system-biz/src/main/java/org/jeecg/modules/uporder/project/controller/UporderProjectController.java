package org.jeecg.modules.uporder.project.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.uporder.project.entity.UporderProject;
import org.jeecg.modules.uporder.project.service.IUporderProjectService;

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
 * @Description: 报单项目
 * @Author: jeecg-boot
 * @Date:   2024-11-16
 * @Version: V1.0
 */
@Api(tags="报单项目")
@RestController
@RequestMapping("/uporderProject/uporderProject")
@Slf4j
public class UporderProjectController extends JeecgController<UporderProject, IUporderProjectService> {
	@Autowired
	private IUporderProjectService uporderProjectService;
	
	/**
	 * 分页列表查询
	 *
	 * @param uporderProject
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "报单项目-分页列表查询")
	@ApiOperation(value="报单项目-分页列表查询", notes="报单项目-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<UporderProject>> queryPageList(UporderProject uporderProject,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<UporderProject> queryWrapper = QueryGenerator.initQueryWrapper(uporderProject, req.getParameterMap());
		Page<UporderProject> page = new Page<UporderProject>(pageNo, pageSize);
		IPage<UporderProject> pageList = uporderProjectService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderProject
	 * @return
	 */
	@AutoLog(value = "报单项目-添加")
	@ApiOperation(value="报单项目-添加", notes="报单项目-添加")
	@RequiresPermissions("uporderProject:uporder_project:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderProject uporderProject) {
		uporderProjectService.save(uporderProject);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderProject
	 * @return
	 */
	@AutoLog(value = "报单项目-编辑")
	@ApiOperation(value="报单项目-编辑", notes="报单项目-编辑")
	@RequiresPermissions("uporderProject:uporder_project:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderProject uporderProject) {
		uporderProjectService.updateById(uporderProject);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "报单项目-通过id删除")
	@ApiOperation(value="报单项目-通过id删除", notes="报单项目-通过id删除")
	@RequiresPermissions("uporderProject:uporder_project:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		uporderProjectService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "报单项目-批量删除")
	@ApiOperation(value="报单项目-批量删除", notes="报单项目-批量删除")
	@RequiresPermissions("uporderProject:uporder_project:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uporderProjectService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "报单项目-通过id查询")
	@ApiOperation(value="报单项目-通过id查询", notes="报单项目-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<UporderProject> queryById(@RequestParam(name="id",required=true) String id) {
		UporderProject uporderProject = uporderProjectService.getById(id);
		if(uporderProject==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(uporderProject);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param uporderProject
    */
    @RequiresPermissions("uporderProject:uporder_project:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderProject uporderProject) {
        return super.exportXls(request, uporderProject, UporderProject.class, "报单项目");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("uporderProject:uporder_project:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, UporderProject.class);
    }

}
