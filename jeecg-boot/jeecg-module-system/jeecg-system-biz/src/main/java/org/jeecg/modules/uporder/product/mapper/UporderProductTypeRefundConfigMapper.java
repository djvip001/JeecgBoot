package org.jeecg.modules.uporder.product.mapper;

import java.util.List;
import org.jeecg.modules.uporder.product.entity.UporderProductTypeRefundConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 产品用户类型折扣表
 * @Author: jeecg-boot
 * @Date:   2024-11-19
 * @Version: V1.0
 */
public interface UporderProductTypeRefundConfigMapper extends BaseMapper<UporderProductTypeRefundConfig> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<UporderProductTypeRefundConfig>
   */
	public List<UporderProductTypeRefundConfig> selectByMainId(@Param("mainId") String mainId);
}
