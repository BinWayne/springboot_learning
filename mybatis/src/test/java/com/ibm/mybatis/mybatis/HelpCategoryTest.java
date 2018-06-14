package com.ibm.mybatis.mybatis;

import com.ibm.mybatis.mybatis.entity.HelpCategory;
import com.ibm.mybatis.mybatis.mapper.HelpCategoryMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelpCategoryTest {

    @Autowired
    HelpCategoryMapper helpCategoryMapper;

    @Test
    public void selectTest(){
        List<HelpCategory> list = helpCategoryMapper.selectList();
        Assert.assertEquals("A",list.get(0).getName());
    }
}
