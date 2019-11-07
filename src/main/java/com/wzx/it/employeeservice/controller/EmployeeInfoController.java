package com.wzx.it.employeeservice.controller;

import com.wzx.it.employeeservice.cache.EmployeeCache;
import com.wzx.it.employeeservice.domain.EmployeeInfo;
import com.wzx.it.employeeservice.domain.FreemarkerDomain;
import com.wzx.it.employeeservice.service.impl.EmployeeInfoServiceImpl;
import com.wzx.it.employeeservice.utils.FreemarkerUtils;
import com.wzx.it.employeeservice.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/employee")
@ResponseBody
@Slf4j
public class EmployeeInfoController {
    private static final String EXPORT_TEMPLATE = "1";

    @Autowired
    private EmployeeInfoServiceImpl employeeInfoService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private EmployeeCache employeeCache;

    @RequestMapping(value = "/getEmpInfos", method = RequestMethod.GET)
    public String getEmpInfos() {
        log.info("查询人员信息begin");
        try {
            List<EmployeeInfo> result = employeeCache.getAllEmployeesByCache();
//            List<EmployeeInfo> result = employeeInfoService.getEmpInfos();
            log.info("查询人员信息end");
            response.addCookie(new Cookie("userId","wuzhenxi123"));
//            response.sendRedirect("http://www.baidu.com");
            return JsonUtils.success(result);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            return JsonUtils.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String exportEmployee(@RequestParam(name = "exportType") String exportType) {
        log.info("导出人员信息begin");
        try {
            String result = employeeInfoService.exportEmployee(exportType, response);
            log.info("导出人员信息end");
            return JsonUtils.success(result);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            return JsonUtils.fail(e.getMessage());
        }
    }

    @PostMapping(name = "/freemarter/demo")
    public String transDataForFreemarker(@RequestParam(name = "freemarkerDomain") FreemarkerDomain freemarkerDomain, @RequestParam(name = "templateText") String templateText) {
        String result = null;
        try {
            result = FreemarkerUtils.processWithStringTemplate(templateText, freemarkerDomain);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonUtils.error(e.getMessage());
        }
        return JsonUtils.success(result);
    }

    @GetMapping(value = "/cache/{id}")
    public String getEmployeeById(@PathVariable("id")String id) throws Exception {
        log.info("get employee for cache by id = {}",id);
        EmployeeInfo employees = employeeCache.getEmployeesByCache(Integer.valueOf(id));
        log.info("the result :{}",employees.toString());
        return JsonUtils.success(employees);
    }
}
