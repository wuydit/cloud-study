package org.wuyd.cloudconsumerorder9002.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serial;

}
