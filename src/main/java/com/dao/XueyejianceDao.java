package com.dao;

import com.entity.XueyejianceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueyejianceVO;
import com.entity.view.XueyejianceView;


/**
 * 血液检测
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface XueyejianceDao extends BaseMapper<XueyejianceEntity> {
	
	List<XueyejianceVO> selectListVO(@Param("ew") Wrapper<XueyejianceEntity> wrapper);
	
	XueyejianceVO selectVO(@Param("ew") Wrapper<XueyejianceEntity> wrapper);
	
	List<XueyejianceView> selectListView(@Param("ew") Wrapper<XueyejianceEntity> wrapper);

	List<XueyejianceView> selectListView(Pagination page,@Param("ew") Wrapper<XueyejianceEntity> wrapper);
	
	XueyejianceView selectView(@Param("ew") Wrapper<XueyejianceEntity> wrapper);
	

}
