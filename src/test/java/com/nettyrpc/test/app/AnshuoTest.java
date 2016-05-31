package com.nettyrpc.test.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:anshuo-spring.xml")
public class AnshuoTest {

   @Value("${anshuo.app.test}")
   private String zkAddress;
   
   @Test
   public void testValue(){
	   System.out.println("zkAddress:"+zkAddress);
   }
   
}
