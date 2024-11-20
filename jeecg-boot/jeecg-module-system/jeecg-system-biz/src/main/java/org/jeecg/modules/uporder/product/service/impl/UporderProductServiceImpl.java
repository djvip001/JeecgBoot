package org.jeecg.modules.uporder.product.service.impl;

import org.jeecg.modules.uporder.product.entity.UporderProduct;
import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.mapper.UporderProductMediumTextMapper;
import org.jeecg.modules.uporder.product.mapper.UporderProductTypeRefundConfigMapper;
import org.jeecg.modules.uporder.product.mapper.UporderProductMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-19
 * @Version: V1.0
 */
@Service
public class UporderProductServiceImpl extends ServiceImpl<UporderProductMapper, UporderProduct> implements IUporderProductService {

	@Autowired
	private UporderProductMapper uporderProductMapper;
	@Autowired
	private UporderProductMediumTextMapper uporderProductMediumTextMapper;
	@Autowired
	private UporderProductTypeRefundConfigMapper uporderProductTypeRefundConfigMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(UporderProduct uporderProduct, List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList) {
		uporderProductMapper.insert(uporderProduct);
		if(uporderProductMediumTextList!=null && uporderProductMediumTextList.size()>0) {
			for(UporderProductMediumText entity:uporderProductMediumTextList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductMediumTextMapper.insert(entity);
			}
		}
		if(uporderProductTypeRefundConfigList!=null && uporderProductTypeRefundConfigList.size()>0) {
			for(UporderProductTypeRefundConfig entity:uporderProductTypeRefundConfigList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductTypeRefundConfigMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(UporderProduct uporderProduct,List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList) {
		uporderProductMapper.updateById(uporderProduct);
		
		//1.先删除子表数据
		uporderProductMediumTextMapper.deleteByMainId(uporderProduct.getId());
		uporderProductTypeRefundConfigMapper.deleteByMainId(uporderProduct.getId());
		
		//2.子表数据重新插入
		if(uporderProductMediumTextList!=null && uporderProductMediumTextList.size()>0) {
			for(UporderProductMediumText entity:uporderProductMediumTextList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductMediumTextMapper.insert(entity);
			}
		}
		if(uporderProductTypeRefundConfigList!=null && uporderProductTypeRefundConfigList.size()>0) {
			for(UporderProductTypeRefundConfig entity:uporderProductTypeRefundConfigList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductTypeRefundConfigMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		uporderProductMediumTextMapper.deleteByMainId(id);
		uporderProductTypeRefundConfigMapper.deleteByMainId(id);
		uporderProductMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			uporderProductMediumTextMapper.deleteByMainId(id.toString());
			uporderProductTypeRefundConfigMapper.deleteByMainId(id.toString());
			uporderProductMapper.deleteById(id);
		}
	}
	
}
