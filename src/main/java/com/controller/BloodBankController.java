package com.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.entity.BloodBankEntity;
import com.entity.view.BloodBankView;
import com.service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 血库管理接口
 */
@RestController
@RequestMapping("/bloodbank")
public class BloodBankController {
    @Autowired
    private BloodBankService bloodBankService;
    
    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BloodBankEntity bloodBank, HttpServletRequest request){
        EntityWrapper<BloodBankEntity> ew = new EntityWrapper<BloodBankEntity>();
        PageUtils page = bloodBankService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bloodBank), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BloodBankEntity bloodBank, HttpServletRequest request){
        EntityWrapper<BloodBankEntity> ew = new EntityWrapper<BloodBankEntity>();
        PageUtils page = bloodBankService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allEq(ew, bloodBank), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BloodBankEntity bloodBank){
        EntityWrapper<BloodBankEntity> ew = new EntityWrapper<BloodBankEntity>();
        ew.allEq(MPUtil.allEQMapPre( bloodBank, "bloodbank")); 
        return R.ok().put("data", bloodBankService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BloodBankEntity bloodBank){
        EntityWrapper< BloodBankEntity> ew = new EntityWrapper< BloodBankEntity>();
        ew.allEq(MPUtil.allEQMapPre( bloodBank, "bloodbank")); 
        BloodBankView bloodBankView =  bloodBankService.selectView(ew);
        return R.ok("查询血库管理成功").put("data", bloodBankView);
    }
    
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BloodBankEntity bloodBank = bloodBankService.selectById(id);
        return R.ok().put("data", bloodBank);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BloodBankEntity bloodBank = bloodBankService.selectById(id);
        return R.ok().put("data", bloodBank);
    }
    
    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BloodBankEntity bloodBank, HttpServletRequest request){
        bloodBank.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        bloodBankService.insert(bloodBank);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody BloodBankEntity bloodBank, HttpServletRequest request){
        bloodBank.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        bloodBankService.insert(bloodBank);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BloodBankEntity bloodBank, HttpServletRequest request){
        bloodBankService.updateById(bloodBank);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bloodBankService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
} 