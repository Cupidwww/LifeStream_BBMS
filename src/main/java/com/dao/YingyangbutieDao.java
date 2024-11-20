package com.dao;

import com.entity.YingyangbutieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YingyangbutieVO;
import com.entity.view.YingyangbutieView;


/**
 * 营养补贴
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface YingyangbutieDao extends BaseMapper<YingyangbutieEntity> {
	
	List<YingyangbutieVO> selectListVO(@Param("ew") Wrapper<YingyangbutieEntity> wrapper);
	
	YingyangbutieVO selectVO(@Param("ew") Wrapper<YingyangbutieEntity> wrapper);
	
	List<YingyangbutieView> selectListView(@Param("ew") Wrapper<YingyangbutieEntity> wrapper);

	List<YingyangbutieView> selectListView(Pagination page,@Param("ew") Wrapper<YingyangbutieEntity> wrapper);
	
	YingyangbutieView selectView(@Param("ew") Wrapper<YingyangbutieEntity> wrapper);
	

}
