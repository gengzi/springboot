package club.gsjblog.springboot.freemark.jdbctemplate.action;

import club.gsjblog.springboot.freemark.bean.Student;
import club.gsjblog.springboot.freemark.jdbctemplate.service.IStudentService;
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
    @Qualifier("StudentServiceImpl")
    private IStudentService iStudentService;

    @Autowired
    @Qualifier("StudentServiceTxImpl")
    private IStudentService iStudentServiceTx;

    @RequestMapping(value = "/api/student/{sid}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Student findStudentInfo(@PathVariable("sid") String sid) {
        return iStudentService.getStudentInfoBySid(sid);
    }


    @RequestMapping(value = "/api/update/student/{sid}/{sname}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public void updateStudentInfo(@PathVariable("sid") String sid, @PathVariable("sname") String sname) {
        Student student = new Student();
        student.setSid(sid);
        student.setSname(sname);
//        iStudentService.updateStudentInfoBySid(student);
        iStudentServiceTx.updateStudentInfoBySid(student);
    }


}
