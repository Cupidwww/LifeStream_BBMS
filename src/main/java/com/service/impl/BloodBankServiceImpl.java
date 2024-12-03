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
import com.dao.BloodBankDao;
import com.entity.BloodBankEntity;
import com.service.BloodBankService;
import com.entity.vo.BloodBankVO;
import com.entity.view.BloodBankView;

/**
 * 血库管理服务实现类
 */
@Service("bloodBankService")
public class BloodBankServiceImpl extends ServiceImpl<BloodBankDao, BloodBankEntity> implements BloodBankService {
	
    /**
     * 分页查询血库数据
     * @param params 查询参数
     * @return PageUtils 分页结果
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BloodBankEntity> page = this.selectPage(
                new Query<BloodBankEntity>(params).getPage(),
                new EntityWrapper<BloodBankEntity>()
        );
        return new PageUtils(page);
    }
    
    /**
     * 分页查询血库视图数据
     * @param params 查询参数
     * @param wrapper 实体包装类,用于添加查询条件
     * @return PageUtils 分页结果
     */
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BloodBankEntity> wrapper) {
		  Page<BloodBankView> page =new Query<BloodBankView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    /**
     * 查询血库VO列表数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return List<BloodBankVO> 血库VO列表
     */
    @Override
	public List<BloodBankVO> selectListVO(Wrapper<BloodBankEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
    /**
     * 查询单个血库VO数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return BloodBankVO 血库VO
     */
	@Override
	public BloodBankVO selectVO(Wrapper<BloodBankEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
    /**
     * 查询血库视图列表数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return List<BloodBankView> 血库视图列表
     */
	@Override
	public List<BloodBankView> selectListView(Wrapper<BloodBankEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

    /**
     * 查询单个血库视图数据
     * @param wrapper 实体包装类,用于添加查询条件
     * @return BloodBankView 血库视图
     */
	@Override
	public BloodBankView selectView(Wrapper<BloodBankEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
} 