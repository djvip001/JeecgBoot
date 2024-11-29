package org.jeecg.modules.uporder.product.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @author jin_deng
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UporderProductAction extends UporderProduct {


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
}
