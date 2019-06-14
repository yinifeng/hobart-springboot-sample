package com.hobart.sample.common.mybatis;

import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


public class BaseEntity implements Serializable{
    private static final long serialVersionUID = 2393269568666085258L;

    /**
     * 
     * mapper.order=BEFORE
     * mapper.before=true
     * UUID 生成主键 @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
     * 
     * 主键id，目前系统都是用UUID生成
     */
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    @KeySql(order = ORDER.BEFORE,genId = UUIDKey.class)
    private String id;
    /**
     * 创建人
     */
    @Column(name = "creator")
    private String creator;
    /**
     * 修改人
     */
    @Column(name = "updator")
    private String updator;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
