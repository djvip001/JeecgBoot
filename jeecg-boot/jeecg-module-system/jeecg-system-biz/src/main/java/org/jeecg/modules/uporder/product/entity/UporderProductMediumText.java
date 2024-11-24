package org.jeecg.modules.uporder.product.entity;

import java.io.Serializable;
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
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 产品文本表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@ApiModel(value="uporder_product_medium_text对象", description="产品文本表")
@Data
@TableName("uporder_product_medium_text")
public class UporderProductMediumText implements Serializable {
    private static final long serialVersionUID = 1L;

	/**产品id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "产品id")
    private java.lang.String id;
	/**产品id*/
    @ApiModelProperty(value = "产品id")
    private java.lang.String productId;
	/**下单方案*/
	@Excel(name = "下单方案", width = 15)
    @ApiModelProperty(value = "下单方案")
    private java.lang.String planHtml;
	/**弹框提示*/
	@Excel(name = "弹框提示", width = 15)
    @ApiModelProperty(value = "弹框提示")
    private java.lang.String reportPopupsTip;
}
