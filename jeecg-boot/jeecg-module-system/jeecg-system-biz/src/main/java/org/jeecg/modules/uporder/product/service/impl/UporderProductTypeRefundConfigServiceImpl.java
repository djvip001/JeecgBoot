package org.jeecg.modules.uporder.product.service.impl;

import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.mapper.UporderProductTypeRefundConfigMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductTypeRefundConfigService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 产品用户类型折扣表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@Service
public class UporderProductTypeRefundConfigServiceImpl extends ServiceImpl<UporderProductTypeRefundConfigMapper, UporderProductTypeRefundConfig> implements IUporderProductTypeRefundConfigService {
	
	@Autowired
	private UporderProductTypeRefundConfigMapper uporderProductTypeRefundConfigMapper;
	
	@Override
	public List<UporderProductTypeRefundConfig> selectByMainId(String mainId) {
		return uporderProductTypeRefundConfigMapper.selectByMainId(mainId);
	}
}
