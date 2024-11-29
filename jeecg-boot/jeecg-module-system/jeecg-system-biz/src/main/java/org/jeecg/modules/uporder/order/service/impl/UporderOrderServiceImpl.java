package org.jeecg.modules.uporder.order.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjUtil;
import org.jeecg.modules.uporder.order.entity.UporderOrder;
import org.jeecg.modules.uporder.order.entity.UporderOrderTrafficNo;
import org.jeecg.modules.uporder.order.mapper.UporderOrderTrafficNoMapper;
import org.jeecg.modules.uporder.order.mapper.UporderOrderMapper;
import org.jeecg.modules.uporder.order.service.IUporderOrderService;
import org.jeecg.modules.uporder.order.vo.UpOrderSaveParam;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.mapper.UporderProductTypeRefundConfigMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductService;
import org.jeecg.modules.uporder.user.entity.UporderUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-25
 * @Version: V1.0
 */
@Service
public class UporderOrderServiceImpl extends ServiceImpl<UporderOrderMapper, UporderOrder> implements IUporderOrderService {

	@Autowired
	private UporderOrderMapper uporderOrderMapper;
	@Autowired
	private UporderOrderTrafficNoMapper uporderOrderTrafficNoMapper;

	@Autowired
	private IUporderProductService productService;

	@Autowired
	private UporderProductTypeRefundConfigMapper uporderProductTypeRefundConfigMapper;
	
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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrder(UporderUser uporderUser, UpOrderSaveParam upOrderSaveParam) {
		//订单基本信息
		UporderOrder uporderOrder = new UporderOrder();
		BeanUtils.copyProperties(upOrderSaveParam, uporderOrder);
		uporderOrder.setUserId(uporderUser.getId());
		uporderOrder.setOrderStatus(1);
		uporderOrder.setPayTime(new Date());
		uporderOrder.setMcount(1);
		uporderOrder.setActualPayMoney(uporderOrder.getPrice());
		//产品信息
		String productId = upOrderSaveParam.getProductId();
		UporderProduct product = productService.getById(productId);

		//根据用户类型和产品查询返款折扣
		uporderOrder.setRefundCalWay(product.getRefundCalWay());
		//1.计算税费
		uporderOrder.setTaxRate(product.getTaxRate());
		BigDecimal taxPrice=NumberUtil.mul(uporderOrder.getPrice(),(NumberUtil.div(uporderOrder.getTaxRate(),100))) ;
		uporderOrder.setTaxFee(taxPrice.setScale(2,BigDecimal.ROUND_HALF_UP));
		UporderProductTypeRefundConfig byProductAndType = uporderProductTypeRefundConfigMapper.getByProductAndType(productId, uporderUser.getAccountType());
		if(ObjUtil.isNull(byProductAndType)) {
			uporderOrder.setDiscount(product.getDiscount());
		}else {
			uporderOrder.setDiscount(byProductAndType.getDiscount());
		}

		//根据返款方式和折扣已经金额计算返款金额
		calculateRefundMoney(uporderOrder);

		uporderOrderMapper.insert(uporderOrder);
	}

	private void calculateRefundMoney(UporderOrder order) {
		BigDecimal sub = NumberUtil.sub(order.getPrice(), order.getTaxFee());

		if(order.getRefundCalWay() == 1){
			//折扣方式   返款金额=实付金额-税费*（1-折扣）
			BigDecimal mul = NumberUtil.mul(sub, NumberUtil.sub(1, order.getDiscount()));
			order.setRefundMoney(mul.setScale(2, RoundingMode.HALF_UP));
		}else if (order.getRefundCalWay() == 2) {
			//成本   返款金额=实付金额-税费-成本
			BigDecimal sub1 = NumberUtil.sub(sub, order.getDiscount());
			order.setRefundMoney(sub1.setScale(2, RoundingMode.HALF_UP));
		}else if (order.getRefundCalWay() == 3) {
			//固定金额 返款金额=成本金额
			order.setRefundMoney(order.getDiscount());
		}
	}

}
