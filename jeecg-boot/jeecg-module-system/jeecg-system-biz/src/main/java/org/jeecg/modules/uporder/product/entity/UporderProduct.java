package org.jeecg.modules.uporder.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-28
 * @Version: V1.0
 */
@ApiModel(value="uporder_product对象", description="产品表")
@Data
@TableName("uporder_product")
public class UporderProduct implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**项目*/
	@Excel(name = "项目", width = 15, dictTable = "uporder_project", dicText = "project_name", dicCode = "id")
    @Dict(dictTable = "uporder_project", dicText = "project_name", dicCode = "id")
    @ApiModelProperty(value = "项目")
    private String projectId;
	/**产品名*/
	@Excel(name = "产品名", width = 15)
    @ApiModelProperty(value = "产品名")
    private String productName;
	/**总额度*/
	@Excel(name = "总额度", width = 15)
    @ApiModelProperty(value = "总额度")
    private java.math.BigDecimal totalLimitMoney;
	/**购买链接*/
	@Excel(name = "购买链接", width = 15)
    @ApiModelProperty(value = "购买链接")
    private String buyUrl;
	/**描述*/
	@Excel(name = "描述", width = 15)
    @ApiModelProperty(value = "描述")
    private String description;
	/**管理员备注*/
	@Excel(name = "管理员备注", width = 15)
    @ApiModelProperty(value = "管理员备注")
    private String note;
	/**剩余额度*/
	@Excel(name = "剩余额度", width = 15)
    @ApiModelProperty(value = "剩余额度")
    private java.math.BigDecimal leftLimitMoney;
	/**返款计算方式*/
	@Excel(name = "返款计算方式", width = 15, dicCode = "refund_cal_way")
    @Dict(dicCode = "refund_cal_way")
    @ApiModelProperty(value = "返款计算方式")
    private Integer refundCalWay;
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
    private String upperConfigId;
	/**上级报单链接*/
	@Excel(name = "上级报单链接", width = 15)
    @ApiModelProperty(value = "上级报单链接")
    private String upperReportUrl;
	/**是否跟上级额度*/
	@Excel(name = "是否跟上级额度", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否跟上级额度")
    private Integer validUpperLimit;
	/**关闭自动推单*/
	@Excel(name = "关闭自动推单", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "关闭自动推单")
    private Integer closeAutoPush;
	/**关闭自动申请返款*/
	@Excel(name = "关闭自动申请返款", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "关闭自动申请返款")
    private Integer closeAutoRefund;
	/**上架状态*/
	@Excel(name = "上架状态", width = 15, dicCode = "shelf_status")
    @Dict(dicCode = "shelf_status")
    @ApiModelProperty(value = "上架状态")
    private Integer shelf;
	/**是否显示配额*/
	@Excel(name = "是否显示配额", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否显示配额")
    private Integer showQuota;
	/**是否活动页显示*/
	@Excel(name = "是否活动页显示", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否活动页显示")
    private Integer showAct;
	/**是否预售*/
	@Excel(name = "是否预售", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否预售")
    private Integer presale;
	/**是否收集评价图*/
	@Excel(name = "是否收集评价图", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否收集评价图")
    private Integer collectEvaluateImg;
	/**是否收集物流单号*/
	@Excel(name = "是否收集物流单号", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否收集物流单号")
    private Integer collectTrafficNo;
	/**是否刷货产品*/
	@Excel(name = "是否刷货产品", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否刷货产品")
    private Integer shuahuo;
	/**是否完结*/
	@Excel(name = "是否完结", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否完结")
    private Integer settlement;
	/**最大报单时间*/
	@Excel(name = "最大报单时间", width = 15)
    @ApiModelProperty(value = "最大报单时间")
    private Integer maxReportInterval;
	/**隐藏字段*/
	@Excel(name = "隐藏字段", width = 15)
    @ApiModelProperty(value = "隐藏字段")
    private String reportHiddenFields;
	/**开始报单时间*/
	@Excel(name = "开始报单时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始报单时间")
    private Date starTime;
	/**结束报单时间*/
	@Excel(name = "结束报单时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束报单时间")
    private Date endTime;
	/**返款规则*/
	@Excel(name = "返款规则", width = 15)
    @ApiModelProperty(value = "返款规则")
    private String refundRule;
	/**删除状态*/
	@Excel(name = "删除状态", width = 15)
    @ApiModelProperty(value = "删除状态")
    @TableLogic
    private Integer delFlag;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**部门*/
    @ApiModelProperty(value = "部门")
    private String sysOrgCode;
	/**租户id*/
	@Excel(name = "租户id", width = 15)
    @ApiModelProperty(value = "租户id")
    private String tenantId;
}
