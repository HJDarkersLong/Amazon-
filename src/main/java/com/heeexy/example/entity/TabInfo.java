package com.heeexy.example.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="TabInfo")
public class TabInfo {

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
     * 渠 道 鉴 权token
     */
    @Column(length = 128)
    private String typeid;
    /**
     *
     */
    @Column(length = 128)
    private String typeid1;
    /**
     *
     */
    @Column(length = 128)
    private String typeid2;

    @Column(length = 128)
    private String typeid3;

    @Column(length = 128)
    private String level;

    @Column(length = 128)
    private String dsc;
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

}
