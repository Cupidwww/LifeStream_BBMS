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


import com.dao.YingyangbutieDao;
import com.entity.YingyangbutieEntity;
import com.service.YingyangbutieService;
import com.entity.vo.YingyangbutieVO;
import com.entity.view.YingyangbutieView;

@Service("yingyangbutieService")
public class YingyangbutieServiceImpl extends ServiceImpl<YingyangbutieDao, YingyangbutieEntity> implements YingyangbutieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingyangbutieEntity> page = this.selectPage(
                new Query<YingyangbutieEntity>(params).getPage(),
                new EntityWrapper<YingyangbutieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingyangbutieEntity> wrapper) {
		  Page<YingyangbutieView> page =new Query<YingyangbutieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YingyangbutieVO> selectListVO(Wrapper<YingyangbutieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YingyangbutieVO selectVO(Wrapper<YingyangbutieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YingyangbutieView> selectListView(Wrapper<YingyangbutieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingyangbutieView selectView(Wrapper<YingyangbutieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
