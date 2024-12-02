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


import com.dao.XianxuerenyuanDao;
import com.entity.XianxuerenyuanEntity;
import com.service.XianxuerenyuanService;
import com.entity.vo.XianxuerenyuanVO;
import com.entity.view.XianxuerenyuanView;

@Service("xianxuerenyuanService")
public class XianxuerenyuanServiceImpl extends ServiceImpl<XianxuerenyuanDao, XianxuerenyuanEntity> implements XianxuerenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianxuerenyuanEntity> page = this.selectPage(
                new Query<XianxuerenyuanEntity>(params).getPage(),
                new EntityWrapper<XianxuerenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianxuerenyuanEntity> wrapper) {
		  Page<XianxuerenyuanView> page =new Query<XianxuerenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XianxuerenyuanVO> selectListVO(Wrapper<XianxuerenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XianxuerenyuanVO selectVO(Wrapper<XianxuerenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XianxuerenyuanView> selectListView(Wrapper<XianxuerenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianxuerenyuanView selectView(Wrapper<XianxuerenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
