package org.jeecg.modules.uporder.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import org.jeecg.modules.uporder.product.service.IUporderProductService;

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
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-18
 * @Version: V1.0
 */
@Api(tags="产品表")
@RestController
@RequestMapping("/product/uporderProduct")
@Slf4j
public class UporderProductController extends JeecgController<UporderProduct, IUporderProductService> {
	@Autowired
	private IUporderProductService uporderProductService;
	
	/**
	 * 分页列表查询
	 *
	 * @param uporderProduct
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "产品表-分页列表查询")
	@ApiOperation(value="产品表-分页列表查询", notes="产品表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<UporderProduct>> queryPageList(UporderProduct uporderProduct,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("projectId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("upperConfigId", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<UporderProduct> queryWrapper = QueryGenerator.initQueryWrapper(uporderProduct, req.getParameterMap(),customeRuleMap);
		Page<UporderProduct> page = new Page<UporderProduct>(pageNo, pageSize);
		IPage<UporderProduct> pageList = uporderProductService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderProduct
	 * @return
	 */
	@AutoLog(value = "产品表-添加")
	@ApiOperation(value="产品表-添加", notes="产品表-添加")
	@RequiresPermissions("product:uporder_product:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderProduct uporderProduct) {
		uporderProductService.save(uporderProduct);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderProduct
	 * @return
	 */
	@AutoLog(value = "产品表-编辑")
	@ApiOperation(value="产品表-编辑", notes="产品表-编辑")
	@RequiresPermissions("product:uporder_product:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderProduct uporderProduct) {
		uporderProductService.updateById(uporderProduct);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "产品表-通过id删除")
	@ApiOperation(value="产品表-通过id删除", notes="产品表-通过id删除")
	@RequiresPermissions("product:uporder_product:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		uporderProductService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "产品表-批量删除")
	@ApiOperation(value="产品表-批量删除", notes="产品表-批量删除")
	@RequiresPermissions("product:uporder_product:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uporderProductService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "产品表-通过id查询")
	@ApiOperation(value="产品表-通过id查询", notes="产品表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<UporderProduct> queryById(@RequestParam(name="id",required=true) String id) {
		UporderProduct uporderProduct = uporderProductService.getById(id);
		if(uporderProduct==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(uporderProduct);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param uporderProduct
    */
    @RequiresPermissions("product:uporder_product:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderProduct uporderProduct) {
        return super.exportXls(request, uporderProduct, UporderProduct.class, "产品表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("product:uporder_product:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, UporderProduct.class);
    }

}
