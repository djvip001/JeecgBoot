package org.jeecg.modules.uporder.product.service;

import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 产品文本表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
public interface IUporderProductMediumTextService extends IService<UporderProductMediumText> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<UporderProductMediumText>
	 */
	public List<UporderProductMediumText> selectByMainId(String mainId);
}
