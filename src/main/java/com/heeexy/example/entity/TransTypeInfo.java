package com.heeexy.example.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 运输方式
 */
@Entity
@Table(name="TransTypeInfo")
public class TransTypeInfo {

    /**
     * id
     */
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    /**
     * 渠 道 鉴 权token
     */
    @Column(length = 128)
    private String name;
    /**
     * 更新时间
     */
    @Column(length = 128)
    private Timestamp updateTime;

    /**
     * 创建时间
     */
    @Column(length = 128)
    private Timestamp createTime;

    @Column(length = 4)
    private Integer status;
    /**
     * 备注
     */
    @Column(length = 128)
    private String memo;

}
