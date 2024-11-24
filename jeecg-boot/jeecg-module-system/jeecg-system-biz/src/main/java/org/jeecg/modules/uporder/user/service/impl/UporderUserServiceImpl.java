package org.jeecg.modules.uporder.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import org.jeecg.modules.uporder.user.mapper.UporderUserMapper;
import org.jeecg.modules.uporder.user.service.IUporderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 报单用户表
 * @Author: jeecg-boot
 * @Date:   2024-11-16
 * @Version: V1.0
 */
@Service
public class UporderUserServiceImpl extends ServiceImpl<UporderUserMapper, UporderUser> implements IUporderUserService {

    @Autowired
    private UporderUserMapper uporderUserMapper;

    @Override
    public IPage<UporderUser> delList(Page<UporderUser> page, QueryWrapper<UporderUser> queryWrapper) {

        queryWrapper.apply(" del_flag=1");
        List<UporderUser> uporderUsers = uporderUserMapper.delList(page,queryWrapper);



        return page.setRecords(uporderUsers);
    }

    @Override
    public void recover(String uporderUser) {

        uporderUserMapper.recover(uporderUser);
    }
}
