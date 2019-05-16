package ru.ryabtsev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ryabtsev.spring.entities.Student;

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
        if(student.getId() > 0) {
            String sql = "UPDATE _students SET first_name, last_name, total_mark WHERE id = ?;";
            jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getTotalMark(),
                    student.getId()
            );
        }
        else {
            String sql = "INSERT INTO _students (first_name, last_name, total_mark) VALUES (?, ?, ?);";
            jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getTotalMark());
        }
    }

    @Override
    public String findTitleById(Long id) {
        return jdbcTemplate.queryForObject("SELECT title FROM _students WHERE id = ?;", new Object[]{id}, String.class);
    }
}
