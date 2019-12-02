package com.wzx.it.employeeservice.entity;

import com.wzx.it.employeeservice.utils.GenUUIDUtils;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

@Data
@Entity
@Table(name = "t_manufacture")
public class ManufactureDO {

    @Id
    @KeySql(genId = GenUUIDUtils.class)
    private String oid;

    private Long typedefinitionreference;

    private Long teamtemplateisnull;

    private Long teamtemplateoid;

    private String teamtemplateotype;

    private Long teamidisnull;

    private Long teamoid;

    private String teamotype;

    private Long organizationoid;

    private String organizationotype;

    private String lifecyclestagekey;

    private Long inheriteddomain;

    private Long branchidtypedefref;

    private Long atgatestate;

    private Long typeoid;

    private String typeotype;

    private Date createstamp = new Date();

    private Date updatestamp = new Date();

    private Long updatecount = 0L;

    private Long markfordelete = 0L;

    private String otype;

    private Long lifecycletemplateoid;

    private String lifecycletemplateotype;

    private Long lifecyclestageoid;

    private String lifecyclestageotype;

    private Date modifystamp = new Date();

    private Long containeroid;

    private String containerotype;

    private Long domainoid;

    private String domainotype;

    private Long creatoroid;

    private String creatorotype;

    private Long disabled;

    private Long updatoroid;

    private String updatorotype;

    private String name;

}