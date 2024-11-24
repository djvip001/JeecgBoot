package org.jeecg.modules.uporder.product.vo;

import java.util.List;

import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.entity.UporderProductDefineField;
import org.jeecg.modules.uporder.product.entity.UporderProductUserLimit;
import org.jeecg.modules.uporder.product.entity.UporderProductBuyLink;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@Data
@ApiModel(value="uporder_productPage对象", description="产品表")
public class UporderProductPage {

	/**id*/
	@ApiModelProperty(value = "id")
    private java.lang.String id;
	/**项目*/
	@Excel(name = "项目", width = 15, dictTable = "uporder_project", dicText = "project_name", dicCode = "id")
    @Dict(dictTable = "uporder_project", dicText = "project_name", dicCode = "id")
	@ApiModelProperty(value = "项目")
    private java.lang.String projectId;
	/**产品名*/
	@Excel(name = "产品名", width = 15)
	@ApiModelProperty(value = "产品名")
    private java.lang.String productName;
	/**总额度*/
	@Excel(name = "总额度", width = 15)
	@ApiModelProperty(value = "总额度")
    private java.math.BigDecimal totalLimitMoney;
	/**购买链接*/
	@Excel(name = "购买链接", width = 15)
	@ApiModelProperty(value = "购买链接")
    private java.lang.String buyUrl;
	/**描述*/
	@Excel(name = "描述", width = 15)
	@ApiModelProperty(value = "描述")
    private java.lang.String description;
	/**管理员备注*/
	@Excel(name = "管理员备注", width = 15)
	@ApiModelProperty(value = "管理员备注")
    private java.lang.String note;
	/**剩余额度*/
	@Excel(name = "剩余额度", width = 15)
	@ApiModelProperty(value = "剩余额度")
    private java.math.BigDecimal leftLimitMoney;
	/**返款计算方式*/
	@Excel(name = "返款计算方式", width = 15, dicCode = "refund_cal_way")
    @Dict(dicCode = "refund_cal_way")
	@ApiModelProperty(value = "返款计算方式")
    private java.lang.Integer refundCalWay;
	/**默认成本*/
	@Excel(name = "默认成本", width = 15)
	@ApiModelProperty(value = "默认成本")
    private java.math.BigDecimal discount;
	/**税率*/
	@Excel(name = "税率", width = 15)
	@ApiModelProperty(value = "税率")
    private java.math.BigDecimal taxRate;
	/**进价成本*/
	@Excel(name = "进价成本", width = 15)
	@ApiModelProperty(value = "进价成本")
    private java.math.BigDecimal inDiscount;
	/**报单上级*/
	@Excel(name = "报单上级", width = 15, dictTable = "uporder_config", dicText = "upper_name", dicCode = "id")
    @Dict(dictTable = "uporder_config", dicText = "upper_name", dicCode = "id")
	@ApiModelProperty(value = "报单上级")
    private java.lang.String upperConfigId;
	/**上级报单链接*/
	@Excel(name = "上级报单链接", width = 15)
	@ApiModelProperty(value = "上级报单链接")
    private java.lang.String upperReportUrl;
	/**是否跟上级额度*/
	@ApiModelProperty(value = "是否跟上级额度")
    @Excel(name = "是否跟上级额度", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer validUpperLimit;
	/**关闭自动推单*/
	@ApiModelProperty(value = "关闭自动推单")
    @Excel(name = "关闭自动推单", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer closeAutoPush;
	/**关闭自动申请返款*/
	@ApiModelProperty(value = "关闭自动申请返款")
    @Excel(name = "关闭自动申请返款", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer closeAutoRefund;
	/**上架状态*/
	@ApiModelProperty(value = "上架状态")
    @Excel(name = "上架状态", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer shelf;
	/**是否显示配额*/
	@ApiModelProperty(value = "是否显示配额")
    @Excel(name = "是否显示配额", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer showQuota;
	/**是否活动页显示*/
	@ApiModelProperty(value = "是否活动页显示")
    @Excel(name = "是否活动页显示", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer showAct;
	/**是否预售*/
	@ApiModelProperty(value = "是否预售")
    @Excel(name = "是否预售", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer presale;
	/**是否收集评价图*/
	@ApiModelProperty(value = "是否收集评价图")
    @Excel(name = "是否收集评价图", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer collectEvaluateImg;
	/**是否收集物流单号*/
	@ApiModelProperty(value = "是否收集物流单号")
    @Excel(name = "是否收集物流单号", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer collectTrafficNo;
	/**是否刷货产品*/
	@ApiModelProperty(value = "是否刷货产品")
    @Excel(name = "是否刷货产品", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer shuahuo;
	/**是否完结*/
	@ApiModelProperty(value = "是否完结")
    @Excel(name = "是否完结", width = 15,replace = {"是_1","否_0"} )
    private java.lang.Integer settlement;
	/**最大报单时间*/
	@Excel(name = "最大报单时间", width = 15)
	@ApiModelProperty(value = "最大报单时间")
    private java.lang.Integer maxReportInterval;
	/**隐藏字段*/
	@Excel(name = "隐藏字段", width = 15)
	@ApiModelProperty(value = "隐藏字段")
    private java.lang.String reportHiddenFields;
	/**开始报单时间*/
	@Excel(name = "开始报单时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "开始报单时间")
    private java.util.Date starTime;
	/**结束报单时间*/
	@Excel(name = "结束报单时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "结束报单时间")
    private java.util.Date endTime;
	/**返款规则*/
	@Excel(name = "返款规则", width = 15)
	@ApiModelProperty(value = "返款规则")
    private java.lang.String refundRule;
	/**租户id*/
	@Excel(name = "租户id", width = 15)
	@ApiModelProperty(value = "租户id")
    private java.lang.String tenantId;
	/**创建人*/
	@ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
	@ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;

	@ExcelCollection(name="产品文本表")
	@ApiModelProperty(value = "产品文本表")
	private List<UporderProductMediumText> uporderProductMediumTextList;
	@ExcelCollection(name="产品用户类型折扣表")
	@ApiModelProperty(value = "产品用户类型折扣表")
	private List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList;
	@ExcelCollection(name="产品自定义字段表")
	@ApiModelProperty(value = "产品自定义字段表")
	private List<UporderProductDefineField> uporderProductDefineFieldList;
	@ExcelCollection(name="报单产品用户额度表")
	@ApiModelProperty(value = "报单产品用户额度表")
	private List<UporderProductUserLimit> uporderProductUserLimitList;
	@ExcelCollection(name="报单产品购买链接")
	@ApiModelProperty(value = "报单产品购买链接")
	private List<UporderProductBuyLink> uporderProductBuyLinkList;

}
