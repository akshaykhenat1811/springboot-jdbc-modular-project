package com.example.SpringJdbcCrud.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringJdbcCrud.model.Course;

@Repository
public class CourseDao {

    private final JdbcTemplate jdbcTemplate;

    public CourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // INSERT
    public int save(Course c) {
        String sql = "INSERT INTO course(name, duration, fees) VALUES(?,?,?)";
        return jdbcTemplate.update(sql,
                c.getName(),
                c.getDuration(),
                c.getFees());
    }

    // SELECT ALL
    public List<Course> getAll() {
        String sql = "SELECT * FROM course";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Course c = new Course();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setDuration(rs.getString("duration")); // ✅
            c.setFees(rs.getDouble("fees"));
            return c;
        });
    }

    // SELECT BY ID
    public Course getId(int id) {
        String sql = "SELECT * FROM course WHERE id=?";
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getString("duration"));
                c.setFees(rs.getDouble("fees"));
                return c;
            }
            return null;
        }, id);
    }

    // UPDATE
    public int update(Course c) {
        String sql = "UPDATE course SET name=?, duration=?, fees=? WHERE id=?";
        return jdbcTemplate.update(sql,
                c.getName(),
                c.getDuration(),
                c.getFees(),
                c.getId());
    }

    // DELETE
    public int delete(int id) {
        String sql = "DELETE FROM course WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
