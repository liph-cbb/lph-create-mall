package com.lph.create.member;

import com.lph.create.member.model.dto.MemberDto;
import com.lph.create.member.service.impl.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @ClassName DemoTest
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-08-07 11:42:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testWrite() {
        MemberDto member = new MemberDto();
        member.setName("zhangsan");
        member.setId(UUID.randomUUID().toString());
        memberService.insert(member);
    }

    @Test
    public void testRead() {
        for (int i = 0; i < 4; i++) {
            memberService.selectAll();
        }
    }

    @Test
    public void testSave() {
        MemberDto member = new MemberDto();
        member.setName("wangwu");
        member.setId(UUID.randomUUID().toString());
        memberService.save(member);
    }

    @Test
    public void testReadFromMaster() {
        memberService.getToken("1234");
    }
}
