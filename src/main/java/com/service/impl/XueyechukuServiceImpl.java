package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XueyechukuDao;
import com.entity.XueyechukuEntity;
import com.service.XueyechukuService;
import com.entity.vo.XueyechukuVO;
import com.entity.view.XueyechukuView;

@Service("xueyechukuService")
public class XueyechukuServiceImpl extends ServiceImpl<XueyechukuDao, XueyechukuEntity> implements XueyechukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueyechukuEntity> page = this.selectPage(
                new Query<XueyechukuEntity>(params).getPage(),
                new EntityWrapper<XueyechukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueyechukuEntity> wrapper) {
		  Page<XueyechukuView> page =new Query<XueyechukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueyechukuVO> selectListVO(Wrapper<XueyechukuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueyechukuVO selectVO(Wrapper<XueyechukuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueyechukuView> selectListView(Wrapper<XueyechukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueyechukuView selectView(Wrapper<XueyechukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
