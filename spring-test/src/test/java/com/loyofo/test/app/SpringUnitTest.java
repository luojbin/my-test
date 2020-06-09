package com.loyofo.test.app;

import com.loyofo.test.app.bean.MyController;
import com.loyofo.test.app.bean.MyService;
import com.loyofo.test.app.entity.Clazz;
import com.loyofo.test.app.entity.Student;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过 junit + mock 测试 mvc 组件功能, 使用 mock 测试的大致流程如下
 * <p><p>
 * 1. 制造测试数据<p>
 * 2. Mockito mock依赖组件, 指定待测方法及返回值<p>
 * 3. 构造待测控制器<p>
 * 4. MockMvcBuilders 单独启动待测 controller, 构造 mockmvc 应用<p>
 * 5. MockMvcRequestBuilders 构造 mock 请求<p>
 * 6. mockmvc 应用发起 mock 请求, 返回 resultAction<p>
 * 7. resultAction 通过 andExpect 方法校验结果
 */
public class SpringUnitTest {

    // modelAndView 测试


    private List<Clazz> getClazzDemo() {
        List<Clazz> list = new ArrayList<>();
        List<Student> c1s = new ArrayList<>();
        List<Student> c2s = new ArrayList<>();
        List<Student> c3s = new ArrayList<>();

        // 终极一班
        c1s.add(new Student(11, 1, "汪大东", 18, "台湾"));
        c1s.add(new Student(12, 1, "亚瑟王", 19, "新疆"));
        c1s.add(new Student(13, 1, "丁小雨", 22, "广东"));
        c1s.add(new Student(14, 1, "吴尊", 23, "文莱"));
        c1s.add(new Student(15, 1, "唐禹哲", 21, "福建"));
        // 木叶第七班
        c2s.add(new Student(21, 2, "鸣人", 17, "妙木山"));
        c2s.add(new Student(22, 2, "佐助", 16, "宇智波"));
        c2s.add(new Student(23, 2, "春野樱", 15, "木叶村"));
        // 三年二班
        c3s.add(new Student(31, 3, "周杰伦", 22, "秋名山"));
        c3s.add(new Student(32, 3, "方文山", 22, "台北"));
        c3s.add(new Student(33, 3, "蔡依林", 22, "台北101"));

        list.add(new Clazz(1, "终极一班", c1s.size(), c1s));
        list.add(new Clazz(2, "木叶第七班", c2s.size(), c2s));
        list.add(new Clazz(3, "三年二班", c3s.size(), c3s));
        return list;
    }


    // json 测试

}
