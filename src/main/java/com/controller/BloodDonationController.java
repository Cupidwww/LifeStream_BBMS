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

import com.entity.BloodDonationEntity;
import com.service.BloodDonationService;
import com.entity.view.BloodDonationView;

import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

@RestController
@RequestMapping("/blood_donation")
public class BloodDonationController {
    @Autowired
    private BloodDonationService bloodDonationService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, BloodDonationEntity bloodDonation,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        // TODO: 怎么区分这两个？
        if(tableName.equals("xianxuerenyuan")) {
//            bloodDonation.setXianxuebianhao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("gongzuorenyuan")) {
//            bloodDonation.setGonghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<BloodDonationEntity> ew = new EntityWrapper<BloodDonationEntity>();

        PageUtils page = bloodDonationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bloodDonation), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, BloodDonationEntity bloodDonation,
                  HttpServletRequest request){
        EntityWrapper<BloodDonationEntity> ew = new EntityWrapper<BloodDonationEntity>();

        PageUtils page = bloodDonationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allEq(ew, bloodDonation), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(BloodDonationEntity bloodDonation){
        EntityWrapper<BloodDonationEntity> ew = new EntityWrapper<BloodDonationEntity>();
        ew.allEq(MPUtil.allEQMapPre( bloodDonation, "blood_donation"));
        return R.ok().put("data", bloodDonationService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BloodDonationEntity bloodDonation){
        EntityWrapper<BloodDonationEntity> ew = new EntityWrapper< BloodDonationEntity>();
        ew.allEq(MPUtil.allEQMapPre( bloodDonation, "blood_donation"));
        BloodDonationView bloodDonationView =  bloodDonationService.selectView(ew);
        return R.ok("查询采血登记成功").put("data", bloodDonationView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BloodDonationEntity bloodDonation = bloodDonationService.selectById(id);
        return R.ok().put("data", bloodDonation);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BloodDonationEntity bloodDonation = bloodDonationService.selectById(id);
        return R.ok().put("data", bloodDonation);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BloodDonationEntity bloodDonation, HttpServletRequest request){
        bloodDonation.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(bloodDonation);
        bloodDonationService.insert(bloodDonation);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BloodDonationEntity bloodDonation, HttpServletRequest request){
        bloodDonation.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(bloodDonation);
        bloodDonationService.insert(bloodDonation);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BloodDonationEntity bloodDonation, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bloodDonation);
        bloodDonationService.updateById(bloodDonation);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bloodDonationService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<BloodDonationEntity> wrapper = new EntityWrapper<BloodDonationEntity>();
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

        int count = bloodDonationService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
