package com.loyofo.test.app.bean;

import com.loyofo.test.app.entity.Clazz;
import com.loyofo.test.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class MyService {

    @Autowired
    private MyDao myDao;

    public Clazz getClazz(String id) {
        return myDao.getClazzById(id);
    }

    public Student getStudentById(String id) {
        return myDao.getStudentById(id);
    }

    public List<Clazz> getAll() {
        List<Clazz> clazzList = myDao.getAllClazz();
        List<Student> studentList = myDao.getAllStudent();

        clazzList.forEach(c -> {
            List<Student> cs = studentList.stream()
                    .filter(s -> Objects.equals(c.getId(), s.getClassId()))
                    .sorted(Comparator.comparingInt(Student::getId))
                    .collect(Collectors.toList());
            c.setStudentList(cs);
        });
        return clazzList;
    }
}
