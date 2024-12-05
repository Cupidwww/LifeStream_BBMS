package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.UserEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.UserView;

/**
 * 用户服务接口
 */
public interface UserService extends IService<UserEntity> {

	/**
	 * 分页查询用户数据
	 * @param params 查询参数
	 * @return PageUtils 分页结果
	 */
	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 查询用户VO列表数据
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return List<UserVO> 用户VO列表
	 */
	List<UserVO> selectListVO(Wrapper<UserEntity> wrapper);

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
	List<UserView> selectListView(Wrapper<UserEntity> wrapper);

	/**
	 * 查询单个用户视图数据
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return UserView 用户视图
	 */
	UserView selectView(@Param("ew") Wrapper<UserEntity> wrapper);

	/**
	 * 分页查询用户视图数据
	 * @param params 查询参数
	 * @param wrapper 实体包装类,用于添加查询条件
	 * @return PageUtils 分页结果
	 */
	PageUtils queryPage(Map<String, Object> params,Wrapper<UserEntity> wrapper);

	/**
	 * 生成用户token
	 * @param userId 用户id
	 * @param username 用户名
	 * @param role 用户角色
	 * @return String token字符串
	 */
	String generateToken(Long userId, String username, String role);

	/**
	 * 根据token获取用户信息
	 * @param token token字符串
	 * @return UserEntity 用户实体
	 */
	UserEntity getByToken(String token);

	/**
	 * 根据用户名查询管理员用户信息
	 * @param username 用户名
	 * @return UserEntity 用户实体
	 */
	UserEntity getByUsername(String username);
}