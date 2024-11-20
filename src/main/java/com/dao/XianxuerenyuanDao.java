package com.dao;

import com.entity.XianxuerenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XianxuerenyuanVO;
import com.entity.view.XianxuerenyuanView;


/**
 * 献血人员
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XianxuerenyuanDao extends BaseMapper<XianxuerenyuanEntity> {
	
	List<XianxuerenyuanVO> selectListVO(@Param("ew") Wrapper<XianxuerenyuanEntity> wrapper);
	
	XianxuerenyuanVO selectVO(@Param("ew") Wrapper<XianxuerenyuanEntity> wrapper);
	
	List<XianxuerenyuanView> selectListView(@Param("ew") Wrapper<XianxuerenyuanEntity> wrapper);

	List<XianxuerenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<XianxuerenyuanEntity> wrapper);
	
	XianxuerenyuanView selectView(@Param("ew") Wrapper<XianxuerenyuanEntity> wrapper);
	

}
