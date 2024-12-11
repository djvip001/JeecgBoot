package org.jeecg.modules.uporder.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: 用户管理
 * @Author: jeecg-boot
 * @Date:   2024-12-11
 * @Version: V1.0
 */
public interface UporderUserMapper extends BaseMapper<UporderUser> {
    void recover(String id );

    List<UporderUser> delList(Page<UporderUser> page, @Param(Constants.WRAPPER) QueryWrapper<UporderUser> queryWrapper);

    UporderUser getUserByName(String username);
}
