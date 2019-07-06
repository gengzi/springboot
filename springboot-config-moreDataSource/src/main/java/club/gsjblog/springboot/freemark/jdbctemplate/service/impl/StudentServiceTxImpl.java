package club.gsjblog.springboot.freemark.jdbctemplate.service.impl;


import club.gsjblog.springboot.freemark.bean.Student;
import club.gsjblog.springboot.freemark.jdbctemplate.dao.StudentMapperJdbc;
import club.gsjblog.springboot.freemark.jdbctemplate.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("StudentServiceTxImpl")
@Transactional("xatx")// 使用事物注解，只能支持一个数据源的事物管理
public class StudentServiceTxImpl implements IStudentService {

    @Autowired
    private StudentMapperJdbc studentMapper;

    @Override
    public Student getStudentInfoBySid(String sid) {
        return studentMapper.getStudentInfo(sid);
    }


    @Override
    public void updateStudentInfoBySid(Student student) {

        studentMapper.updateStudentInfo("mysqljdbcTemplate", student);
        studentMapper.updateStudentInfo("oraclejdbcTemplate", student);
        int i = 1 / 0; // 触发运行时异常
        /**
         *  需要实现的效果： 两个数据源的事物都进行回滚
         *  现在的效果：
         */
    }
}
