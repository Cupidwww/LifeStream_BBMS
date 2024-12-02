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


import com.dao.ChengfenluruDao;
import com.entity.ChengfenluruEntity;
import com.service.ChengfenluruService;
import com.entity.vo.ChengfenluruVO;
import com.entity.view.ChengfenluruView;

@Service("chengfenluruService")
public class ChengfenluruServiceImpl extends ServiceImpl<ChengfenluruDao, ChengfenluruEntity> implements ChengfenluruService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengfenluruEntity> page = this.selectPage(
                new Query<ChengfenluruEntity>(params).getPage(),
                new EntityWrapper<ChengfenluruEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengfenluruEntity> wrapper) {
		  Page<ChengfenluruView> page =new Query<ChengfenluruView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChengfenluruVO> selectListVO(Wrapper<ChengfenluruEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChengfenluruVO selectVO(Wrapper<ChengfenluruEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChengfenluruView> selectListView(Wrapper<ChengfenluruEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengfenluruView selectView(Wrapper<ChengfenluruEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
