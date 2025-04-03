package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.AddressVO;
import org.nonage.domain.MemberVO;
import org.nonage.mapper.MemberMapper;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Log4j
public class MemberServiceImpl implements MemberService{


    private MemberMapper memberMapper;

    @Override
    public MemberVO login(String id, String pwd) {
        return memberMapper.login(id, pwd);
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @Override
    public void join(MemberVO newMember) {
        memberMapper.join(newMember);
    }

    @Override
    public int idCheck(String id) {
        return memberMapper.idCheck(id);
    }

    @Override
    public ArrayList<AddressVO> findZipNum(String dong) {
        return memberMapper.findZipNum(dong);
    }

}
