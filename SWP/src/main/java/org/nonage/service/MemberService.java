package org.nonage.service;

import org.nonage.domain.MemberVO;
import org.nonage.domain.AddressVO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public interface MemberService {
    public MemberVO login(String id, String pwd);

    // 로그아웃: 세션 무효화
    public void logout(HttpSession session);

    // 회원가입: 새 회원 등록
    public void join(MemberVO newMember);

    // 아이디 중복 체크: 존재하면 1 이상, 사용 가능하면 0 반환
    public int idCheck(String id);

    // 우편번호 검색: dong(동) 기준 주소 목록 반환
    public ArrayList<AddressVO> findZipNum(String dong);


}
