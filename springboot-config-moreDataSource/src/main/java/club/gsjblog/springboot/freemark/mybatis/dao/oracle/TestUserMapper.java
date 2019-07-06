package club.gsjblog.springboot.freemark.mybatis.dao.oracle;

import club.gsjblog.springboot.freemark.mybatis.bean.TestUser;
import club.gsjblog.springboot.freemark.mybatis.bean.TestUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestUserMapper {
    int countByExample(TestUserExample example);

    int deleteByExample(TestUserExample example);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    List<TestUser> selectByExample(TestUserExample example);

    int updateByExampleSelective(@Param("record") TestUser record, @Param("example") TestUserExample example);

    int updateByExample(@Param("record") TestUser record, @Param("example") TestUserExample example);
}