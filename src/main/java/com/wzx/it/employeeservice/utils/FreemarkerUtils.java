package com.wzx.it.employeeservice.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.*;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class FreemarkerUtils {
    private static final Map<String, TemplateModel> sharedVaribleMap = new HashMap<>();

    /**
     * 使用StringTemplate进行模版转换
     * @param templateText
     * @param data
     * @return
     * @throws Exception
     */
    public static String processWithStringTemplate(String templateText,Object data) throws Exception {
        Properties properties = new Properties();
        properties.put("template_update_delay",0);
        properties.put("defaultEncoding","UTF-8");
        properties.put("url_escaping_charset","UTF-8");
        properties.put("locale","zh_CN");
        properties.put("number_format","#.##");

        StringTemplateLoader loader = new StringTemplateLoader();
        loader.putTemplate("tpl",templateText);
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setSharedVaribles(sharedVaribleMap);
        configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
        configuration.setTemplateLoader(loader);
        configuration.setSettings(properties);

        Template template = configuration.getTemplate("tpl");
        StringWriter writer = new StringWriter();
        template.process(data,writer);
        return writer.toString();

    }

    public static void addSharedVariable(String key,TemplateDirectiveModel directiveModel){
        sharedVaribleMap.put(key,directiveModel);
    }
}
