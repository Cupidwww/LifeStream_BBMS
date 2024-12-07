package com.dao;

import com.entity.BloodDonationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BloodDonationVO;
import com.entity.view.BloodDonationView;


/**
 * 献血登记
 *
 * @author
 * @email
 * @date 2023-03-17 10:40:32
 */
public interface BloodDonationDao extends BaseMapper<BloodDonationEntity> {

    List<BloodDonationVO> selectListVO(@Param("ew") Wrapper<BloodDonationEntity> wrapper);

    BloodDonationVO selectVO(@Param("ew") Wrapper<BloodDonationEntity> wrapper);

    List<BloodDonationView> selectListView(@Param("ew") Wrapper<BloodDonationEntity> wrapper);

    List<BloodDonationView> selectListView(Pagination page,@Param("ew") Wrapper<BloodDonationEntity> wrapper);

    BloodDonationView selectView(@Param("ew") Wrapper<BloodDonationEntity> wrapper);


}