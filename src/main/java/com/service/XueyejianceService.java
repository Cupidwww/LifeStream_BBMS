package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueyejianceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueyejianceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueyejianceView;


/**
 * 血液检测
 *
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XueyejianceService extends IService<XueyejianceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyejianceVO> selectListVO(Wrapper<XueyejianceEntity> wrapper);
   	
   	XueyejianceVO selectVO(@Param("ew") Wrapper<XueyejianceEntity> wrapper);
   	
   	List<XueyejianceView> selectListView(Wrapper<XueyejianceEntity> wrapper);
   	
   	XueyejianceView selectView(@Param("ew") Wrapper<XueyejianceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyejianceEntity> wrapper);
   	

}

