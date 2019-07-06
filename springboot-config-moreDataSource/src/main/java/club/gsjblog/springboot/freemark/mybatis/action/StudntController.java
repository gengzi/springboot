package club.gsjblog.springboot.freemark.mybatis.action;

import club.gsjblog.springboot.freemark.mybatis.bean.Student;
import club.gsjblog.springboot.freemark.mybatis.bean.TestUser;
import club.gsjblog.springboot.freemark.mybatis.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StudntController {


    @Autowired
    @Qualifier("mybatisStudentServiceTxImpl")
    private ITestService iStudentServiceTx;

    @RequestMapping(value = "/api/update/student/{sid}/{sname}/{name}/{address}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public void updateTwoInfo(@PathVariable("sid") String sid, @PathVariable("sname") String sname, @PathVariable("name") String name, @PathVariable("address")String address) {
        Student student = new Student();
        student.setSid(Integer.valueOf(sid));
        student.setSname(sname);
        TestUser testUser = new TestUser();
        testUser.setSname(name);
        testUser.setSaddress(address);
        iStudentServiceTx.updateTwoTable(student,testUser);
    }


}
