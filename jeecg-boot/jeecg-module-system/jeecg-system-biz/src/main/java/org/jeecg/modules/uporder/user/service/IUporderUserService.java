package org.jeecg.modules.uporder.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 用户管理
 * @Author: jeecg-boot
 * @Date:   2024-12-11
 * @Version: V1.0
 */
public interface IUporderUserService extends IService<UporderUser> {

    IPage<UporderUser> delList(Page<UporderUser> page, QueryWrapper<UporderUser> queryWrapper);

    void recover(String id);

    Result checkUserIsEffective(UporderUser uporderUser);

    UporderUser getUserByName(String username);
}
