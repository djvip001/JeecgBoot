package org.jeecg.modules.uporder.product.service;

import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import org.jeecg.modules.uporder.product.entity.UporderProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 产品表
 * @Author: jeecg-boot
 * @Date:   2024-11-19
 * @Version: V1.0
 */
public interface IUporderProductService extends IService<UporderProduct> {

	/**
	 * 添加一对多
	 *
	 * @param uporderProduct
	 * @param uporderProductMediumTextList
	 * @param uporderProductTypeRefundConfigList
	 */
	public void saveMain(UporderProduct uporderProduct,List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList) ;
	
	/**
	 * 修改一对多
	 *
	 * @param uporderProduct
	 * @param uporderProductMediumTextList
	 * @param uporderProductTypeRefundConfigList
	 */
	public void updateMain(UporderProduct uporderProduct,List<UporderProductMediumText> uporderProductMediumTextList,List<UporderProductTypeRefundConfig> uporderProductTypeRefundConfigList);
	
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
	
}
