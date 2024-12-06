package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CaixuedengjiEntity;
import com.entity.view.CaixuedengjiView;

import com.service.CaixuedengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 采血登记
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
@RestController
@RequestMapping("/caixuedengji")
public class CaixuedengjiController {
    @Autowired
    private CaixuedengjiService caixuedengjiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaixuedengjiEntity caixuedengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xianxuerenyuan")) {
			caixuedengji.setXianxuebianhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongzuorenyuan")) {
			caixuedengji.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CaixuedengjiEntity> ew = new EntityWrapper<CaixuedengjiEntity>();

		PageUtils page = caixuedengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caixuedengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaixuedengjiEntity caixuedengji, 
		HttpServletRequest request){
        EntityWrapper<CaixuedengjiEntity> ew = new EntityWrapper<CaixuedengjiEntity>();

		PageUtils page = caixuedengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caixuedengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaixuedengjiEntity caixuedengji){
       	EntityWrapper<CaixuedengjiEntity> ew = new EntityWrapper<CaixuedengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caixuedengji, "caixuedengji")); 
        return R.ok().put("data", caixuedengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaixuedengjiEntity caixuedengji){
        EntityWrapper< CaixuedengjiEntity> ew = new EntityWrapper< CaixuedengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caixuedengji, "caixuedengji")); 
		CaixuedengjiView caixuedengjiView =  caixuedengjiService.selectView(ew);
		return R.ok("查询采血登记成功").put("data", caixuedengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaixuedengjiEntity caixuedengji = caixuedengjiService.selectById(id);
        return R.ok().put("data", caixuedengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaixuedengjiEntity caixuedengji = caixuedengjiService.selectById(id);
        return R.ok().put("data", caixuedengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaixuedengjiEntity caixuedengji, HttpServletRequest request){
    	caixuedengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caixuedengji);
        caixuedengjiService.insert(caixuedengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaixuedengjiEntity caixuedengji, HttpServletRequest request){
    	caixuedengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caixuedengji);
        caixuedengjiService.insert(caixuedengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaixuedengjiEntity caixuedengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caixuedengji);
        caixuedengjiService.updateById(caixuedengji);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caixuedengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CaixuedengjiEntity> wrapper = new EntityWrapper<CaixuedengjiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xianxuerenyuan")) {
			wrapper.eq("xianxuebianhao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongzuorenyuan")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = caixuedengjiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
