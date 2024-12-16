package org.jeecg.modules.uporder.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.system.util.JwtUtil;
import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecg.modules.uporder.order.vo.UpOrderSaveParam;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import org.jeecg.modules.uporder.user.service.IUporderUserService;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.uporder.order.entity.UporderOrderTrafficNo;
import org.jeecg.modules.uporder.order.entity.UporderOrder;
import org.jeecg.modules.uporder.order.vo.UporderOrderPage;
import org.jeecg.modules.uporder.order.service.IUporderOrderService;
import org.jeecg.modules.uporder.order.service.IUporderOrderTrafficNoService;
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
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-25
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

	@Autowired
	protected IUporderUserService uporderUserService;
	
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
        QueryWrapper<UporderOrder> queryWrapper = QueryGenerator.initQueryWrapper(uporderOrder, req.getParameterMap());
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
//		UporderOrder uporderOrder = new UporderOrder();
//		BeanUtils.copyProperties(uporderOrderPage, uporderOrder);
//		uporderOrderService.saveMain(uporderOrder, uporderOrderPage.getUporderOrderTrafficNoList());

		String userId = uporderOrderPage.getUserId();
		UporderUser uporderUser = uporderUserService.getById(userId);
		UpOrderSaveParam saveParam = new UpOrderSaveParam();
		BeanUtils.copyProperties(uporderOrderPage, saveParam);
		uporderOrderService.saveOrder(uporderUser,saveParam);
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



	 @AutoLog(value = "订单表-报单")
	 @ApiOperation(value="订单表-报单", notes="订单表-报单")
	 @PostMapping(value = "/save")
	 @IgnoreAuth
	 public Result<String> save(@RequestBody UpOrderSaveParam upOrderSaveParam, HttpServletRequest request) {
		 String token = request.getHeader(CommonConstant.X_ACCESS_TOKEN);

		 String username = JwtUtil.getUsername(token);
		 UporderUser uporderUser = uporderUserService.getUserByName(username);
		 uporderOrderService.saveOrder(uporderUser,upOrderSaveParam);
		 return Result.OK("添加成功！");
	 }

	 @ApiOperation(value="报单端查询订单列表", notes="订单表-分页列表查询")
	 @GetMapping(value = "/h5/list")
	 @IgnoreAuth
	 public Result<IPage<UporderOrder>> h5List(UporderOrder uporderOrder,
													  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
													  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
													  HttpServletRequest req) {


		 String token = req.getHeader(CommonConstant.X_ACCESS_TOKEN);

		 String username = JwtUtil.getUsername(token);
		 UporderUser uporderUser = uporderUserService.getUserByName(username);

		 uporderOrder.setUserId(uporderUser.getId());
		 QueryWrapper<UporderOrder> queryWrapper = QueryGenerator.initQueryWrapper(uporderOrder, req.getParameterMap());
		 Page<UporderOrder> page = new Page<UporderOrder>(pageNo, pageSize);
		 IPage<UporderOrder> pageList = uporderOrderService.page(page, queryWrapper);
		 return Result.OK(pageList);
	 }

 }
