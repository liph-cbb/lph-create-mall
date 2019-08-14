package com.lph.create.member.controller;

import com.lph.create.member.model.dto.MemberDto;
import com.lph.create.member.service.IMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MemberController
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-08-07 16:25:54
 */
@RestController("/mem")
public class MemberController {

    private final IMemberService memberService;

    public MemberController(IMemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberDto> queryMembers(){
        return memberService.selectAll();
    }


}
