package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HealthManagementVO;
import com.entity.view.HealthManagementView;
import com.entity.HealthManagementEntity;

/**
 * 血液检测
 *
 * @author
 * @email
 * @date 2023-03-17 10:40:32
 */
public interface HealthManagementDao extends BaseMapper<HealthManagementEntity> {

    List<HealthManagementVO> selectListVO(@Param("ew") Wrapper<HealthManagementEntity> wrapper);

    HealthManagementVO selectVO(@Param("ew") Wrapper<HealthManagementEntity> wrapper);

    List<HealthManagementView> selectListView(@Param("ew") Wrapper<HealthManagementEntity> wrapper);

    List<HealthManagementView> selectListView(Pagination page,@Param("ew") Wrapper<HealthManagementEntity> wrapper);

    HealthManagementView selectView(@Param("ew") Wrapper<HealthManagementEntity> wrapper);


}