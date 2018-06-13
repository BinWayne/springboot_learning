package com.ibm.mybatis.mybatis;

import com.ibm.mybatis.mybatis.entity.User;
import com.ibm.mybatis.mybatis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	@Rollback
	public void findByName(){
		userMapper.insert("AAA",20);
		User user = userMapper.findByName("AAA");
		Assert.assertEquals(20,user.getAge().intValue());
	}
}
