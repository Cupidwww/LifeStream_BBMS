package com.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.entity.UserEntity;
import com.entity.view.UserView;
import com.service.UserService;
import com.service.TokenService;
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
 * 用户接口
 * 提供用户相关的 API,如登录、注册、获取用户信息等
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TokenService tokenService;
    
    /**
     * 登录接口
     * @param username 用户名
     * @param password 密码
     * @param captcha 验证码
     * @param request HttpServletRequest
     * @return R 响应对象,包含token等信息
     */
    @IgnoreAuth  // 忽略认证
    @RequestMapping(value = "/login")  
    public R login(String username, String password, String captcha, HttpServletRequest request) {  
        UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", username));  
        if(user==null || !user.getPassword().equals(password)) {  
            return R.error("账号或密码不正确");
        }
        String token = userService.generateToken(user.getId(), username, user.getRole());  
        return R.ok().put("token", token);  
    }
    
    /**
     * 注册接口
     * @param user 用户实体
     * @return R 响应对象
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody UserEntity user){
        if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) !=null) {
            return R.error("用户已存在");
        }
        user.setRole("普通用户");
        userService.insert(user);
        return R.ok();
    }
    
    /**
     * 退出登录接口
     * @param request HttpServletRequest
     * @return R 响应对象
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }
    
    /**
     * 获取当前登录用户信息接口
     * @param request HttpServletRequest
     * @return R 响应对象,包含用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        UserEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置接口
     * @param username 用户名
     * @param request HttpServletRequest
     * @return R 响应对象
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
        UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        userService.updateById(user);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 后端列表接口
     * @param params 请求参数
     * @param user 用户实体
     * @param request HttpServletRequest
     * @return R 响应对象,包含分页信息
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,UserEntity user, HttpServletRequest request){
        EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
        PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, user), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表接口
     * @param params 请求参数
     * @param user 用户实体
     * @param request HttpServletRequest
     * @return R 响应对象,包含分页信息
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,UserEntity user, HttpServletRequest request){
        EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
        PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, user), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表接口
     * @param user 用户实体
     * @return R 响应对象,包含用户列表
     */
    @RequestMapping("/lists")
    public R list( UserEntity user){
        EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
        ew.allEq(MPUtil.allEQMapPre( user, "user")); 
        return R.ok().put("data", userService.selectListView(ew));
    }

    /**
     * 查询接口
     * @param user 用户实体
     * @return R 响应对象,包含用户详情
     */
    @RequestMapping("/query")
    public R query(UserEntity user){
        EntityWrapper< UserEntity> ew = new EntityWrapper< UserEntity>();
        ew.allEq(MPUtil.allEQMapPre( user, "user")); 
        UserView userView =  userService.selectView(ew);
        return R.ok("查询用户成功").put("data", userView);
    }
    
    /**
     * 后端详情接口
     * @param id 用户id
     * @return R 响应对象,包含用户详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        UserEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 前端详情接口
     * @param id 用户id
     * @return R 响应对象,包含用户详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        UserEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 后端保存接口
     * @param user 用户实体
     * @param request HttpServletRequest
     * @return R 响应对象
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserEntity user, HttpServletRequest request){
        user.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) !=null) {
            return R.error("用户已存在");
        }
        userService.insert(user);
        return R.ok();
    }
    
    /**
     * 前端保存接口
     * @param user 用户实体
     * @param request HttpServletRequest
     * @return R 响应对象
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody UserEntity user, HttpServletRequest request){
        user.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) !=null) {
            return R.error("用户已存在");
        }
        userService.insert(user);
        return R.ok();
    }

    /**
     * 修改接口
     * @param user 用户实体
     * @param request HttpServletRequest
     * @return R 响应对象
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserEntity user, HttpServletRequest request){
        userService.updateById(user);
        return R.ok();
    }

    /**
     * 删除接口
     * @param ids 用户id数组
     * @return R 响应对象
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        userService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
} 
