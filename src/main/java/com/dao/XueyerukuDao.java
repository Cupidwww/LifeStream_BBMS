package com.dao;

import com.entity.XueyerukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueyerukuVO;
import com.entity.view.XueyerukuView;


/**
 * 血液入库
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XueyerukuDao extends BaseMapper<XueyerukuEntity> {
	
	List<XueyerukuVO> selectListVO(@Param("ew") Wrapper<XueyerukuEntity> wrapper);
	
	XueyerukuVO selectVO(@Param("ew") Wrapper<XueyerukuEntity> wrapper);
	
	List<XueyerukuView> selectListView(@Param("ew") Wrapper<XueyerukuEntity> wrapper);

	List<XueyerukuView> selectListView(Pagination page,@Param("ew") Wrapper<XueyerukuEntity> wrapper);
	
	XueyerukuView selectView(@Param("ew") Wrapper<XueyerukuEntity> wrapper);
	

}
