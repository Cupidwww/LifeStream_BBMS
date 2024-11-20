package com.entity.view;

import com.entity.YingyangbutieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 营养补贴
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
@TableName("yingyangbutie")
public class YingyangbutieView  extends YingyangbutieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YingyangbutieView(){
	}
 
 	public YingyangbutieView(YingyangbutieEntity yingyangbutieEntity){
 	try {
			BeanUtils.copyProperties(this, yingyangbutieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
