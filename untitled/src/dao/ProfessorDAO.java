package dao;

import entity.Professor;

import java.util.ArrayList;

public class ProfessorDAO implements DAOInterface<Professor> {
    public static ProfessorDAO getInstance() {
        return new ProfessorDAO();
    }

    @Override
    public int insert(Professor professor) {
        return 0;
    }

    @Override
    public int update(Professor professor) {
        return 0;
    }

    @Override
    public int delete(Professor professor) {
        return 0;
    }

    @Override
    public ArrayList<Professor> selectAll() {
        return null;
    }

    @Override
    public Professor selectById(Professor professor) {
        return null;
    }

    @Override
    public ArrayList<Professor> selectByCondition(String condition) {
        return null;
    }
}
