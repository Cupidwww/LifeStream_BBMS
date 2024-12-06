package com.dao;

import com.entity.CaixuedengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaixuedengjiVO;
import com.entity.view.CaixuedengjiView;


/**
 * 采血登记
 * 
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
public interface CaixuedengjiDao extends BaseMapper<CaixuedengjiEntity> {
	
	List<CaixuedengjiVO> selectListVO(@Param("ew") Wrapper<CaixuedengjiEntity> wrapper);
	
	CaixuedengjiVO selectVO(@Param("ew") Wrapper<CaixuedengjiEntity> wrapper);
	
	List<CaixuedengjiView> selectListView(@Param("ew") Wrapper<CaixuedengjiEntity> wrapper);

	List<CaixuedengjiView> selectListView(Pagination page,@Param("ew") Wrapper<CaixuedengjiEntity> wrapper);
	
	CaixuedengjiView selectView(@Param("ew") Wrapper<CaixuedengjiEntity> wrapper);
	

}
