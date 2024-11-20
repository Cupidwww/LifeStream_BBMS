package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XianxuerenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XianxuerenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XianxuerenyuanView;


/**
 * 献血人员
 *
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XianxuerenyuanService extends IService<XianxuerenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianxuerenyuanVO> selectListVO(Wrapper<XianxuerenyuanEntity> wrapper);
   	
   	XianxuerenyuanVO selectVO(@Param("ew") Wrapper<XianxuerenyuanEntity> wrapper);
   	
   	List<XianxuerenyuanView> selectListView(Wrapper<XianxuerenyuanEntity> wrapper);
   	
   	XianxuerenyuanView selectView(@Param("ew") Wrapper<XianxuerenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianxuerenyuanEntity> wrapper);
   	

}

