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


import com.dao.XuekuxinxiDao;
import com.entity.XuekuxinxiEntity;
import com.service.XuekuxinxiService;
import com.entity.vo.XuekuxinxiVO;
import com.entity.view.XuekuxinxiView;

@Service("xuekuxinxiService")
public class XuekuxinxiServiceImpl extends ServiceImpl<XuekuxinxiDao, XuekuxinxiEntity> implements XuekuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuekuxinxiEntity> page = this.selectPage(
                new Query<XuekuxinxiEntity>(params).getPage(),
                new EntityWrapper<XuekuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuekuxinxiEntity> wrapper) {
		  Page<XuekuxinxiView> page =new Query<XuekuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuekuxinxiVO> selectListVO(Wrapper<XuekuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuekuxinxiVO selectVO(Wrapper<XuekuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuekuxinxiView> selectListView(Wrapper<XuekuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuekuxinxiView selectView(Wrapper<XuekuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
