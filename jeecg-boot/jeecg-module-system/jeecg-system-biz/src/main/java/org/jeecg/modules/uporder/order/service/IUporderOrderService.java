package org.jeecg.modules.uporder.order.service;

import org.jeecg.modules.uporder.order.entity.UporderOrderTrafficNo;
import org.jeecg.modules.uporder.order.entity.UporderOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 订单表
 * @Author: jeecg-boot
 * @Date:   2024-11-25
 * @Version: V1.0
 */
public interface IUporderOrderService extends IService<UporderOrder> {

	/**
	 * 添加一对多
	 *
	 * @param uporderOrder
	 * @param uporderOrderTrafficNoList
	 */
	public void saveMain(UporderOrder uporderOrder,List<UporderOrderTrafficNo> uporderOrderTrafficNoList) ;
	
	/**
	 * 修改一对多
	 *
   * @param uporderOrder
   * @param uporderOrderTrafficNoList
	 */
	public void updateMain(UporderOrder uporderOrder,List<UporderOrderTrafficNo> uporderOrderTrafficNoList);
	
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
