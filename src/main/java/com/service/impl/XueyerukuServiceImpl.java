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


import com.dao.XueyerukuDao;
import com.entity.XueyerukuEntity;
import com.service.XueyerukuService;
import com.entity.vo.XueyerukuVO;
import com.entity.view.XueyerukuView;

@Service("xueyerukuService")
public class XueyerukuServiceImpl extends ServiceImpl<XueyerukuDao, XueyerukuEntity> implements XueyerukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueyerukuEntity> page = this.selectPage(
                new Query<XueyerukuEntity>(params).getPage(),
                new EntityWrapper<XueyerukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueyerukuEntity> wrapper) {
		  Page<XueyerukuView> page =new Query<XueyerukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueyerukuVO> selectListVO(Wrapper<XueyerukuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueyerukuVO selectVO(Wrapper<XueyerukuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueyerukuView> selectListView(Wrapper<XueyerukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueyerukuView selectView(Wrapper<XueyerukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
