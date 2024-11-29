package org.jeecg.modules.demo.order.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.jeecg.modules.demo.order.entity.UporderOrderTrafficNo;
import org.jeecg.modules.demo.order.entity.UporderOrder;
import org.jeecg.modules.demo.order.vo.UporderOrderPage;
import org.jeecg.modules.demo.order.service.IUporderOrderService;
import org.jeecg.modules.demo.order.service.IUporderOrderTrafficNoService;
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
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;


 /**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-29
 * @Version: V1.0
 */
@Api(tags="订单表")
@RestController
@RequestMapping("/order/uporderOrder")
@Slf4j
public class UporderOrderController {
	@Autowired
	private IUporderOrderService uporderOrderService;
	@Autowired
	private IUporderOrderTrafficNoService uporderOrderTrafficNoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param uporderOrder
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "订单表-分页列表查询")
	@ApiOperation(value="订单表-分页列表查询", notes="订单表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<UporderOrder>> queryPageList(UporderOrder uporderOrder,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("userId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("productId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("orderStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("refundCalWay", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("refundStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("auditStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("refundPayWay", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("upperChannelStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<UporderOrder> queryWrapper = QueryGenerator.initQueryWrapper(uporderOrder, req.getParameterMap(),customeRuleMap);
		Page<UporderOrder> page = new Page<UporderOrder>(pageNo, pageSize);
		IPage<UporderOrder> pageList = uporderOrderService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderOrderPage
	 * @return
	 */
	@AutoLog(value = "订单表-添加")
	@ApiOperation(value="订单表-添加", notes="订单表-添加")
    @RequiresPermissions("order:uporder_order:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderOrderPage uporderOrderPage) {
		UporderOrder uporderOrder = new UporderOrder();
		BeanUtils.copyProperties(uporderOrderPage, uporderOrder);
		uporderOrderService.saveMain(uporderOrder, uporderOrderPage.getUporderOrderTrafficNoList());
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderOrderPage
	 * @return
	 */
	@AutoLog(value = "订单表-编辑")
	@ApiOperation(value="订单表-编辑", notes="订单表-编辑")
    @RequiresPermissions("order:uporder_order:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderOrderPage uporderOrderPage) {
		UporderOrder uporderOrder = new UporderOrder();
		BeanUtils.copyProperties(uporderOrderPage, uporderOrder);
		UporderOrder uporderOrderEntity = uporderOrderService.getById(uporderOrder.getId());
		if(uporderOrderEntity==null) {
			return Result.error("未找到对应数据");
		}
		uporderOrderService.updateMain(uporderOrder, uporderOrderPage.getUporderOrderTrafficNoList());
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "订单表-通过id删除")
	@ApiOperation(value="订单表-通过id删除", notes="订单表-通过id删除")
    @RequiresPermissions("order:uporder_order:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		uporderOrderService.delMain(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "订单表-批量删除")
	@ApiOperation(value="订单表-批量删除", notes="订单表-批量删除")
    @RequiresPermissions("order:uporder_order:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uporderOrderService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "订单表-通过id查询")
	@ApiOperation(value="订单表-通过id查询", notes="订单表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<UporderOrder> queryById(@RequestParam(name="id",required=true) String id) {
		UporderOrder uporderOrder = uporderOrderService.getById(id);
		if(uporderOrder==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(uporderOrder);

	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "订单物流表通过主表ID查询")
	@ApiOperation(value="订单物流表主表ID查询", notes="订单物流表-通主表ID查询")
	@GetMapping(value = "/queryUporderOrderTrafficNoByMainId")
	public Result<List<UporderOrderTrafficNo>> queryUporderOrderTrafficNoListByMainId(@RequestParam(name="id",required=true) String id) {
		List<UporderOrderTrafficNo> uporderOrderTrafficNoList = uporderOrderTrafficNoService.selectByMainId(id);
		return Result.OK(uporderOrderTrafficNoList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param uporderOrder
    */
    @RequiresPermissions("order:uporder_order:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderOrder uporderOrder) {
      // Step.1 组装查询条件查询数据
      QueryWrapper<UporderOrder> queryWrapper = QueryGenerator.initQueryWrapper(uporderOrder, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

      //配置选中数据查询条件
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      //Step.2 获取导出数据
      List<UporderOrder> uporderOrderList = uporderOrderService.list(queryWrapper);

      // Step.3 组装pageList
      List<UporderOrderPage> pageList = new ArrayList<UporderOrderPage>();
      for (UporderOrder main : uporderOrderList) {
          UporderOrderPage vo = new UporderOrderPage();
          BeanUtils.copyProperties(main, vo);
          List<UporderOrderTrafficNo> uporderOrderTrafficNoList = uporderOrderTrafficNoService.selectByMainId(main.getId());
          vo.setUporderOrderTrafficNoList(uporderOrderTrafficNoList);
          pageList.add(vo);
      }

      // Step.4 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "订单表列表");
      mv.addObject(NormalExcelConstants.CLASS, UporderOrderPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("订单表数据", "导出人:"+sysUser.getRealname(), "订单表"));
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
    @RequiresPermissions("order:uporder_order:importExcel")
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
              List<UporderOrderPage> list = ExcelImportUtil.importExcel(file.getInputStream(), UporderOrderPage.class, params);
              for (UporderOrderPage page : list) {
                  UporderOrder po = new UporderOrder();
                  BeanUtils.copyProperties(page, po);
                  uporderOrderService.saveMain(po, page.getUporderOrderTrafficNoList());
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

}
