package org.jeecg.modules.uporder.product.service.impl;

import org.jeecg.modules.uporder.product.entity.UporderProductUserLimit;
import org.jeecg.modules.uporder.product.mapper.UporderProductUserLimitMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductUserLimitService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 报单产品用户额度表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@Service
public class UporderProductUserLimitServiceImpl extends ServiceImpl<UporderProductUserLimitMapper, UporderProductUserLimit> implements IUporderProductUserLimitService {
	
	@Autowired
	private UporderProductUserLimitMapper uporderProductUserLimitMapper;
	
	@Override
	public List<UporderProductUserLimit> selectByMainId(String mainId) {
		return uporderProductUserLimitMapper.selectByMainId(mainId);
	}
}
