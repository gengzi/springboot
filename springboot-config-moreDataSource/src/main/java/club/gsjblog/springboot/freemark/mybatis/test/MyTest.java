package club.gsjblog.springboot.freemark.mybatis.test;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2019/7/4.
 */
public class MyTest {

    public static void main(String[] args) {

//        String ageSql = "\n" +
//                "( select * from  (select replace ( ( t1.data1 || '0岁~' ) , '00' ,'0' ) || ( t1.data1 + 1 )\n" +
//                " || '0岁' name, t1.data2 value from ( select  mod( trunc(t.age) , 10)  data1, count(*) data2\n" +
//                "  from TBL_BASEINFO_POSITIVECASES t\n" +
//                "  where t.age >= 0\n" +
//                " and t.age < 100 group by  mod( trunc(t.age) , 10)  ) t1\n" +
//                " order by data1  ) )\n" +
//                " union all \n" +
//                " ( select '其他' , count(*) from TBL_BASEINFO_POSITIVECASES t\n" +
//                "where t.age is null or  t.age <0  or t.age >= 100 )\n"
//                ;
//
//        System.out.println(ageSql);


//        //性别
//        String sexSql=
//                "select \n" +
//                        "(case when to_char(typename) is null then '空项/其他' else to_char(typename) end) as name,\n" +
//                        "sum(counts) as value from (select t1.typename,t1.typecode,t.counts from(\n" +
//                        "select t.sex_new as typecode ,count(1) as counts from tbl_baseinfo_positivecases t \n" + tj +
//                        "group by t.sex_new) t LEFT JOIN\n" +
//                        "(select t1.typecode,t1.typename from t_s_typegroup t,t_s_type t1 where t.typegroupcode = 'sex'\n" +
//                        "and t.id = t1.typegroupid)t1\n" +
//                        "on t.typecode = t1.typecode)a\n" +
//                        "group by to_char(typename),typecode order by typecode";
//
//
//        System.out.println(sexSql);

        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(String.valueOf(df.format(0.014231741)));




    }
}
