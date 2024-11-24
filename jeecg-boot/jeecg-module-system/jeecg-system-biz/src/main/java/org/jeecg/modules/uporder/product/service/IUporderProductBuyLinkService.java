package org.jeecg.modules.uporder.product.service;

import org.jeecg.modules.uporder.product.entity.UporderProductBuyLink;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 报单产品购买链接
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
public interface IUporderProductBuyLinkService extends IService<UporderProductBuyLink> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<UporderProductBuyLink>
	 */
	public List<UporderProductBuyLink> selectByMainId(String mainId);
}
