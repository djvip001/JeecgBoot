package org.jeecg.modules.uporder.order.mapper;

import java.util.List;
import org.jeecg.modules.uporder.order.entity.UporderOrderTrafficNo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 订单物流表
 * @Author: jeecg-boot
 * @Date:   2024-11-25
 * @Version: V1.0
 */
public interface UporderOrderTrafficNoMapper extends BaseMapper<UporderOrderTrafficNo> {

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
   * @return List<UporderOrderTrafficNo>
   */
	public List<UporderOrderTrafficNo> selectByMainId(@Param("mainId") String mainId);
}
