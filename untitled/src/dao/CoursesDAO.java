package dao;

import entity.Courses;

import java.util.ArrayList;

public class CoursesDAO implements DAOInterface<Courses> {
    public static CoursesDAO getInstance() {
        return new CoursesDAO();
    }

    @Override
    public int insert(Courses courses) {
        return 0;
    }

    @Override
    public int update(Courses courses) {
        return 0;
    }

    @Override
    public int delete(Courses courses) {
        return 0;
    }

    @Override
    public ArrayList<Courses> selectAll() {
        return null;
    }

    @Override
    public Courses selectById(Courses courses) {
        return null;
    }

    @Override
    public ArrayList<Courses> selectByCondition(String condition) {
        return null;
    }
}
