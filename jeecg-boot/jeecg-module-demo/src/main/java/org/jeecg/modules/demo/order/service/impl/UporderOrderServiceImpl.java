package org.jeecg.modules.demo.order.service.impl;

import org.jeecg.modules.demo.order.entity.UporderOrder;
import org.jeecg.modules.demo.order.entity.UporderOrderTrafficNo;
import org.jeecg.modules.demo.order.mapper.UporderOrderTrafficNoMapper;
import org.jeecg.modules.demo.order.mapper.UporderOrderMapper;
import org.jeecg.modules.demo.order.service.IUporderOrderService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-29
 * @Version: V1.0
 */
@Service
public class UporderOrderServiceImpl extends ServiceImpl<UporderOrderMapper, UporderOrder> implements IUporderOrderService {

	@Autowired
	private UporderOrderMapper uporderOrderMapper;
	@Autowired
	private UporderOrderTrafficNoMapper uporderOrderTrafficNoMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(UporderOrder uporderOrder, List<UporderOrderTrafficNo> uporderOrderTrafficNoList) {
		uporderOrderMapper.insert(uporderOrder);
		if(uporderOrderTrafficNoList!=null && uporderOrderTrafficNoList.size()>0) {
			for(UporderOrderTrafficNo entity:uporderOrderTrafficNoList) {
				//外键设置
				entity.setOrderId(uporderOrder.getId());
				uporderOrderTrafficNoMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(UporderOrder uporderOrder,List<UporderOrderTrafficNo> uporderOrderTrafficNoList) {
		uporderOrderMapper.updateById(uporderOrder);
		
		//1.先删除子表数据
		uporderOrderTrafficNoMapper.deleteByMainId(uporderOrder.getId());
		
		//2.子表数据重新插入
		if(uporderOrderTrafficNoList!=null && uporderOrderTrafficNoList.size()>0) {
			for(UporderOrderTrafficNo entity:uporderOrderTrafficNoList) {
				//外键设置
				entity.setOrderId(uporderOrder.getId());
				uporderOrderTrafficNoMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		uporderOrderTrafficNoMapper.deleteByMainId(id);
		uporderOrderMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			uporderOrderTrafficNoMapper.deleteByMainId(id.toString());
			uporderOrderMapper.deleteById(id);
		}
	}
	
}
