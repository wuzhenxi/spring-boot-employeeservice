package com.wzx.it.employeeservice.config;

import com.wzx.it.employeeservice.label.GeneteDecryptDirective;
import com.wzx.it.employeeservice.utils.ApplicationUtils;
import com.wzx.it.employeeservice.utils.FreemarkerUtils;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
public class DirectiveInit {
    @PostConstruct
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ContextRefreshedEvent){
            log.info("初始化标签------>>");
            FreemarkerUtils.addSharedVariable("GeneteDecryptDirective", ApplicationUtils.getBean(GeneteDecryptDirective.class));
        }
    }
}
