package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChengfenluruEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChengfenluruVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengfenluruView;


/**
 * 成分录入
 *
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface ChengfenluruService extends IService<ChengfenluruEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengfenluruVO> selectListVO(Wrapper<ChengfenluruEntity> wrapper);
   	
   	ChengfenluruVO selectVO(@Param("ew") Wrapper<ChengfenluruEntity> wrapper);
   	
   	List<ChengfenluruView> selectListView(Wrapper<ChengfenluruEntity> wrapper);
   	
   	ChengfenluruView selectView(@Param("ew") Wrapper<ChengfenluruEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengfenluruEntity> wrapper);
   	

}

