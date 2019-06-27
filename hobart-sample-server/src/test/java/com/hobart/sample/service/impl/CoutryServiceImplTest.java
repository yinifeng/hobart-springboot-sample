package com.hobart.sample.service.impl;

import com.hobart.sample.HobartApplication;
import com.hobart.sample.domain.model.Coutry;
import com.hobart.sample.service.CoutryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@Transactional
@SpringBootTest(classes = HobartApplication.class)
public class CoutryServiceImplTest {
    @Autowired
    private CoutryService coutryService;

    /**
     *  tk.mybatis.mapper.additional.insert.InsertListMapper.insertList
     * 主键数据库自增生成  无法获取批量插入后回写到model中
     */
    //@Rollback
    @Test
    public void testInsert(){
        Coutry c1= new Coutry();
        c1.setCoutryName("湖南省");
        c1.setManagerId(-1L);

        Coutry c2= new Coutry();
        c2.setCoutryName("广东省");

        List<Coutry> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        //coutryService.save(c1);
        coutryService.batchSave(list);
        
        list.forEach(e->{
            System.out.println("=====>"+e);
        });
    }
    
    @Test
    public void testUpdate(){
        Coutry coutry = coutryService.selectByKey(8L);
        System.out.println("=====>"+coutry);
        coutry.setManagerId(null);
        coutryService.update(coutry);
    }

}