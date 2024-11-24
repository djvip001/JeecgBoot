package org.jeecg.modules.uporder.product.mapper;

import java.util.List;
import org.jeecg.modules.uporder.product.entity.UporderProductUserLimit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 报单产品用户额度表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
public interface UporderProductUserLimitMapper extends BaseMapper<UporderProductUserLimit> {

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
   * @return List<UporderProductUserLimit>
   */
	public List<UporderProductUserLimit> selectByMainId(@Param("mainId") String mainId);
}
