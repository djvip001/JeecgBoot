package org.jeecg.modules.uporder.product.service.impl;

import org.jeecg.modules.uporder.product.entity.UporderProductDefineField;
import org.jeecg.modules.uporder.product.mapper.UporderProductDefineFieldMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductDefineFieldService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 产品自定义字段表
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@Service
public class UporderProductDefineFieldServiceImpl extends ServiceImpl<UporderProductDefineFieldMapper, UporderProductDefineField> implements IUporderProductDefineFieldService {
	
	@Autowired
	private UporderProductDefineFieldMapper uporderProductDefineFieldMapper;
	
	@Override
	public List<UporderProductDefineField> selectByMainId(String mainId) {
		return uporderProductDefineFieldMapper.selectByMainId(mainId);
	}
}
