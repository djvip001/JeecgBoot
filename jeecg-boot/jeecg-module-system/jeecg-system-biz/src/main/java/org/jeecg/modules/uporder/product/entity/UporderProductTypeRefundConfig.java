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
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 产品用户类型折扣表
 * @Author: jeecg-boot
 * @Date:   2024-11-19
 * @Version: V1.0
 */
@ApiModel(value="uporder_product_type_refund_config对象", description="产品用户类型折扣表")
@Data
@TableName("uporder_product_type_refund_config")
public class UporderProductTypeRefundConfig implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**产品id*/
    @ApiModelProperty(value = "产品id")
    private java.lang.String productId;
	/**用户类型id*/
	@Excel(name = "用户类型id", width = 15, dictTable = "uporder_user_type", dicText = "type_id", dicCode = "id")
    @ApiModelProperty(value = "用户类型id")
    @Dict(dictTable = "uporder_user_type", dicText = "type_id", dicCode = "id")
    private java.lang.String typeId;
	/**折扣*/
	@Excel(name = "折扣", width = 15)
    @ApiModelProperty(value = "折扣")
    private java.math.BigDecimal discount;
}
