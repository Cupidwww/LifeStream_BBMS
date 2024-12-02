package com.entity.view;

import com.entity.BloodBankEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
 * 血库管理
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("blood_bank_management") // 指定表名
public class BloodBankView extends BloodBankEntity implements Serializable { // 实现Serializable接口
    private static final long serialVersionUID = 1L; // 序列化ID

    public BloodBankView() {
    }
    
    public BloodBankView(BloodBankEntity bloodBankEntity) { // 有参构造函数
        try {
            BeanUtils.copyProperties(this, bloodBankEntity); // 复制属性
        } catch (IllegalAccessException | InvocationTargetException e) { // 捕获异常
            e.printStackTrace(); // 打印异常信息
        }
    }
} 