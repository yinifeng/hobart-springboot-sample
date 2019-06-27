package com.hobart.sample.mapper;

import com.hobart.sample.HobartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = HobartApplication.class)
public class CoutryMapperTest {
    
    
    private CoutryMapper coutryMapper;
    
    @Test
    public void testInsert(){

    }

}
