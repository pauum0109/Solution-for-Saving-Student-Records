package dao;

import entity.Scholarship;

import java.util.ArrayList;

public class ScholarshipDAO implements DAOInterface<Scholarship> {
    public static ScholarshipDAO getInstance() {
        return new ScholarshipDAO();
    }

    @Override
    public int insert(Scholarship scholarship) {
        return 0;
    }

    @Override
    public int update(Scholarship scholarship) {
        return 0;
    }

    @Override
    public int delete(Scholarship scholarship) {
        return 0;
    }

    @Override
    public ArrayList<Scholarship> selectAll() {
        return null;
    }

    @Override
    public Scholarship selectById(Scholarship scholarship) {
        return null;
    }

    @Override
    public ArrayList<Scholarship> selectByCondition(String condition) {
        return null;
    }
}
