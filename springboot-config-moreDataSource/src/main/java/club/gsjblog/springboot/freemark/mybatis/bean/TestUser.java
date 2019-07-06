package club.gsjblog.springboot.freemark.mybatis.bean;

import java.math.BigDecimal;

public class TestUser {
    private String sname;

    private String saddress;

    private BigDecimal ssize;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress == null ? null : saddress.trim();
    }

    public BigDecimal getSsize() {
        return ssize;
    }

    public void setSsize(BigDecimal ssize) {
        this.ssize = ssize;
    }
}