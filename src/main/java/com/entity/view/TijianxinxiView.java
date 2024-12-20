package com.entity.view;

import com.entity.TijianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 体检信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-17 10:40:32
 */
@TableName("tijianxinxi")
public class TijianxinxiView  extends TijianxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TijianxinxiView(){
	}
 
 	public TijianxinxiView(TijianxinxiEntity tijianxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tijianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
