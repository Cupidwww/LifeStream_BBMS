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


import com.dao.XueyejianceDao;
import com.entity.XueyejianceEntity;
import com.service.XueyejianceService;
import com.entity.vo.XueyejianceVO;
import com.entity.view.XueyejianceView;

@Service("xueyejianceService")
public class XueyejianceServiceImpl extends ServiceImpl<XueyejianceDao, XueyejianceEntity> implements XueyejianceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueyejianceEntity> page = this.selectPage(
                new Query<XueyejianceEntity>(params).getPage(),
                new EntityWrapper<XueyejianceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueyejianceEntity> wrapper) {
		  Page<XueyejianceView> page =new Query<XueyejianceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueyejianceVO> selectListVO(Wrapper<XueyejianceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueyejianceVO selectVO(Wrapper<XueyejianceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueyejianceView> selectListView(Wrapper<XueyejianceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueyejianceView selectView(Wrapper<XueyejianceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
