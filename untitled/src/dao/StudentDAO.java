package dao;

import entity.Student;

import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student>{
    public static StudentDAO getInstance() {
        return new StudentDAO();
    }

    @Override
    public int insert(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int delete(Student student) {
        return 0;
    }

    @Override
    public ArrayList<Student> selectAll() {
        return null;
    }

    @Override
    public Student selectById(Student student) {
        return null;
    }

    @Override
    public ArrayList<Student> selectByCondition(String condition) {
        return null;
    }
}
