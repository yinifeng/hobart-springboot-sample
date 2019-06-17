package com.hobart.sample.common.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hobart.sample.core.dto.LoginAuthDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Transient
    private Integer pageNum;

    @Transient
    private Integer pageSize;

    @Transient
    private String orderBy;

    @Transient
    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }

    /**
     * Sets update info.
     *
     * @param user the user
     */
    @Transient
    @JsonIgnore
    public void setUpdateInfo(LoginAuthDto user) {

        if (isNew()) {
            this.creator = (this.updator = user.getUserAccount());
            this.createTime = (this.updateTime = new Date());
        }
        this.updator = user.getUserAccount();
        this.updateTime = new Date();
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

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

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
