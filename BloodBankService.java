package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BloodBankEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BloodBankVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BloodBankView;

/**
 * 血库管理服务接口
 */
public interface BloodBankService extends IService<BloodBankEntity> {

    /**
     * 分页查询血库数据
     * @param params 查询参数
     * @return PageUtils 分页结果
     */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 查询血库VO列表数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return List<BloodBankVO> 血库VO列表
     */
   	List<BloodBankVO> selectListVO(Wrapper<BloodBankEntity> wrapper);
   	
    /**
     * 查询单个血库VO数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return BloodBankVO 血库VO
     */
   	BloodBankVO selectVO(@Param("ew") Wrapper<BloodBankEntity> wrapper);
   	
    /**
     * 查询血库视图列表数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return List<BloodBankView> 血库视图列表
     */
   	List<BloodBankView> selectListView(Wrapper<BloodBankEntity> wrapper);
   	
    /**
     * 查询单个血库视图数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return BloodBankView 血库视图
     */
   	BloodBankView selectView(@Param("ew") Wrapper<BloodBankEntity> wrapper);
   	
    /**
     * 分页查询血库视图数据
     * @param params 查询参数
     * @param wrapper 实体包装类,用于添加查询条件
     * @return PageUtils 分页结果
     */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BloodBankEntity> wrapper);
} 