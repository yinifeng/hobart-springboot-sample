package com.hobart.sample.service;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

public interface FreeMarkerService {

    String getTemplate(Map<String, Object> map, String templateLocation) throws IOException, TemplateException;
}
