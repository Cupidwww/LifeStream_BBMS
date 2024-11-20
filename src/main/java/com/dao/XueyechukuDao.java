package com.dao;

import com.entity.XueyechukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueyechukuVO;
import com.entity.view.XueyechukuView;


/**
 * 血液出库
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XueyechukuDao extends BaseMapper<XueyechukuEntity> {
	
	List<XueyechukuVO> selectListVO(@Param("ew") Wrapper<XueyechukuEntity> wrapper);
	
	XueyechukuVO selectVO(@Param("ew") Wrapper<XueyechukuEntity> wrapper);
	
	List<XueyechukuView> selectListView(@Param("ew") Wrapper<XueyechukuEntity> wrapper);

	List<XueyechukuView> selectListView(Pagination page,@Param("ew") Wrapper<XueyechukuEntity> wrapper);
	
	XueyechukuView selectView(@Param("ew") Wrapper<XueyechukuEntity> wrapper);
	

}
