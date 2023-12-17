package dao;

import entity.Tuitionfee;

import java.util.ArrayList;

public class TuitionfeeDAO implements DAOInterface<Tuitionfee>{
    public static TuitionfeeDAO getInstance() {
        return new TuitionfeeDAO();
    }

    @Override
    public int insert(Tuitionfee tuitionfee) {
        return 0;
    }

    @Override
    public int update(Tuitionfee tuitionfee) {
        return 0;
    }

    @Override
    public int delete(Tuitionfee tuitionfee) {
        return 0;
    }

    @Override
    public ArrayList<Tuitionfee> selectAll() {
        return null;
    }

    @Override
    public Tuitionfee selectById(Tuitionfee tuitionfee) {
        return null;
    }

    @Override
    public ArrayList<Tuitionfee> selectByCondition(String condition) {
        return null;
    }
}
