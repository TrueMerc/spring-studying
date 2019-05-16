package ru.ryabtsev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("JdbcTemplate")
public class JdbcTemplateStudentDAO implements StudentDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateStudentDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO _students (first_name, last_name, total_mark) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getTotalMark());
    }

    @Override
    public Student findTitleById(Long id) {
        String firstName = "";
        String lastName = "";
        Integer totalMark;

        try {
            firstName = jdbcTemplate.queryForObject("SELECT first_name FROM _students WHERE id = ?;", new Object[]{id}, String.class);
            lastName = jdbcTemplate.queryForObject("SELECT last_name FROM _students WHERE id = ?;", new Object[]{id}, String.class);
            totalMark = jdbcTemplate.queryForObject("SELECT total_mark FROM _students WHERE id = ?;", new Object[]{id}, Integer.class);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }

        Student student = new Student();
        student.setId(id.intValue());
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setTotalMark(totalMark);
        return student;
    }
}
