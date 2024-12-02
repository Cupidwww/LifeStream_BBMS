package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YingyangbutieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YingyangbutieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YingyangbutieView;


/**
 * 营养补贴
 *
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface YingyangbutieService extends IService<YingyangbutieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingyangbutieVO> selectListVO(Wrapper<YingyangbutieEntity> wrapper);
   	
   	YingyangbutieVO selectVO(@Param("ew") Wrapper<YingyangbutieEntity> wrapper);
   	
   	List<YingyangbutieView> selectListView(Wrapper<YingyangbutieEntity> wrapper);
   	
   	YingyangbutieView selectView(@Param("ew") Wrapper<YingyangbutieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingyangbutieEntity> wrapper);
   	

}

