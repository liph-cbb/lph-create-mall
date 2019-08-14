package com.lph.create.member.dao;

import com.lph.create.member.model.dto.MemberDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName MemberDao
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-08-07 11:30:36
 */
@Repository
@Mapper
public interface MemberDao {

    @Insert("insert into t_member_member (id,name) values (#{id},#{name})")
    int insert(MemberDto member);

    @Select("select * from t_member_member")
    List<MemberDto> selectAll();
}
