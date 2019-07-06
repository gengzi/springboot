package club.gsjblog.springboot.freemark.jdbctemplate.service;

import club.gsjblog.springboot.freemark.bean.Student;
import org.hamcrest.StringDescription;

public interface IStudentService {


    Student getStudentInfoBySid(String sid);

    void updateStudentInfoBySid(Student student);



}
