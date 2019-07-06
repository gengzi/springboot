package club.gsjblog.springboot.freemark.jdbctemplate.dao.impl;

import club.gsjblog.springboot.freemark.bean.Student;
import club.gsjblog.springboot.freemark.jdbctemplate.dao.StudentMapperJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */
@Service
public class StudentMapperImpl implements StudentMapperJdbc {

    @Autowired
    @Qualifier("msqlJdbcTemplate")
    private JdbcTemplate mysqljdbcTemplate;

    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate oraclejdbcTemplate;

    @Override
    public Student getStudentInfo(String sid) {
        String sql = "select sname from student where sid='"+sid+"'";
        List<Student> listInfo = oraclejdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
        if(listInfo.size() > 0){
            return listInfo.get(0);
        }
        return null;
    }

    @Override
    public void updateStudentInfo(String jdbcTemplate, Student student) {
        JdbcTemplate jt = mysqljdbcTemplate;
        if(jdbcTemplate!=null && "mysqljdbcTemplate".equals(jdbcTemplate)){
            jt =  mysqljdbcTemplate;
        }else if(jdbcTemplate!=null && "oraclejdbcTemplate".equals(jdbcTemplate)){
            jt = oraclejdbcTemplate;
        }
        String sql = "";
        if(!StringUtils.isEmpty(student)){
            sql = "UPDATE student SET sname = '"+student.getSname()+"' WHERE sid = '"+student.getSid()+"'";
            int update = jt.update(sql);
            if(update >0){
                System.out.println("更新成功");
            }
        }
    }
}
