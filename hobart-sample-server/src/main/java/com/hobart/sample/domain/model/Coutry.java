package com.hobart.sample.domain.model;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;

@Table(name = "t_hobart_coutry")
public class Coutry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@KeySql(useGeneratedKeys = true,/*dialect = IdentityDialect.MYSQL,*/order = ORDER.BEFORE)
    private Long id;

    @Column(name = "coutry_name")
    private String coutryName;

    @Column(name = "manager_id")
    private Long managerId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return coutry_name
     */
    public String getCoutryName() {
        return coutryName;
    }

    /**
     * @param coutryName
     */
    public void setCoutryName(String coutryName) {
        this.coutryName = coutryName;
    }

    /**
     * @return manager_id
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerId
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Coutry{" +
                "id=" + id +
                ", coutryName='" + coutryName + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}