package org.jeecg.modules.uporder.product.mapper;

import java.util.List;
import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 产品文本表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
public interface UporderProductMediumTextMapper extends BaseMapper<UporderProductMediumText> {

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
   * @return List<UporderProductMediumText>
   */
	public List<UporderProductMediumText> selectByMainId(@Param("mainId") String mainId);
}
