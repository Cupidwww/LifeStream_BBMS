package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaixuedengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaixuedengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaixuedengjiView;


/**
 * 采血登记
 *
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface CaixuedengjiService extends IService<CaixuedengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaixuedengjiVO> selectListVO(Wrapper<CaixuedengjiEntity> wrapper);
   	
   	CaixuedengjiVO selectVO(@Param("ew") Wrapper<CaixuedengjiEntity> wrapper);
   	
   	List<CaixuedengjiView> selectListView(Wrapper<CaixuedengjiEntity> wrapper);
   	
   	CaixuedengjiView selectView(@Param("ew") Wrapper<CaixuedengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaixuedengjiEntity> wrapper);
   	

}

