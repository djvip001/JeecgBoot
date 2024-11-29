package org.jeecg.modules.demo.order.service;

import org.jeecg.modules.demo.order.entity.UporderOrderTrafficNo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 订单物流表
 * @Author: jeecg-boot
 * @Date:   2024-11-29
 * @Version: V1.0
 */
public interface IUporderOrderTrafficNoService extends IService<UporderOrderTrafficNo> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<UporderOrderTrafficNo>
	 */
	public List<UporderOrderTrafficNo> selectByMainId(String mainId);
}
