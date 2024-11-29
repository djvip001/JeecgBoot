package org.jeecg.modules.uporder.product.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.system.service.ISysUserService;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.entity.UporderProductDefineField;
import org.jeecg.modules.uporder.product.entity.UporderProductUserLimit;
import org.jeecg.modules.uporder.product.entity.UporderProductBuyLink;
import org.jeecg.modules.uporder.product.mapper.UporderProductMediumTextMapper;
import org.jeecg.modules.uporder.product.mapper.UporderProductTypeRefundConfigMapper;
import org.jeecg.modules.uporder.product.mapper.UporderProductDefineFieldMapper;
import org.jeecg.modules.uporder.product.mapper.UporderProductUserLimitMapper;
import org.jeecg.modules.uporder.product.mapper.UporderProductBuyLinkMapper;
import org.jeecg.modules.uporder.product.mapper.UporderProductMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductService;
import org.jeecg.modules.uporder.product.vo.UporderProductAction;
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
 * @Date:   2024-11-21
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
	@Autowired
	private UporderProductDefineFieldMapper uporderProductDefineFieldMapper;
	@Autowired
	private UporderProductUserLimitMapper uporderProductUserLimitMapper;
	@Autowired
	private UporderProductBuyLinkMapper uporderProductBuyLinkMapper;

	@Autowired
	private ISysUserService sysUserService;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(UporderProduct uporderProduct, List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList,List<UporderProductDefineField> uporderProductDefineFieldList,List<UporderProductUserLimit> uporderProductUserLimitList,List<UporderProductBuyLink> uporderProductBuyLinkList) {
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
		if(uporderProductDefineFieldList!=null && uporderProductDefineFieldList.size()>0) {
			for(UporderProductDefineField entity:uporderProductDefineFieldList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductDefineFieldMapper.insert(entity);
			}
		}
		if(uporderProductUserLimitList!=null && uporderProductUserLimitList.size()>0) {
			for(UporderProductUserLimit entity:uporderProductUserLimitList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductUserLimitMapper.insert(entity);
			}
		}
		if(uporderProductBuyLinkList!=null && uporderProductBuyLinkList.size()>0) {
			for(UporderProductBuyLink entity:uporderProductBuyLinkList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductBuyLinkMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(UporderProduct uporderProduct,List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList,List<UporderProductDefineField> uporderProductDefineFieldList,List<UporderProductUserLimit> uporderProductUserLimitList,List<UporderProductBuyLink> uporderProductBuyLinkList) {
		uporderProductMapper.updateById(uporderProduct);
		
		//1.先删除子表数据
		uporderProductMediumTextMapper.deleteByMainId(uporderProduct.getId());
		uporderProductTypeRefundConfigMapper.deleteByMainId(uporderProduct.getId());
		uporderProductDefineFieldMapper.deleteByMainId(uporderProduct.getId());
		uporderProductUserLimitMapper.deleteByMainId(uporderProduct.getId());
		uporderProductBuyLinkMapper.deleteByMainId(uporderProduct.getId());
		
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
		if(uporderProductDefineFieldList!=null && uporderProductDefineFieldList.size()>0) {
			for(UporderProductDefineField entity:uporderProductDefineFieldList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductDefineFieldMapper.insert(entity);
			}
		}
		if(uporderProductUserLimitList!=null && uporderProductUserLimitList.size()>0) {
			for(UporderProductUserLimit entity:uporderProductUserLimitList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductUserLimitMapper.insert(entity);
			}
		}
		if(uporderProductBuyLinkList!=null && uporderProductBuyLinkList.size()>0) {
			for(UporderProductBuyLink entity:uporderProductBuyLinkList) {
				//外键设置
				entity.setProductId(uporderProduct.getId());
				uporderProductBuyLinkMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		uporderProductMediumTextMapper.deleteByMainId(id);
		uporderProductTypeRefundConfigMapper.deleteByMainId(id);
		uporderProductDefineFieldMapper.deleteByMainId(id);
		uporderProductUserLimitMapper.deleteByMainId(id);
		uporderProductBuyLinkMapper.deleteByMainId(id);
		uporderProductMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			uporderProductMediumTextMapper.deleteByMainId(id.toString());
			uporderProductTypeRefundConfigMapper.deleteByMainId(id.toString());
			uporderProductDefineFieldMapper.deleteByMainId(id.toString());
			uporderProductUserLimitMapper.deleteByMainId(id.toString());
			uporderProductBuyLinkMapper.deleteByMainId(id.toString());
			uporderProductMapper.deleteById(id);
		}
	}


	@Override
	public IPage<UporderProduct> delList(Page<UporderProduct> page, QueryWrapper<UporderProduct> queryWrapper) {

		queryWrapper.apply(" del_flag=1");
		List<UporderProduct> uporderProduct = uporderProductMapper.delList(page,queryWrapper);



		return page.setRecords(uporderProduct);
	}

	@Override
	public void recover(String uporderUser) {

		uporderProductMapper.recover(uporderUser);
	}

	@Override
	public IPage<UporderProductAction> listAction(Page<UporderProductAction> page, QueryWrapper<UporderProduct> queryWrapper) {

		List<UporderProductAction> uporderProduct = uporderProductMapper.listAction(page,queryWrapper);
		uporderProduct.forEach(u->{
			String domain = u.getDomain();
			String orderFormUrl;
			if (StrUtil.startWith(domain, "http")) {
				orderFormUrl=domain+"/uporder/link/h5/order/upload/"+u.getId();
			}else {
				orderFormUrl="http://"+domain+"/uporder/link/h5/order/upload/"+u.getId();

			}

			u.setOrderFormUrl(orderFormUrl);
		});
		return page.setRecords(uporderProduct);
	}

}
