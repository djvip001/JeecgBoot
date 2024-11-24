package org.jeecg.modules.uporder.product.service.impl;

import org.jeecg.modules.uporder.product.entity.UporderProductMediumText;
import org.jeecg.modules.uporder.product.mapper.UporderProductMediumTextMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductMediumTextService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 产品文本表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@Service
public class UporderProductMediumTextServiceImpl extends ServiceImpl<UporderProductMediumTextMapper, UporderProductMediumText> implements IUporderProductMediumTextService {
	
	@Autowired
	private UporderProductMediumTextMapper uporderProductMediumTextMapper;
	
	@Override
	public List<UporderProductMediumText> selectByMainId(String mainId) {
		return uporderProductMediumTextMapper.selectByMainId(mainId);
	}
}
