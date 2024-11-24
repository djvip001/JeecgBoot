package org.jeecg.modules.uporder.product.service;

import org.jeecg.modules.uporder.product.entity.UporderProductUserLimit;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 报单产品用户额度表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
public interface IUporderProductUserLimitService extends IService<UporderProductUserLimit> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<UporderProductUserLimit>
	 */
	public List<UporderProductUserLimit> selectByMainId(String mainId);
}
