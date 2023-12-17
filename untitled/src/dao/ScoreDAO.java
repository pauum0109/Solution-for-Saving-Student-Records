package dao;

import entity.Score;

import java.util.ArrayList;

public class ScoreDAO implements DAOInterface<Score>{
    public static ScoreDAO getInstance() {
        return new ScoreDAO();
    }

    @Override
    public int insert(Score score) {
        return 0;
    }

    @Override
    public int update(Score score) {
        return 0;
    }

    @Override
    public int delete(Score score) {
        return 0;
    }

    @Override
    public ArrayList<Score> selectAll() {
        return null;
    }

    @Override
    public Score selectById(Score score) {
        return null;
    }

    @Override
    public ArrayList<Score> selectByCondition(String condition) {
        return null;
    }
}
