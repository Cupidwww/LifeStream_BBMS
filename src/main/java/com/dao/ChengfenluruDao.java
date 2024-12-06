package com.dao;

import com.entity.ChengfenluruEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChengfenluruVO;
import com.entity.view.ChengfenluruView;


/**
 * 成分录入
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface ChengfenluruDao extends BaseMapper<ChengfenluruEntity> {
	
	List<ChengfenluruVO> selectListVO(@Param("ew") Wrapper<ChengfenluruEntity> wrapper);
	
	ChengfenluruVO selectVO(@Param("ew") Wrapper<ChengfenluruEntity> wrapper);
	
	List<ChengfenluruView> selectListView(@Param("ew") Wrapper<ChengfenluruEntity> wrapper);

	List<ChengfenluruView> selectListView(Pagination page,@Param("ew") Wrapper<ChengfenluruEntity> wrapper);
	
	ChengfenluruView selectView(@Param("ew") Wrapper<ChengfenluruEntity> wrapper);
	

}
