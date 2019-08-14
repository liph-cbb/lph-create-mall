package com.lph.create.member.service.impl;

import com.lph.create.member.annotation.Master;
import com.lph.create.member.dao.MemberDao;
import com.lph.create.member.model.dto.MemberDto;
import com.lph.create.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-08-07 11:15:13
 */
@Service
public class MemberService implements IMemberService {

    @Autowired
    private MemberDao memberDao;

    @Transactional
    @Override
    public int insert(MemberDto member) {
        return memberDao.insert(member);
    }

    @Master
    @Override
    public int save(MemberDto member) {
        return memberDao.insert(member);
    }

    @Override
    public List<MemberDto> selectAll() {
        return memberDao.selectAll();
    }

    @Master
    @Override
    public String getToken(String appId) {
        //  有些读操作必须读主数据库
        //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
        //  这种情况下就必须强制从主数据读
        return null;
    }

}
