package org.jeecg.modules.uporder.template.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.uporder.template.entity.UporderTemplate;
import org.jeecg.modules.uporder.template.service.IUporderTemplateService;

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
 * @Description: 产品模版
 * @Author: jeecg-boot
 * @Date:   2024-11-20
 * @Version: V1.0
 */
@Api(tags="产品模版")
@RestController
@RequestMapping("/template/uporderTemplate")
@Slf4j
public class UporderTemplateController extends JeecgController<UporderTemplate, IUporderTemplateService> {
	@Autowired
	private IUporderTemplateService uporderTemplateService;
	
	/**
	 * 分页列表查询
	 *
	 * @param uporderTemplate
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "产品模版-分页列表查询")
	@ApiOperation(value="产品模版-分页列表查询", notes="产品模版-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<UporderTemplate>> queryPageList(UporderTemplate uporderTemplate,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<UporderTemplate> queryWrapper = QueryGenerator.initQueryWrapper(uporderTemplate, req.getParameterMap());
		Page<UporderTemplate> page = new Page<UporderTemplate>(pageNo, pageSize);
		IPage<UporderTemplate> pageList = uporderTemplateService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderTemplate
	 * @return
	 */
	@AutoLog(value = "产品模版-添加")
	@ApiOperation(value="产品模版-添加", notes="产品模版-添加")
	@RequiresPermissions("template:uporder_template:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderTemplate uporderTemplate) {
		uporderTemplateService.save(uporderTemplate);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderTemplate
	 * @return
	 */
	@AutoLog(value = "产品模版-编辑")
	@ApiOperation(value="产品模版-编辑", notes="产品模版-编辑")
	@RequiresPermissions("template:uporder_template:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderTemplate uporderTemplate) {
		uporderTemplateService.updateById(uporderTemplate);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "产品模版-通过id删除")
	@ApiOperation(value="产品模版-通过id删除", notes="产品模版-通过id删除")
	@RequiresPermissions("template:uporder_template:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		uporderTemplateService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "产品模版-批量删除")
	@ApiOperation(value="产品模版-批量删除", notes="产品模版-批量删除")
	@RequiresPermissions("template:uporder_template:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uporderTemplateService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "产品模版-通过id查询")
	@ApiOperation(value="产品模版-通过id查询", notes="产品模版-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<UporderTemplate> queryById(@RequestParam(name="id",required=true) String id) {
		UporderTemplate uporderTemplate = uporderTemplateService.getById(id);
		if(uporderTemplate==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(uporderTemplate);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param uporderTemplate
    */
    @RequiresPermissions("template:uporder_template:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderTemplate uporderTemplate) {
        return super.exportXls(request, uporderTemplate, UporderTemplate.class, "产品模版");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("template:uporder_template:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, UporderTemplate.class);
    }

}
