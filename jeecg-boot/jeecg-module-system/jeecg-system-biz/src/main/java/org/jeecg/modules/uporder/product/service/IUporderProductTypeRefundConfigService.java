package org.jeecg.modules.uporder.product.service;

import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 产品用户类型折扣表
 * @Author: jeecg-boot
 * @Date:   2024-11-19
 * @Version: V1.0
 */
public interface IUporderProductTypeRefundConfigService extends IService<UporderProductTypeRefundConfig> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<UporderProductTypeRefundConfig>
	 */
	public List<UporderProductTypeRefundConfig> selectByMainId(String mainId);
}
