package com.loyofo.test.app.bean;

import com.loyofo.test.app.entity.Clazz;
import com.loyofo.test.app.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/hello")
@Controller
public class MyController {

    //region 初始化
    {
        logger.info("HelloController 已创建:{}",  this);
    }

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);
    //endregion

    @RequestMapping("jsonAll")
    @ResponseBody
    public List<Clazz> jsonAll(){
        return myService.getAll();
    }
    @RequestMapping("mavAll")
    public ModelAndView mavAll(){
        Map<String, Object> data = new HashMap<>();
        data.put("mavData", myService.getAll());
        return new ModelAndView("mavAllView", data);
    }

    @RequestMapping("clazz/{id}")
    @ResponseBody
    public Clazz getClazz(@PathVariable("id") String clazzId) {
        logger.info("尝试获取 clazz");
        Clazz clazz = myService.getClazz(clazzId);
        logger.info("成功获取 clazz: {}", clazz);
        return clazz;
    }

    @RequestMapping("student")
    @ResponseBody
    public String student(Student student) {
        System.out.println(student);
        System.out.println("中文测试");
        return "测试通过";
    }
    @RequestMapping("chn")
    @ResponseBody
    public String chn(String msg) {
        System.out.println(msg);
        System.out.println("中文测试");
        return "测试通过";
    }
}
