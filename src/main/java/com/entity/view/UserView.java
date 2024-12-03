package com.entity.view;

import com.entity.UserEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
 * 用户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("user") // 指定表名
public class UserView extends UserEntity implements Serializable {  // 实现Serializable接口
	private static final long serialVersionUID = 1L; // 序列化ID

	public UserView() { // 无参构造函数
	}
	
	public UserView(UserEntity userEntity) { // 有参构造函数
		try {
			BeanUtils.copyProperties(this, userEntity); // 复制属性
		} catch (IllegalAccessException | InvocationTargetException e) {  // 捕获异常
			e.printStackTrace(); // 打印异常信息
		}
	}
} 