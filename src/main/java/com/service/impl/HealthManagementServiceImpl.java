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


import com.dao.HealthManagementDao;
import com.entity.HealthManagementEntity;
import com.service.HealthManagementService;
import com.entity.vo.HealthManagementVO;
import com.entity.view.HealthManagementView;

@Service("healthManagementService")
public class HealthManagementServiceImpl extends ServiceImpl<HealthManagementDao, HealthManagementEntity> implements HealthManagementService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HealthManagementEntity> page = this.selectPage(
                new Query<HealthManagementEntity>(params).getPage(),
                new EntityWrapper<HealthManagementEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<HealthManagementEntity> wrapper) {
        Page<HealthManagementView> page =new Query<HealthManagementView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<HealthManagementVO> selectListVO(Wrapper<HealthManagementEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public HealthManagementVO selectVO(Wrapper<HealthManagementEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<HealthManagementView> selectListView(Wrapper<HealthManagementEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public HealthManagementView selectView(Wrapper<HealthManagementEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
