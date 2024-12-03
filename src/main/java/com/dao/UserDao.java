package com.dao;

import com.entity.UserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.UserVO;
import com.entity.view.UserView;

/**
 * 用户DAO接口
 */
public interface UserDao extends BaseMapper<UserEntity> {
	
	/**
	 * 查询用户VO列表数据
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return List<UserVO> 用户VO列表
	 */
	List<UserVO> selectListVO(@Param("ew") Wrapper<UserEntity> wrapper);
	
	/**
	 * 查询单个用户VO数据
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return UserVO 用户VO
	 */
	UserVO selectVO(@Param("ew") Wrapper<UserEntity> wrapper);
	
	/**
	 * 查询用户视图列表数据
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return List<UserView> 用户视图列表
	 */
	List<UserView> selectListView(@Param("ew") Wrapper<UserEntity> wrapper);

	/**
	 * 分页查询用户视图列表数据
	 * @param page 分页对象
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return List<UserView> 用户视图列表
	 */
	List<UserView> selectListView(Pagination page, @Param("ew") Wrapper<UserEntity> wrapper);
	
	/**
	 * 查询单个用户视图数据
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return UserView 用户视图
	 */
	UserView selectView(@Param("ew") Wrapper<UserEntity> wrapper);
} 