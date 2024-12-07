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


import com.dao.BloodDonationDao;
import com.entity.BloodDonationEntity;
import com.service.BloodDonationService;
import com.entity.vo.BloodDonationVO;
import com.entity.view.BloodDonationView;

@Service("bloodDonationService")
public class BloodDonationServiceImpl extends ServiceImpl<BloodDonationDao, BloodDonationEntity> implements BloodDonationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BloodDonationEntity> page = this.selectPage(
                new Query<BloodDonationEntity>(params).getPage(),
                new EntityWrapper<BloodDonationEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<BloodDonationEntity> wrapper) {
        Page<BloodDonationView> page =new Query<BloodDonationView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<BloodDonationVO> selectListVO(Wrapper<BloodDonationEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public BloodDonationVO selectVO(Wrapper<BloodDonationEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<BloodDonationView> selectListView(Wrapper<BloodDonationEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public BloodDonationView selectView(Wrapper<BloodDonationEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
