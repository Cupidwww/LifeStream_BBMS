package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueyechukuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueyechukuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueyechukuView;


/**
 * 血液出库
 *
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XueyechukuService extends IService<XueyechukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyechukuVO> selectListVO(Wrapper<XueyechukuEntity> wrapper);
   	
   	XueyechukuVO selectVO(@Param("ew") Wrapper<XueyechukuEntity> wrapper);
   	
   	List<XueyechukuView> selectListView(Wrapper<XueyechukuEntity> wrapper);
   	
   	XueyechukuView selectView(@Param("ew") Wrapper<XueyechukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyechukuEntity> wrapper);
   	

}

