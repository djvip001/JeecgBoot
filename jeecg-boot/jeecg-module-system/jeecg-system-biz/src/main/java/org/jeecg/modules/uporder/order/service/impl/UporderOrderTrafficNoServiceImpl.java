package org.jeecg.modules.uporder.order.service.impl;

import org.jeecg.modules.uporder.order.entity.UporderOrderTrafficNo;
import org.jeecg.modules.uporder.order.mapper.UporderOrderTrafficNoMapper;
import org.jeecg.modules.uporder.order.service.IUporderOrderTrafficNoService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 订单物流表
 * @Author: jeecg-boot
 * @Date:   2024-11-25
 * @Version: V1.0
 */
@Service
public class UporderOrderTrafficNoServiceImpl extends ServiceImpl<UporderOrderTrafficNoMapper, UporderOrderTrafficNo> implements IUporderOrderTrafficNoService {
	
	@Autowired
	private UporderOrderTrafficNoMapper uporderOrderTrafficNoMapper;
	
	@Override
	public List<UporderOrderTrafficNo> selectByMainId(String mainId) {
		return uporderOrderTrafficNoMapper.selectByMainId(mainId);
	}
}
