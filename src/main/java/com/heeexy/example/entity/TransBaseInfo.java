package com.heeexy.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 运输方式相关基础信息表   运费公式   操作费  +  运费单价/1000 * 重量
 */
@Entity
@Table(name="TransBaseInfo")
public class TransBaseInfo {

    /**
     * id
     */
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    /**
     * 国家名字
     */
    @Column(length = 128)
    private String contryName;
    /**
     * 最小重量/kg
     */
    @Column(length = 10)
    private BigDecimal minWeight;
    /**
     * 最大重量/kg
     */
    @Column(length = 10)
    private BigDecimal maxWeight;
    /**
     * 操作费/票
     */
    @Column(length = 10)
    private BigDecimal operCost;
    /**
     * 运费单价/kg
     */
    @Column(length = 10)
    private BigDecimal freightPrice;
    /**
     * 运输方式id
     */
    @Column(length = 10)
    private Integer transTypeId;
    /**
     * 送达天数
     */
    @Column(length = 128)
    private String serviceDay;
    /**
     * 是否可以跟宗 0不可以 1可以
     */
    @Column(length = 128)
    private Integer TrackFlag;
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
