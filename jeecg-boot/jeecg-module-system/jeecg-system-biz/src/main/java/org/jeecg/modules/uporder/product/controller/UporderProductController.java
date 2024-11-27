package org.jeecg.modules.uporder.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.aspect.annotation.PermissionData;
import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.entity.UporderProductDefineField;
import org.jeecg.modules.uporder.product.entity.UporderProductUserLimit;
import org.jeecg.modules.uporder.product.entity.UporderProductBuyLink;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import org.jeecg.modules.uporder.product.vo.UporderProductPage;
import org.jeecg.modules.uporder.product.service.IUporderProductService;
import org.jeecg.modules.uporder.product.service.IUporderProductMediumTextService;
import org.jeecg.modules.uporder.product.service.IUporderProductTypeRefundConfigService;
import org.jeecg.modules.uporder.product.service.IUporderProductDefineFieldService;
import org.jeecg.modules.uporder.product.service.IUporderProductUserLimitService;
import org.jeecg.modules.uporder.product.service.IUporderProductBuyLinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;


 /**
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@Api(tags="产品表")
@RestController
@RequestMapping("/product/uporderProduct")
@Slf4j
public class UporderProductController {
	@Autowired
	private IUporderProductService uporderProductService;
	@Autowired
	private IUporderProductMediumTextService uporderProductMediumTextService;
	@Autowired
	private IUporderProductTypeRefundConfigService uporderProductTypeRefundConfigService;
	@Autowired
	private IUporderProductDefineFieldService uporderProductDefineFieldService;
	@Autowired
	private IUporderProductUserLimitService uporderProductUserLimitService;
	@Autowired
	private IUporderProductBuyLinkService uporderProductBuyLinkService;
	
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
	@PermissionData(pageComponent = "uporder/product/UporderProductList")
	public Result<IPage<UporderProduct>> queryPageList(UporderProduct uporderProduct,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("projectId", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<UporderProduct> queryWrapper = QueryGenerator.initQueryWrapper(uporderProduct, req.getParameterMap(),customeRuleMap);
		Page<UporderProduct> page = new Page<UporderProduct>(pageNo, pageSize);
		IPage<UporderProduct> pageList = uporderProductService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderProductPage
	 * @return
	 */
	@AutoLog(value = "产品表-添加")
	@ApiOperation(value="产品表-添加", notes="产品表-添加")
    @RequiresPermissions("product:uporder_product:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderProductPage uporderProductPage) {
		UporderProduct uporderProduct = new UporderProduct();
		BeanUtils.copyProperties(uporderProductPage, uporderProduct);
		uporderProductService.saveMain(uporderProduct, uporderProductPage.getUporderProductMediumTextList(),uporderProductPage.getUporderProductTypeRefundConfigList(),uporderProductPage.getUporderProductDefineFieldList(),uporderProductPage.getUporderProductUserLimitList(),uporderProductPage.getUporderProductBuyLinkList());
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderProductPage
	 * @return
	 */
	@AutoLog(value = "产品表-编辑")
	@ApiOperation(value="产品表-编辑", notes="产品表-编辑")
    @RequiresPermissions("product:uporder_product:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderProductPage uporderProductPage) {
		UporderProduct uporderProduct = new UporderProduct();
		BeanUtils.copyProperties(uporderProductPage, uporderProduct);
		UporderProduct uporderProductEntity = uporderProductService.getById(uporderProduct.getId());
		if(uporderProductEntity==null) {
			return Result.error("未找到对应数据");
		}
		uporderProductService.updateMain(uporderProduct, uporderProductPage.getUporderProductMediumTextList(),uporderProductPage.getUporderProductTypeRefundConfigList(),uporderProductPage.getUporderProductDefineFieldList(),uporderProductPage.getUporderProductUserLimitList(),uporderProductPage.getUporderProductBuyLinkList());
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
		uporderProductService.delMain(id);
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
		this.uporderProductService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
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
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "产品文本表通过主表ID查询")
	@ApiOperation(value="产品文本表主表ID查询", notes="产品文本表-通主表ID查询")
	@GetMapping(value = "/queryUporderProductMediumTextByMainId")
	public Result<List<UporderProductMediumText>> queryUporderProductMediumTextListByMainId(@RequestParam(name="id",required=true) String id) {
		List<UporderProductMediumText> uporderProductMediumTextList = uporderProductMediumTextService.selectByMainId(id);
		return Result.OK(uporderProductMediumTextList);
	}
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "产品用户类型折扣表通过主表ID查询")
	@ApiOperation(value="产品用户类型折扣表主表ID查询", notes="产品用户类型折扣表-通主表ID查询")
	@GetMapping(value = "/queryUporderProductTypeRefundConfigByMainId")
	public Result<List<UporderProductTypeRefundConfig>> queryUporderProductTypeRefundConfigListByMainId(@RequestParam(name="id",required=true) String id) {
		List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList = uporderProductTypeRefundConfigService.selectByMainId(id);
		return Result.OK(uporderProductTypeRefundConfigList);
	}
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "产品自定义字段表通过主表ID查询")
	@ApiOperation(value="产品自定义字段表主表ID查询", notes="产品自定义字段表-通主表ID查询")
	@GetMapping(value = "/queryUporderProductDefineFieldByMainId")
	public Result<List<UporderProductDefineField>> queryUporderProductDefineFieldListByMainId(@RequestParam(name="id",required=true) String id) {
		List<UporderProductDefineField> uporderProductDefineFieldList = uporderProductDefineFieldService.selectByMainId(id);
		return Result.OK(uporderProductDefineFieldList);
	}
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "报单产品用户额度表通过主表ID查询")
	@ApiOperation(value="报单产品用户额度表主表ID查询", notes="报单产品用户额度表-通主表ID查询")
	@GetMapping(value = "/queryUporderProductUserLimitByMainId")
	public Result<List<UporderProductUserLimit>> queryUporderProductUserLimitListByMainId(@RequestParam(name="id",required=true) String id) {
		List<UporderProductUserLimit> uporderProductUserLimitList = uporderProductUserLimitService.selectByMainId(id);
		return Result.OK(uporderProductUserLimitList);
	}
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "报单产品购买链接通过主表ID查询")
	@ApiOperation(value="报单产品购买链接主表ID查询", notes="报单产品购买链接-通主表ID查询")
	@GetMapping(value = "/queryUporderProductBuyLinkByMainId")
	public Result<List<UporderProductBuyLink>> queryUporderProductBuyLinkListByMainId(@RequestParam(name="id",required=true) String id) {
		List<UporderProductBuyLink> uporderProductBuyLinkList = uporderProductBuyLinkService.selectByMainId(id);
		return Result.OK(uporderProductBuyLinkList);
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
      // Step.1 组装查询条件查询数据
      QueryWrapper<UporderProduct> queryWrapper = QueryGenerator.initQueryWrapper(uporderProduct, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

      //配置选中数据查询条件
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      //Step.2 获取导出数据
      List<UporderProduct> uporderProductList = uporderProductService.list(queryWrapper);

      // Step.3 组装pageList
      List<UporderProductPage> pageList = new ArrayList<UporderProductPage>();
      for (UporderProduct main : uporderProductList) {
          UporderProductPage vo = new UporderProductPage();
          BeanUtils.copyProperties(main, vo);
          List<UporderProductMediumText> uporderProductMediumTextList = uporderProductMediumTextService.selectByMainId(main.getId());
          vo.setUporderProductMediumTextList(uporderProductMediumTextList);
          List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList = uporderProductTypeRefundConfigService.selectByMainId(main.getId());
          vo.setUporderProductTypeRefundConfigList(uporderProductTypeRefundConfigList);
          List<UporderProductDefineField> uporderProductDefineFieldList = uporderProductDefineFieldService.selectByMainId(main.getId());
          vo.setUporderProductDefineFieldList(uporderProductDefineFieldList);
          List<UporderProductUserLimit> uporderProductUserLimitList = uporderProductUserLimitService.selectByMainId(main.getId());
          vo.setUporderProductUserLimitList(uporderProductUserLimitList);
          List<UporderProductBuyLink> uporderProductBuyLinkList = uporderProductBuyLinkService.selectByMainId(main.getId());
          vo.setUporderProductBuyLinkList(uporderProductBuyLinkList);
          pageList.add(vo);
      }

      // Step.4 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "产品表列表");
      mv.addObject(NormalExcelConstants.CLASS, UporderProductPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("产品表数据", "导出人:"+sysUser.getRealname(), "产品表"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
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
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          // 获取上传文件对象
          MultipartFile file = entity.getValue();
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<UporderProductPage> list = ExcelImportUtil.importExcel(file.getInputStream(), UporderProductPage.class, params);
              for (UporderProductPage page : list) {
                  UporderProduct po = new UporderProduct();
                  BeanUtils.copyProperties(page, po);
                  uporderProductService.saveMain(po, page.getUporderProductMediumTextList(),page.getUporderProductTypeRefundConfigList(),page.getUporderProductDefineFieldList(),page.getUporderProductUserLimitList(),page.getUporderProductBuyLinkList());
              }
              return Result.OK("文件导入成功！数据行数:" + list.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.OK("文件导入失败！");
    }

	 @ApiOperation(value="产品表-已删除分页列表查询", notes="产品表-已删除分页列表查询")
	 @GetMapping(value = "/dellist")
	 public Result<IPage<UporderProduct>> dellist(UporderProduct uporderProduct,
														@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
														@RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
														HttpServletRequest req) {
		 // 自定义查询规则
		 Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
		 // 自定义多选的查询规则为：LIKE_WITH_OR
		 customeRuleMap.put("projectId", QueryRuleEnum.LIKE_WITH_OR);
		 QueryWrapper<UporderProduct> queryWrapper = QueryGenerator.initQueryWrapper(uporderProduct, req.getParameterMap(),customeRuleMap);
		 Page<UporderProduct> page = new Page<UporderProduct>(pageNo, pageSize);
		 IPage<UporderProduct> pageList = uporderProductService.delList(page, queryWrapper);
		 return Result.OK(pageList);
	 }


	 @AutoLog(value = "产品表-恢复")
	 @ApiOperation(value="产品表-恢复", notes="产品表-恢复")
	 @RequiresPermissions("product:uporder_product:recover")
	 @RequestMapping(value = "/recover", method = {RequestMethod.PUT,RequestMethod.POST})
	 public Result<String> recover( String id) {
		 uporderProductService.recover(id);
		 return Result.OK("编辑成功!");
	 }



	 @ApiOperation(value="产品表-查询活动页的产品", notes="产品表-已删除分页列表查询")
	 @GetMapping(value = "/listDoingAction")
	 @IgnoreAuth

	 public Result<IPage<UporderProduct>> listDoingAction(UporderProduct uporderProduct,
												  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
												  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
												  HttpServletRequest req) {
		 // 自定义查询规则
		 Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
		 // 自定义多选的查询规则为：LIKE_WITH_OR
		 customeRuleMap.put("projectId", QueryRuleEnum.LIKE_WITH_OR);
		 QueryWrapper<UporderProduct> queryWrapper = QueryGenerator.initQueryWrapper(uporderProduct, req.getParameterMap(),customeRuleMap);
		 uporderProduct.setShowAct(1);
		 Page<UporderProduct> page = new Page<UporderProduct>(pageNo, pageSize);
		 IPage<UporderProduct> pageList = uporderProductService.page(page, queryWrapper);
		 return Result.OK(pageList);
	 }

 }
