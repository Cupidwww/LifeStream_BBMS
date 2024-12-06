package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import java.util.List;
import java.util.Map;

import com.entity.vo.BloodDonationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BloodDonationView;
import com.entity.BloodDonationEntity;


/**
 * 献血登记
 *
 * @author
 * @email
 * @date 2023-03-17 10:40:32
 */
public interface BloodDonationService extends IService<BloodDonationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<BloodDonationVO> selectListVO(Wrapper<BloodDonationEntity> wrapper);

    BloodDonationVO selectVO(@Param("ew") Wrapper<BloodDonationEntity> wrapper);

    List<BloodDonationView> selectListView(Wrapper<BloodDonationEntity> wrapper);

    BloodDonationView selectView(@Param("ew") Wrapper<BloodDonationEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<BloodDonationEntity> wrapper);


}