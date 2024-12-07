package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HealthManagementEntity;
import com.entity.view.HealthManagementView;
import com.service.HealthManagementService;

import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 健康管理
 * 后端接口
 * @author
 * @email
 * @date 2023-03-17 10:40:32
 */
@RestController
@RequestMapping("/health_management")
public class HealthManagementController {
    @Autowired
    private HealthManagementService healthManagementService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HealthManagementEntity healthManagement,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        // TODO: ??
        if(tableName.equals("xianxuerenyuan")) {
//            healthManagement.setXianxuebianhao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("gongzuorenyuan")) {
//            healthManagement.setGonghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<HealthManagementEntity> ew = new EntityWrapper<HealthManagementEntity>();

        PageUtils page = healthManagementService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, healthManagement), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HealthManagementEntity healthManagement,
                  HttpServletRequest request){
        EntityWrapper<HealthManagementEntity> ew = new EntityWrapper<HealthManagementEntity>();

        PageUtils page = healthManagementService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, healthManagement), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(HealthManagementEntity healthManagement){
        EntityWrapper<HealthManagementEntity> ew = new EntityWrapper<HealthManagementEntity>();
        ew.allEq(MPUtil.allEQMapPre( healthManagement, "healthManagement"));
        return R.ok().put("data", healthManagementService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HealthManagementEntity healthManagement){
        EntityWrapper<HealthManagementEntity> ew = new EntityWrapper<HealthManagementEntity>();
        ew.allEq(MPUtil.allEQMapPre(healthManagement, "healthManagement"));
        HealthManagementView healthManagementView =  healthManagementService.selectView(ew);
        return R.ok("查询血液检测成功").put("data", healthManagementView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HealthManagementEntity healthManagement = healthManagementService.selectById(id);
        return R.ok().put("data", healthManagement);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HealthManagementEntity healthManagement = healthManagementService.selectById(id);
        return R.ok().put("data", healthManagement);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HealthManagementEntity healthManagement, HttpServletRequest request){
        healthManagement.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(healthManagement);
        healthManagementService.insert(healthManagement);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HealthManagementEntity healthManagement, HttpServletRequest request){
        healthManagement.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(healthManagement);
        healthManagementService.insert(healthManagement);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HealthManagementEntity healthManagement, HttpServletRequest request){
        //ValidatorUtils.validateEntity(healthManagement);
        healthManagementService.updateById(healthManagement);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        healthManagementService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<HealthManagementEntity> wrapper = new EntityWrapper<HealthManagementEntity>();
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

        int count = healthManagementService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
