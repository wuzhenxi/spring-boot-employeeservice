package com.wzx.it.employeeservice.label;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class GeneteDecryptDirective implements TemplateDirectiveModel {

    /**
     * @param environment           环境输出
     * @param map                   参数
     * @param templateModels        循环
     * @param templateDirectiveBody 内容
     */
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) {
        log.info("freemarker template execute");
        environment.getOut();
    }
}
