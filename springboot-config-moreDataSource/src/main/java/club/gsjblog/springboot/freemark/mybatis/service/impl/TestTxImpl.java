package club.gsjblog.springboot.freemark.mybatis.service.impl;


import club.gsjblog.springboot.freemark.mybatis.bean.Student;
import club.gsjblog.springboot.freemark.mybatis.bean.StudentExample;
import club.gsjblog.springboot.freemark.mybatis.bean.TestUser;
import club.gsjblog.springboot.freemark.mybatis.bean.TestUserExample;
import club.gsjblog.springboot.freemark.mybatis.dao.mysql.StudentMapper;
import club.gsjblog.springboot.freemark.mybatis.dao.oracle.TestUserMapper;
import club.gsjblog.springboot.freemark.mybatis.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mybatisStudentServiceTxImpl")
@Transactional("xatx")// 使用事物注解，只能支持一个数据源的事物管理
public class TestTxImpl implements ITestService {


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TestUserMapper testUserMapper;

    @Override
    public void updateTwoTable(Student student, TestUser user) {

        StudentExample studentExample = new StudentExample();
        studentMapper.insert(student);

        TestUserExample testUserExample = new TestUserExample();
        testUserMapper.insert(user);

//        int i = 1 / 0; // 触发运行时异常
        /**
         *  需要实现的效果： 两个数据源的事物都进行回滚
         *  现在的效果：
         */

    }
}
