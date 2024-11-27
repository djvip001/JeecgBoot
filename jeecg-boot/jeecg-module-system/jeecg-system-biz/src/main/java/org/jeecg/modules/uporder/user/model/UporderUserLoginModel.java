package org.jeecg.modules.uporder.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jin_deng
 */
@ApiModel(value="报单用户登录对象", description="报单用户登录对象")
public class UporderUserLoginModel {

    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
