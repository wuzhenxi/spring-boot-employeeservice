package com.wzx.it.employeeservice.service.impl;

import com.wzx.it.employeeservice.domain.EmployeeInfo;
import com.wzx.it.employeeservice.domain.EmployeeInfoRepository;
import com.wzx.it.employeeservice.service.IEmployeeInfoService;
import com.wzx.it.employeeservice.utils.JsonUtils;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Service
public class EmployeeInfoServiceImpl implements IEmployeeInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeInfoServiceImpl.class);
    private static final String EXPORT_TEMPLATE = "1";

    @Autowired private EmployeeInfoRepository employeeInfoRepository;

    @Override
    public List<EmployeeInfo> getEmpInfos() {
        return  employeeInfoRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @Override
    public String exportEmployee(String exportType, HttpServletResponse response) {
        if(EXPORT_TEMPLATE.equals(exportType)){
            try {
                exportTemplate(response);
            } catch (IOException e) {
                return JsonUtils.fail(e.getMessage());
            }
            return JsonUtils.success();
        } else {

            return null;
        }
    }

    private void exportTemplate(HttpServletResponse response) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        InputStream inputStream = ClassUtils.getDefaultClassLoader().getResourceAsStream("static/employee.xlsx");
        IOUtils.copy(inputStream,outputStream);
        inputStream.close();
        outputStream.close();
    }

}
