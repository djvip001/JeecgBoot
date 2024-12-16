package org.jeecg.modules.uporder.product.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.uporder.product.vo.QueryActOrderStatVo;
import org.jeecg.modules.uporder.product.vo.UporderProductAction;
import org.jeecg.modules.uporder.user.entity.UporderUser;

import java.util.List;

/**
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
public interface UporderProductMapper extends BaseMapper<UporderProduct> {

    void recover(String id );

    List<UporderProduct> delList(Page<UporderProduct> page, @Param(Constants.WRAPPER) QueryWrapper<UporderProduct> queryWrapper);

    @InterceptorIgnore(tenantLine = "true")
    List<UporderProductAction> listAction(Page<UporderProductAction> page, @Param(Constants.WRAPPER) QueryWrapper<UporderProduct> queryWrapper);
    @InterceptorIgnore(tenantLine = "true")
    List<QueryActOrderStatVo> queryActOrderStat(Page<QueryActOrderStatVo> page, @Param(Constants.WRAPPER) QueryWrapper<UporderProduct> queryWrapper);
}
