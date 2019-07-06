package club.gsjblog.springboot.freemark.jdbctemplate.dao;

import club.gsjblog.springboot.freemark.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Administrator on 2019/7/2.
 */
public interface StudentMapperJdbc {

    Student getStudentInfo(String sid);

    void updateStudentInfo(String jdbcTemplate, Student student);

}
