package com.dao;

import com.entity.XuekuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuekuxinxiVO;
import com.entity.view.XuekuxinxiView;


/**
 * 血库信息
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XuekuxinxiDao extends BaseMapper<XuekuxinxiEntity> {
	
	List<XuekuxinxiVO> selectListVO(@Param("ew") Wrapper<XuekuxinxiEntity> wrapper);
	
	XuekuxinxiVO selectVO(@Param("ew") Wrapper<XuekuxinxiEntity> wrapper);
	
	List<XuekuxinxiView> selectListView(@Param("ew") Wrapper<XuekuxinxiEntity> wrapper);

	List<XuekuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XuekuxinxiEntity> wrapper);
	
	XuekuxinxiView selectView(@Param("ew") Wrapper<XuekuxinxiEntity> wrapper);
	

}
