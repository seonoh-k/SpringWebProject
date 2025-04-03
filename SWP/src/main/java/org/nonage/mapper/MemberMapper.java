package org.nonage.mapper;

import org.apache.ibatis.annotations.Param;
import org.nonage.domain.AddressVO;
import org.nonage.domain.MemberVO;

import java.util.ArrayList;

public interface MemberMapper {
    // 로그인: id와 pwd가 일치하는 회원 조회
    public MemberVO login(@Param("id") String id, @Param("pwd") String pwd);

    // 회원가입 : 새 회원 정보를 등록
    public void join(MemberVO member);

    // 아이디 중복 체크 : 해당 id를 가진 회원 수 조회 (0이면 사용가능)
    public int idCheck(String id);

    // 우편번호 검색 : dong(동)을 기준으로 zipcode 테이블에서 우편번호와 주소 조회
    ArrayList<AddressVO> findZipNum(String dong);

}
