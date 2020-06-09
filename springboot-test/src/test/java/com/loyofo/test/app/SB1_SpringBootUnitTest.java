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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class SB1_SpringBootUnitTest {
    @Test
    public void testModelAndView() throws Exception {
        List<Clazz> expectedResult = getClazzDemo();
        MyService myService = Mockito.mock(MyService.class);
        Mockito.when(myService.getAll()).thenReturn(expectedResult);

        MyController controller = new MyController(myService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                // 因视图名与请求路径相同, 需要设置singleView, 避免循环引用
                // 具体路径没有作用, 可以随便设置
                .setSingleView(new InternalResourceView("/WEB-INF/views/mavAll.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/mavAll"))
                .andExpect(MockMvcResultMatchers.view().name("mavAllView"))
                .andExpect(MockMvcResultMatchers.model().attribute("mavData", Matchers.hasItems(expectedResult.toArray())));
    }
    // json 测试
    @Test
    public void testJson() throws Exception {
        List<Clazz> expectedResult = getClazzDemo();
        MyService myService = Mockito.mock(MyService.class);
        Mockito.when(myService.getAll()).thenReturn(expectedResult);

        MyController controller = new MyController(myService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/jsonAll"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].className").value("终极一班"))
                .andExpect(jsonPath("$[1].className").value("木叶第七班"))
                .andExpect(jsonPath("$[2].className").value("三年二班"))
        ;
    }

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

}
