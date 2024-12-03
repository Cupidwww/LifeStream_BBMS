package com.dao;

import com.entity.BloodBankEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.BloodBankVO;
import com.entity.view.BloodBankView;

/**
 * 血库管理
 */
public interface BloodBankDao extends BaseMapper<BloodBankEntity> { // 继承BaseMapper接口
    
    List<BloodBankVO> selectListVO(@Param("ew") Wrapper<BloodBankEntity> wrapper); // 查询VO列表
    
    BloodBankVO selectVO(@Param("ew") Wrapper<BloodBankEntity> wrapper); // 查询单个VO
    
    List<BloodBankView> selectListView(@Param("ew") Wrapper<BloodBankEntity> wrapper); // 查询视图列表

    List<BloodBankView> selectListView(Pagination page, @Param("ew") Wrapper<BloodBankEntity> wrapper); // 分页查询视图列表
    
    BloodBankView selectView(@Param("ew") Wrapper<BloodBankEntity> wrapper);
} 