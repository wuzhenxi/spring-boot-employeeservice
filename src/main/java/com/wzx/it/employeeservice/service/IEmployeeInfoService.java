package com.wzx.it.employeeservice.service;

import com.wzx.it.employeeservice.domain.EmployeeInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IEmployeeInfoService {

    public List<EmployeeInfo> getEmpInfos();

    public String exportEmployee(String exportType,HttpServletResponse response);
}
