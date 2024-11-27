package org.jeecg.modules.uporder.order.vo;

import java.util.List;

import org.jeecg.modules.uporder.order.entity.UporderOrderTrafficNo;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-25
 * @Version: V1.0
 */
@Data
@ApiModel(value="uporder_orderPage对象", description="订单表")
public class UporderOrderPage {

	/**id*/
	@ApiModelProperty(value = "id")
    private java.lang.String id;
	/**报单人id*/
	@Excel(name = "报单人id", width = 15)
	@ApiModelProperty(value = "报单人id")
    private java.lang.String userId;
	/**报单人账号*/
	@Excel(name = "报单人账号", width = 15)
	@ApiModelProperty(value = "报单人账号")
    private java.lang.String account;
	/**产品id*/
	@Excel(name = "产品id", width = 15)
	@ApiModelProperty(value = "产品id")
    private java.lang.String productId;
	/**数量*/
	@Excel(name = "数量", width = 15)
	@ApiModelProperty(value = "数量")
    private java.lang.Integer mcount;
	/**报单金额*/
	@Excel(name = "报单金额", width = 15)
	@ApiModelProperty(value = "报单金额")
    private java.math.BigDecimal price;
	/**订单号*/
	@Excel(name = "订单号", width = 15)
	@ApiModelProperty(value = "订单号")
    private java.lang.String orderNo;
	/**备注*/
	@Excel(name = "备注", width = 15)
	@ApiModelProperty(value = "备注")
    private java.lang.String customerNote;
	/**订单图*/
	@Excel(name = "订单图", width = 15)
	@ApiModelProperty(value = "订单图")
    private java.lang.String imgPath;
	/**评价图*/
	@Excel(name = "评价图", width = 15)
	@ApiModelProperty(value = "评价图")
    private java.lang.String commentImg;
	/**尾款图*/
	@Excel(name = "尾款图", width = 15)
	@ApiModelProperty(value = "尾款图")
    private java.lang.String finalPayImg;
	/**完成图*/
	@Excel(name = "完成图", width = 15)
	@ApiModelProperty(value = "完成图")
    private java.lang.String orderCompleteImg;
	/**订单状态*/
	@Excel(name = "订单状态", width = 15, dicCode = "up_order_status")
    @Dict(dicCode = "up_order_status")
	@ApiModelProperty(value = "订单状态")
    private java.lang.Integer orderStatus;
	/**上级单状态*/
	@Excel(name = "上级单状态", width = 15, dicCode = "up_order_status")
    @Dict(dicCode = "up_order_status")
	@ApiModelProperty(value = "上级单状态")
    private java.lang.Integer upperOrderStatus;
	/**渠道状态*/
	@Excel(name = "渠道状态", width = 15, dicCode = "upper_channel_status")
    @Dict(dicCode = "upper_channel_status")
	@ApiModelProperty(value = "渠道状态")
    private java.lang.Integer upperChannelStatus;
	/**实付金额*/
	@Excel(name = "实付金额", width = 15)
	@ApiModelProperty(value = "实付金额")
    private java.math.BigDecimal actualPayMoney;
	/**折扣*/
	@Excel(name = "折扣", width = 15)
	@ApiModelProperty(value = "折扣")
    private java.math.BigDecimal discount;
	/**税率*/
	@Excel(name = "税率", width = 15)
	@ApiModelProperty(value = "税率")
    private java.math.BigDecimal taxRate;
	/**税费*/
	@Excel(name = "税费", width = 15)
	@ApiModelProperty(value = "税费")
    private java.math.BigDecimal taxFee;
	/**返款计算方式*/
	@Excel(name = "返款计算方式", width = 15, dicCode = "refund_cal_way")
    @Dict(dicCode = "refund_cal_way")
	@ApiModelProperty(value = "返款计算方式")
    private java.lang.Integer refundCalWay;
	/**返款额*/
	@Excel(name = "返款额", width = 15)
	@ApiModelProperty(value = "返款额")
    private java.math.BigDecimal refundMoney;
	/**进价计算方式*/
	@Excel(name = "进价计算方式", width = 15, dicCode = "refund_cal_way")
    @Dict(dicCode = "refund_cal_way")
	@ApiModelProperty(value = "进价计算方式")
    private java.lang.Integer inRefundCalWay;
	/**进价折扣*/
	@Excel(name = "进价折扣", width = 15)
	@ApiModelProperty(value = "进价折扣")
    private java.math.BigDecimal inDiscount;
	/**上级返款*/
	@Excel(name = "上级返款", width = 15)
	@ApiModelProperty(value = "上级返款")
    private java.math.BigDecimal inFefundMoney;
	/**利润*/
	@Excel(name = "利润", width = 15)
	@ApiModelProperty(value = "利润")
    private java.math.BigDecimal profit;
	/**付款时间*/
	@Excel(name = "付款时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "付款时间")
    private java.util.Date payTime;
	/**报单给上级时间*/
	@Excel(name = "报单给上级时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "报单给上级时间")
    private java.util.Date reportUpperTime;
	/**向上级申请返款时间*/
	@Excel(name = "向上级申请返款时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "向上级申请返款时间")
    private java.util.Date refundUpperTime;
	/**上级返款时间*/
	@Excel(name = "上级返款时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "上级返款时间")
    private java.util.Date inRefundTime;
	/**上级打款方式*/
	@Excel(name = "上级打款方式", width = 15, dicCode = "refund_pay_way")
    @Dict(dicCode = "refund_pay_way")
	@ApiModelProperty(value = "上级打款方式")
    private java.lang.Integer inRefundPayWay;
	/**上级打款备注*/
	@Excel(name = "上级打款备注", width = 15)
	@ApiModelProperty(value = "上级打款备注")
    private java.lang.String inFefundNote;
	/**返款申请时间*/
	@Excel(name = "返款申请时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "返款申请时间")
    private java.util.Date refundSubmitTime;
	/**预计打款时间*/
	@Excel(name = "预计打款时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "预计打款时间")
    private java.util.Date estimatePaymentTime;
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

	@ExcelCollection(name="订单物流表")
	@ApiModelProperty(value = "订单物流表")
	private List<UporderOrderTrafficNo> uporderOrderTrafficNoList;

}
