package com.wzx.it.employeeservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_employee")
public class EmployeeInfo {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "emp_name",nullable = false)
    private String name;
    @Column(name = "emp_telphone",nullable = false,unique = true)
    private String telphone;

}
