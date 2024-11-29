package org.jeecg.modules.uporder.order.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.modules.uporder.order.entity.UporderOrderTrafficNo;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-25
 * @Version: V1.0
 */
@Data
@ApiModel(value="订单上报参数", description="订单上报参数")
public class UpOrderSaveParam {


	@ApiModelProperty(value = "产品id")
    private String productId;

	@ApiModelProperty(value = "数量")
    private Integer mcount;

	@ApiModelProperty(value = "报单金额")
    private BigDecimal price;

	@ApiModelProperty(value = "订单号")
    private String orderNo;

	@ApiModelProperty(value = "备注")
    private String customerNote;

	@ApiModelProperty(value = "订单图")
    private String imgPath;

	@ApiModelProperty(value = "评价图")
    private String commentImg;

	@ApiModelProperty(value = "尾款图")
    private String finalPayImg;

	@ApiModelProperty(value = "完成图")
    private String orderCompleteImg;



}
