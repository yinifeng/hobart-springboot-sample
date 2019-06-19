package com.hobart.sample.service.impl;

import com.google.common.base.Preconditions;
import com.hobart.sample.core.helper.StringHelper;
import com.hobart.sample.service.FreeMarkerService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Service
public class FreeMarkerServiceImpl implements FreeMarkerService{
    @Resource
    private Configuration configuration;
    
    @Override
    public String getTemplate(Map<String, Object> map, String templateLocation) throws IOException, TemplateException {
        Preconditions.checkArgument(StringHelper.isNotEmpty(templateLocation), "模板不能为空");

        Template t = configuration.getTemplate(templateLocation, "UTF-8");
        return FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
    }
}
