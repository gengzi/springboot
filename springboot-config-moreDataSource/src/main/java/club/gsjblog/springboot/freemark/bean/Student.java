package club.gsjblog.springboot.freemark.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/7/2.
 */
public class Student implements Serializable{
    private String sid;
    private String sname;
    private String sage;
    private String ssex;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sage='" + sage + '\'' +
                ", ssex='" + ssex + '\'' +
                '}';
    }
}
