package org.jeecg.modules.uporder.product.service.impl;

import org.jeecg.modules.uporder.product.entity.UporderProductBuyLink;
import org.jeecg.modules.uporder.product.mapper.UporderProductBuyLinkMapper;
import org.jeecg.modules.uporder.product.service.IUporderProductBuyLinkService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 报单产品购买链接
 * @Author: jeecg-boot
 * @Date:   2024-11-21
 * @Version: V1.0
 */
@Service
public class UporderProductBuyLinkServiceImpl extends ServiceImpl<UporderProductBuyLinkMapper, UporderProductBuyLink> implements IUporderProductBuyLinkService {
	
	@Autowired
	private UporderProductBuyLinkMapper uporderProductBuyLinkMapper;
	
	@Override
	public List<UporderProductBuyLink> selectByMainId(String mainId) {
		return uporderProductBuyLinkMapper.selectByMainId(mainId);
	}
}
