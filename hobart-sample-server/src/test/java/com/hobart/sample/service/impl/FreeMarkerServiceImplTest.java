package com.hobart.sample.service.impl;

import com.google.common.collect.Maps;
import com.hobart.sample.HobartApplication;
import com.hobart.sample.service.FreeMarkerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = HobartApplication.class)
public class FreeMarkerServiceImplTest {
    @Autowired
    private FreeMarkerService freeMarkerService;

    @Test
    public void getTemplate() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("loginName","hubo");
        map.put("dateTime","2019-06-22");
        String template = freeMarkerService.getTemplate(map, "email/user.ftl");
        System.out.println(template);
    }
}
