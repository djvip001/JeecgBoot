package org.jeecg.modules.uporder.config.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
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
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 报单配置表
 * @Author: jeecg-boot
 * @Date:   2024-11-17
 * @Version: V1.0
 */
@Data
@TableName("uporder_config")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="uporder_config对象", description="报单配置表")
public class UporderConfig implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**平台名称*/
	@Excel(name = "平台名称", width = 15)
    @ApiModelProperty(value = "平台名称")
    private java.lang.String platformName;
	/**上级名*/
	@Excel(name = "上级名", width = 15)
    @ApiModelProperty(value = "上级名")
    private java.lang.String upperName;
	/**报单账号*/
	@Excel(name = "报单账号", width = 15)
    @ApiModelProperty(value = "报单账号")
    private java.lang.String reportAccount;
	/**报单密码*/
	@Excel(name = "报单密码", width = 15)
    @ApiModelProperty(value = "报单密码")
    private java.lang.String reportPassword;
	/**主页*/
	@Excel(name = "主页", width = 15)
    @ApiModelProperty(value = "主页")
    private java.lang.String upperHome;
	/**是否平台*/
	@Excel(name = "是否平台", width = 15)
    @ApiModelProperty(value = "是否平台")
    private java.lang.Integer hasPlatform;
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
