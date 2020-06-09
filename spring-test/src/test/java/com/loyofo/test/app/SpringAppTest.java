package com.loyofo.test.app;


import com.loyofo.test.app.bean.MyService;
import com.loyofo.test.config.RootConfig;
import com.loyofo.test.app.entity.Clazz;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
@Transactional
public class SpringAppTest {

    @Autowired
    private MyService helloMyService;

    @Test
    public void testGetAll() {
        Clazz expected = new Clazz();
        expected.setClassName("终极一班");
        expected.setId(1);
        expected.setStudentAmount(5);

        Clazz actual = helloMyService.getClazz("1");
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
    }
}
