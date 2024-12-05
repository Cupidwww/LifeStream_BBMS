package com.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.TokenDao;
import com.entity.TokenEntity;
import com.service.TokenService;
import com.utils.CommonUtil;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * token
 */
@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

	@Autowired
	private TokenDao tokenDao;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TokenEntity> page = this.selectPage(
                new Query<TokenEntity>(params).getPage(),
                new EntityWrapper<TokenEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<TokenEntity> selectListView(Wrapper<TokenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<TokenEntity> wrapper) {
		 Page<TokenEntity> page =new Query<TokenEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}

	@Override
	public String generateToken(Long userid, String username, String tableName, String role) {
		TokenEntity tokenEntity = tokenDao.selectOne(new EntityWrapper<TokenEntity>().eq("userid", userid).eq("role", role));
		String token = CommonUtil.getRandomString(32);
		
		// 设置过期时间为 2099 年的当前月份日期和具体时间
		Calendar calendar = Calendar.getInstance();
		calendar.set(2099, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 
					 calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
		Date expiratedtime = calendar.getTime();
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		if (tokenEntity != null) {
			tokenEntity.setToken(token);
			tokenEntity.setExpiratedtime(expiratedtime);
			tokenEntity.setAddtime(now);
			this.updateById(tokenEntity);
		} else {
			tokenEntity = new TokenEntity();
			tokenEntity.setUserid(userid);
			tokenEntity.setUsername(username);
			tokenEntity.setTablename(tableName);
			tokenEntity.setRole(role);
			tokenEntity.setToken(token);
			tokenEntity.setExpiratedtime(expiratedtime);
			tokenEntity.setAddtime(now);
			this.insert(tokenEntity);
		}
		return token;
	}

	@Override
	public TokenEntity getTokenEntity(String token) {
		TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
		return tokenEntity;
	}
}
