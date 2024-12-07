package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HealthManagementEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HealthManagementVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HealthManagementView;


/**
 * 健康管理
 *
 * @author
 * @email
 * @date 2023-03-17 10:40:32
 */
public interface HealthManagementService extends IService<HealthManagementEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HealthManagementVO> selectListVO(Wrapper<HealthManagementEntity> wrapper);

    HealthManagementVO selectVO(@Param("ew") Wrapper<HealthManagementEntity> wrapper);

    List<HealthManagementView> selectListView(Wrapper<HealthManagementEntity> wrapper);

    HealthManagementView selectView(@Param("ew") Wrapper<HealthManagementEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<HealthManagementEntity> wrapper);


}
