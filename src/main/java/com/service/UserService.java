package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;
import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.UserService;
import com.entity.vo.UserVO;
import com.entity.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.TokenService;
import com.entity.TokenEntity;

/**
 * 用户服务实现类
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	
	@Autowired
	private TokenService tokenService;
	
    /**
     * 分页查询用户数据
     * @param params 查询参数
     * @return PageUtils 分页结果
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
        );
        return new PageUtils(page);
    }
    
    /**
     * 分页查询用户视图数据
     * @param params 查询参数
     * @param wrapper 实体包装类,用于添加查询条件
     * @return PageUtils 分页结果
     */
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<UserEntity> wrapper) {
		  Page<UserView> page =new Query<UserView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    /**
     * 查询用户VO列表数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return List<UserVO> 用户VO列表
     */
    @Override
	public List<UserVO> selectListVO(Wrapper<UserEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
    /**
     * 查询单个用户VO数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return UserVO 用户VO
     */
	@Override
	public UserVO selectVO(Wrapper<UserEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
    /**
     * 查询用户视图列表数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return List<UserView> 用户视图列表
     */
	@Override
	public List<UserView> selectListView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

    /**
     * 查询单个用户视图数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return UserView 用户视图
     */
	@Override
	public UserView selectView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
    /**
     * 生成用户token
     * @param userId 用户id
     * @param username 用户名
     * @param role 用户角色
     * @return String token字符串
     */
	@Override
	public String generateToken(Long userId, String username, String role) {
		return tokenService.generateToken(userId, username, "user", role);
	}
	
    /**
     * 根据token获取用户信息
     * @param token token字符串
     * @return UserEntity 用户实体
     */
	@Override
	public UserEntity getByToken(String token) {
		TokenEntity tokenEntity = tokenService.getTokenEntity(token);
		if(tokenEntity != null) {
			return this.selectById(tokenEntity.getUserid());
		}
		return null;
	}
}
