package com.loyofo.test.app.bean;

import com.loyofo.test.app.entity.Clazz;
import com.loyofo.test.app.entity.Score;
import com.loyofo.test.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Clazz getClazzById(String id) {
        String sql = "select * from clazz where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Clazz.class), id);
    }

    public Student getStudentById(String id) {
        String sql = "select * from student where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
    }

    public List<Clazz> getAllClazz() {
        String sql = "select * from clazz";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Clazz.class));
    }

    public List<Student> getAllStudent() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    public List<Score> getAllScore() {
        String sql = "select * from score";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Score.class));
    }
}
