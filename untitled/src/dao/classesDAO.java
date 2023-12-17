package dao;

import entity.classes;

import java.util.ArrayList;

public class classesDAO implements DAOInterface<classes>{
    public static classesDAO getInstance() {
        return new classesDAO();
    }

    @Override
    public int insert(classes classes) {

        return 0;
    }

    @Override
    public int update(classes classes) {
        return 0;
    }

    @Override
    public int delete(classes classes) {
        return 0;
    }

    @Override
    public ArrayList<classes> selectAll() {
        return null;
    }

    @Override
    public classes selectById(classes classes) {
        return null;
    }

    @Override
    public ArrayList<classes> selectByCondition(String condition) {
        return null;
    }
}
