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


import com.dao.CaixuedengjiDao;
import com.entity.CaixuedengjiEntity;
import com.service.CaixuedengjiService;
import com.entity.vo.CaixuedengjiVO;
import com.entity.view.CaixuedengjiView;

@Service("caixuedengjiService")
public class CaixuedengjiServiceImpl extends ServiceImpl<CaixuedengjiDao, CaixuedengjiEntity> implements CaixuedengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaixuedengjiEntity> page = this.selectPage(
                new Query<CaixuedengjiEntity>(params).getPage(),
                new EntityWrapper<CaixuedengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaixuedengjiEntity> wrapper) {
		  Page<CaixuedengjiView> page =new Query<CaixuedengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaixuedengjiVO> selectListVO(Wrapper<CaixuedengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaixuedengjiVO selectVO(Wrapper<CaixuedengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaixuedengjiView> selectListView(Wrapper<CaixuedengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaixuedengjiView selectView(Wrapper<CaixuedengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
