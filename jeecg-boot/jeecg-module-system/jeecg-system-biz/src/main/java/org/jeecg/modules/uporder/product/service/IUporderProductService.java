package org.jeecg.modules.uporder.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.entity.UporderProductDefineField;
import org.jeecg.modules.uporder.product.entity.UporderProductUserLimit;
import org.jeecg.modules.uporder.product.entity.UporderProductBuyLink;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.uporder.product.vo.QueryActOrderStatVo;
import org.jeecg.modules.uporder.product.vo.UporderProductAction;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
public interface IUporderProductService extends IService<UporderProduct> {

	/**
	 * 添加一对多
	 *
	 * @param uporderProduct
	 * @param uporderProductMediumTextList
	 * @param uporderProductTypeRefundConfigList
	 * @param uporderProductDefineFieldList
	 * @param uporderProductUserLimitList
	 * @param uporderProductBuyLinkList
	 */
	public void saveMain(UporderProduct uporderProduct,List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList,List<UporderProductDefineField> uporderProductDefineFieldList,List<UporderProductUserLimit> uporderProductUserLimitList,List<UporderProductBuyLink> uporderProductBuyLinkList) ;
	
	/**
	 * 修改一对多
	 *
   * @param uporderProduct
   * @param uporderProductMediumTextList
   * @param uporderProductTypeRefundConfigList
   * @param uporderProductDefineFieldList
   * @param uporderProductUserLimitList
   * @param uporderProductBuyLinkList
	 */
	public void updateMain(UporderProduct uporderProduct,List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList,List<UporderProductDefineField> uporderProductDefineFieldList,List<UporderProductUserLimit> uporderProductUserLimitList,List<UporderProductBuyLink> uporderProductBuyLinkList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);


	IPage<UporderProduct> delList(Page<UporderProduct> page, QueryWrapper<UporderProduct> queryWrapper);

	void recover(String id);

	IPage<UporderProductAction> listAction(Page<UporderProductAction> page, QueryWrapper<UporderProduct> queryWrapper);

	IPage<QueryActOrderStatVo> queryActOrderStat(Page<QueryActOrderStatVo> page, QueryWrapper<UporderProduct> queryWrapper);
}
