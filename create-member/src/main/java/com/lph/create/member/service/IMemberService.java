package com.lph.create.member.service;

import com.lph.create.member.model.dto.MemberDto;

import java.util.List;

/**
 * @ClassName UserService
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-08-07 11:14:36
 */
public interface IMemberService {


    int insert(MemberDto member);

    int save(MemberDto member);

    List<MemberDto> selectAll();

    String getToken(String appId);

}
