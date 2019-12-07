package com.wzx.it.employeeservice.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_part")
public class PartInfo {

    @Id
    @Column(name = "oid")
    @GeneratedValue(generator = "uuid")
    private String oid;

    private Long parttypeoid;

    private String parttypeotype;

    private Long sourceoid;

    private String sourceotype;

    private Long projectoid;

    private String projectotype;

    private Long cabinetoid;

    private String cabinetotype;

    private Long teamoid;

    private String teamotype;

    private Long templateoid;

    private String templateotype;

    private Long adchocacluseroid;

    private String adchocacluserotype;

    private Long checkoutinfooid;

    private String checkoutinfootype;

    private Long levelinfo;

    private Long branchidtypedefref;

    private Long ownerrefisnulladhocacl;

    private Long minimumrequired;

    private Long viewisnull;

    private Long resourcecategroyid;

    private Long maximumallowed;

    private Long teamidisnull;

    private Long adhocaclisnull;

    private Long inheriteddomain;

    private Long checkoutinfoisnull;

    private Long teamtemplateidisnull;

    private Long projectidisnull;

    private Long indexersetisnull;

    private Long atgatestate;

    private Long typeid;

    private String indexersindexerset;

    private String eventset;

    private String entrysetadhocacl;

    private String subfoldername;

    private String parttypekey;

    private String orgcode;

    private String iterationstate;

    private String oneoffversion;

    private String lifecyclestagekey;

    private String jobauthorizationnumber;

    private String securitylabels;

    private String englishdescription;

    private String partnumber;

    private String foldernameinfo;

    private String contractnumber;

    private String phase;

    private String variation1;

    private String variation2;

    private String sourcekey;

    private String versionvalue;

    private Long viewdefoid;

    private String viewdefotype;

    private Date createstamp;

    private Date updatestamp;

    private Long updatecount;

    private Long markfordelete;

    private String otype;

    private String iterationnote;

    private Long masteredoid;

    private String masteredotype;

    private Long islastiterated;

    private String iterationid;

    private Long sourceiterationoid;

    private String sourceiterationotype;

    private Long branchid;

    private String version;

    private Long versionlevel;

    private String versionsort;

    private Long typeoid;

    private String typeotype;

    private String lockstateinfo;

    private Date lastupdatestamp;

    private Long islocked;

    private Long lockstate;

    private Date lockdate;

    private String locknote;

    private Long lockeroid;

    private String lockerotype;

    private Long lifecycletemplateoid;

    private String lifecycletemplateotype;

    private Long lifecyclestageoid;

    private String lifecyclestageotype;

    private Date modifystamp;

    private Long subfolderoid;

    private String subfolderotype;

    private Long appdomainrefoid;

    private String appdomainrefotype;

    private Long containeroid;

    private String containerotype;

    private Long domainoid;

    private String domainotype;

    private Long creatoroid;

    private String creatorotype;

    private String name;

    private String description;

    private Long owneroid;

    private String ownerotype;

    private Long updatoroid;

    private String updatorotype;

    private Long securitylabeledoid;

    private String securitylabeledotype;

}
