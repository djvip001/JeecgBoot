package org.jeecg.modules.uporder.user.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * @Description: 报单用户表
 * @Author: jeecg-boot
 * @Date:   2024-11-16
 * @Version: V1.0
 */
@Data
@TableName("uporder_user")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="uporder_user对象", description="报单用户表")
public class UporderUser implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**账号*/
	@Excel(name = "账号", width = 15)
    @ApiModelProperty(value = "账号")
    private java.lang.String account;
	/**密码*/
	@Excel(name = "密码", width = 15)
    @ApiModelProperty(value = "密码")
    private java.lang.String password;
	/**账号类型*/
	@Excel(name = "账号类型", width = 15, dictTable = "uporder_user_type", dicText = "account_type", dicCode = "id")
	@Dict(dictTable = "uporder_user_type", dicText = "account_type", dicCode = "id")
    @ApiModelProperty(value = "账号类型")
    private java.lang.String accountType;
	/**支付宝账号*/
	@Excel(name = "支付宝账号", width = 15)
    @ApiModelProperty(value = "支付宝账号")
    private java.lang.String alipayAccount;
	/**支付宝姓名*/
	@Excel(name = "支付宝姓名", width = 15)
    @ApiModelProperty(value = "支付宝姓名")
    private java.lang.String alipayName;
	/**微信账号*/
	@Excel(name = "微信账号", width = 15)
    @ApiModelProperty(value = "微信账号")
    private java.lang.String wechatAccount;
	/**微信昵称*/
	@Excel(name = "微信昵称", width = 15)
    @ApiModelProperty(value = "微信昵称")
    private java.lang.String wechatName;
	/**最后报单时间*/
	@Excel(name = "最后报单时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后报单时间")
    private java.util.Date lastOrderTime;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "upoder_user_status")
	@Dict(dicCode = "upoder_user_status")
    @ApiModelProperty(value = "状态")
    private java.lang.Integer status;
	/**头像*/
	@Excel(name = "头像", width = 15)
    @ApiModelProperty(value = "头像")
    private java.lang.String headImage;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
    /**租户id*/
    @Excel(name = "租户id", width = 15)
    @ApiModelProperty(value = "租户id")
    private java.lang.String tenantId;
    /**部门*/
    @Excel(name = "部门", width = 15)
    @ApiModelProperty(value = "部门")
    private java.lang.String sysOrgCode;

	/**删除状态*/
	@Excel(name = "删除状态", width = 15)
    @ApiModelProperty(value = "删除状态")
    @TableLogic
    private java.lang.Integer delFlag;
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
