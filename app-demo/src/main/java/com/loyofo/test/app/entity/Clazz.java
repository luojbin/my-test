package com.loyofo.test.app.entity;

import java.util.List;
import java.util.Objects;

public class Clazz {



    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", studentAmount=" + studentAmount +
                ", studentList=" + studentList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Clazz clazz = (Clazz) o;
        return Objects.equals(id, clazz.id) &&
                Objects.equals(className, clazz.className) &&
                Objects.equals(studentAmount, clazz.studentAmount) &&
                Objects.equals(studentList, clazz.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className, studentAmount, studentList);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clazz(Integer id, String className, Integer studentAmount, List<Student> studentList) {
        this.id = id;
        this.className = className;
        this.studentAmount = studentAmount;
        this.studentList = studentList;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(Integer studentAmount) {
        this.studentAmount = studentAmount;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    Integer id;

    public Clazz() {
    }

    String className;
    Integer studentAmount;
    List<Student> studentList;
    static List<Student> staticList;

    public String toUpperCase() {return getClassName().toUpperCase();}
}
