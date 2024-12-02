package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueyerukuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueyerukuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueyerukuView;


/**
 * 血液入库
 *
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XueyerukuService extends IService<XueyerukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyerukuVO> selectListVO(Wrapper<XueyerukuEntity> wrapper);
   	
   	XueyerukuVO selectVO(@Param("ew") Wrapper<XueyerukuEntity> wrapper);
   	
   	List<XueyerukuView> selectListView(Wrapper<XueyerukuEntity> wrapper);
   	
   	XueyerukuView selectView(@Param("ew") Wrapper<XueyerukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyerukuEntity> wrapper);
   	

}

