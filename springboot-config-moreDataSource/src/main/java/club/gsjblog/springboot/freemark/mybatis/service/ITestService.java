package club.gsjblog.springboot.freemark.mybatis.service;


import club.gsjblog.springboot.freemark.mybatis.bean.Student;
import club.gsjblog.springboot.freemark.mybatis.bean.TestUser;

public interface ITestService {


    void updateTwoTable(Student student, TestUser user);



}
