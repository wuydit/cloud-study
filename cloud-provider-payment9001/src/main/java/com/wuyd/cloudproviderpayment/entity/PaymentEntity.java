package com.wuyd.cloudproviderpayment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuYd
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("payment")
public class PaymentEntity extends Model<PaymentEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("serial")
    private String serial;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
