package org.jeecg.modules.uporder.config.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.uporder.config.entity.UporderConfig;
import org.jeecg.modules.uporder.config.service.IUporderConfigService;

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
 * @Description: 上级配置
 * @Author: jeecg-boot
 * @Date:   2024-12-11
 * @Version: V1.0
 */
@Api(tags="上级配置")
@RestController
@RequestMapping("/config/uporderConfig")
@Slf4j
public class UporderConfigController extends JeecgController<UporderConfig, IUporderConfigService> {
	@Autowired
	private IUporderConfigService uporderConfigService;
	
	/**
	 * 分页列表查询
	 *
	 * @param uporderConfig
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "上级配置-分页列表查询")
	@ApiOperation(value="上级配置-分页列表查询", notes="上级配置-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<UporderConfig>> queryPageList(UporderConfig uporderConfig,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<UporderConfig> queryWrapper = QueryGenerator.initQueryWrapper(uporderConfig, req.getParameterMap());
		Page<UporderConfig> page = new Page<UporderConfig>(pageNo, pageSize);
		IPage<UporderConfig> pageList = uporderConfigService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param uporderConfig
	 * @return
	 */
	@AutoLog(value = "上级配置-添加")
	@ApiOperation(value="上级配置-添加", notes="上级配置-添加")
	@RequiresPermissions("config:uporder_config:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody UporderConfig uporderConfig) {
		uporderConfigService.save(uporderConfig);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param uporderConfig
	 * @return
	 */
	@AutoLog(value = "上级配置-编辑")
	@ApiOperation(value="上级配置-编辑", notes="上级配置-编辑")
	@RequiresPermissions("config:uporder_config:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody UporderConfig uporderConfig) {
		uporderConfigService.updateById(uporderConfig);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "上级配置-通过id删除")
	@ApiOperation(value="上级配置-通过id删除", notes="上级配置-通过id删除")
	@RequiresPermissions("config:uporder_config:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		uporderConfigService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "上级配置-批量删除")
	@ApiOperation(value="上级配置-批量删除", notes="上级配置-批量删除")
	@RequiresPermissions("config:uporder_config:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uporderConfigService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "上级配置-通过id查询")
	@ApiOperation(value="上级配置-通过id查询", notes="上级配置-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<UporderConfig> queryById(@RequestParam(name="id",required=true) String id) {
		UporderConfig uporderConfig = uporderConfigService.getById(id);
		if(uporderConfig==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(uporderConfig);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param uporderConfig
    */
    @RequiresPermissions("config:uporder_config:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, UporderConfig uporderConfig) {
        return super.exportXls(request, uporderConfig, UporderConfig.class, "上级配置");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("config:uporder_config:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, UporderConfig.class);
    }

}
