package org.jeecg.modules.uporder.product.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.common.aspect.annotation.Dict;

import java.math.BigDecimal;

/**
 * @author jin_deng
 */
@Data
public class QueryActOrderStatVo {

    private String id;

    private String productName;
    private String userId;

    @ApiModelProperty(value = "总额度")
    private java.math.BigDecimal totalLimitMoney;

    @ApiModelProperty(value = "剩余额度")
    private java.math.BigDecimal leftLimitMoney;

    @Dict(dicCode = "refund_cal_way")
    @ApiModelProperty(value = "返款计算方式")
    private Integer refundCalWay;

    @ApiModelProperty(value = "默认成本")
    private java.math.BigDecimal discount;

    @ApiModelProperty(value = "是否有方案")
    private int hasPlan;

    @ApiModelProperty(value = "下单方案")
    private java.lang.String planHtml;

    @ApiModelProperty(value = "弹框提示")
    private java.lang.String reportPopupsTip;

    @ApiModelProperty(value = "报单域名")
    private java.lang.String domain;

    @ApiModelProperty(value = "报单地址")
    private java.lang.String orderFormUrl;

    @ApiModelProperty(value = "购买链接")
    private String buyUrl;

    @ApiModelProperty(value = "订单数")
    private int orderNum;

    @ApiModelProperty(value = "总报单金额")
    private BigDecimal totalPrice;
}
