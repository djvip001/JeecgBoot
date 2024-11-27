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
 * @Description: 产品自定义字段表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@ApiModel(value="uporder_product_define_field对象", description="产品自定义字段表")
@Data
@TableName("uporder_product_define_field")
public class UporderProductDefineField implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**产品id*/
    @ApiModelProperty(value = "产品id")
    private java.lang.String productId;
	/**字段名*/
	@Excel(name = "字段名", width = 15)
    @ApiModelProperty(value = "字段名")
    private java.lang.String fieldName;
	/**字段类型*/
	@Excel(name = "字段类型", width = 15, dicCode = "field_type")
    @ApiModelProperty(value = "字段类型")
    private java.lang.String fieldType;
	/**字段标签*/
	@Excel(name = "字段标签", width = 15)
    @ApiModelProperty(value = "字段标签")
    private java.lang.String fieldLabel;
	/**是否必填*/
    @Excel(name = "是否必填", width = 15,replace = {"是_1","否_0"} )
    @ApiModelProperty(value = "是否必填")
    private java.lang.Integer required;
	/**可选值*/
	@Excel(name = "可选值", width = 15)
    @ApiModelProperty(value = "可选值")
    private java.lang.String optionValue;
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
    /**租户id*/
    @Excel(name = "租户id", width = 15)
    @ApiModelProperty(value = "租户id")
    private java.lang.String tenantId;
    /**部门*/
    @Excel(name = "部门", width = 15)
    @ApiModelProperty(value = "部门")
    private java.lang.String sysOrgCode;
}
