package com.wzx.it.employeeservice.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_team")
public class Team {
    @Id
    private Integer teamId;
    private String teamName;
    private String teamOwner;
}
