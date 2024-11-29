package org.jeecg.modules.demo.order.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-29
 * @Version: V1.0
 */
@ApiModel(value="uporder_order对象", description="订单表")
@Data
@TableName("uporder_order")
public class UporderOrder implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**报单人id*/
	@Excel(name = "报单人id", width = 15, dictTable = "uporder_user", dicText = "account", dicCode = "id")
    @Dict(dictTable = "uporder_user", dicText = "account", dicCode = "id")
    @ApiModelProperty(value = "报单人id")
    private java.lang.String userId;
	/**产品id*/
	@Excel(name = "产品id", width = 15, dictTable = "uporder_product  where del_flag=0", dicText = "product_name", dicCode = "id")
    @Dict(dictTable = "uporder_product  where del_flag=0", dicText = "product_name", dicCode = "id")
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
	/**实付金额*/
	@Excel(name = "实付金额", width = 15)
    @ApiModelProperty(value = "实付金额")
    private java.math.BigDecimal actualPayMoney;
	/**付款时间*/
	@Excel(name = "付款时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "付款时间")
    private java.util.Date payTime;
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
	/**返款状态*/
	@Excel(name = "返款状态", width = 15, dicCode = "refund_status")
    @Dict(dicCode = "refund_status")
    @ApiModelProperty(value = "返款状态")
    private java.lang.Integer refundStatus;
	/**返款申请时间*/
	@Excel(name = "返款申请时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "返款申请时间")
    private java.util.Date refundSubmitTime;
	/**返款审核时间*/
	@Excel(name = "返款审核时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "返款审核时间")
    private java.util.Date refundAuditTime;
	/**返款审核状态*/
	@Excel(name = "返款审核状态", width = 15, dicCode = "audit_status")
    @Dict(dicCode = "audit_status")
    @ApiModelProperty(value = "返款审核状态")
    private java.lang.String auditStatus;
	/**返款失败原因*/
	@Excel(name = "返款失败原因", width = 15)
    @ApiModelProperty(value = "返款失败原因")
    private java.lang.String auditFailReason;
	/**预计打款时间*/
	@Excel(name = "预计打款时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "预计打款时间")
    private java.util.Date estimatePaymentTime;
	/**返款打款方式*/
	@Excel(name = "返款打款方式", width = 15, dicCode = "refund_pay_way")
    @Dict(dicCode = "refund_pay_way")
    @ApiModelProperty(value = "返款打款方式")
    private java.lang.Integer refundPayWay;
	/**返款打款备注*/
	@Excel(name = "返款打款备注", width = 15)
    @ApiModelProperty(value = "返款打款备注")
    private java.lang.String refundNote;
	/**确定打款时间*/
	@Excel(name = "确定打款时间", width = 15)
    @ApiModelProperty(value = "确定打款时间")
    private java.lang.String confirmRefundTime;
	/**进价折扣*/
	@Excel(name = "进价折扣", width = 15)
    @ApiModelProperty(value = "进价折扣")
    private java.math.BigDecimal inDiscount;
	/**进价计算方式*/
	@Excel(name = "进价计算方式", width = 15, dicCode = "refund_cal_way")
    @Dict(dicCode = "refund_cal_way")
    @ApiModelProperty(value = "进价计算方式")
    private java.lang.Integer inRefundCalWay;
	/**上级返款*/
	@Excel(name = "上级返款", width = 15)
    @ApiModelProperty(value = "上级返款")
    private java.math.BigDecimal inFefundMoney;
	/**利润*/
	@Excel(name = "利润", width = 15)
    @ApiModelProperty(value = "利润")
    private java.math.BigDecimal profit;
	/**渠道状态*/
	@Excel(name = "渠道状态", width = 15, dicCode = "upper_channel_status")
    @Dict(dicCode = "upper_channel_status")
    @ApiModelProperty(value = "渠道状态")
    private java.lang.Integer upperChannelStatus;
	/**上级打款方式*/
	@Excel(name = "上级打款方式", width = 15, dicCode = "refund_pay_way")
    @Dict(dicCode = "refund_pay_way")
    @ApiModelProperty(value = "上级打款方式")
    private java.lang.Integer inRefundPayWay;
	/**上级返款时间*/
	@Excel(name = "上级返款时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上级返款时间")
    private java.util.Date inRefundTime;
	/**上级打款备注*/
	@Excel(name = "上级打款备注", width = 15)
    @ApiModelProperty(value = "上级打款备注")
    private java.lang.String inRefundNote;
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
}
