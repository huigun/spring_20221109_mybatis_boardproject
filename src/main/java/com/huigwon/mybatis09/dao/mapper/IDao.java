package com.huigwon.mybatis09.dao.mapper;

import com.huigwon.mybatis09.dto.MemberDto;

public interface IDao {
	
	// member 관련 메소드
	public void joinMemberDao(String mid, String mpw, String mname, String memail); // 회원가입
	public int checkIdDao(String mid); // 회원 가입 여부 확인
	public int checkPwDao(String mid, String pw); // 아이디와 비밀번호 일치여부 체크
	public MemberDto memberInfoDao(String mid); // 가입된 회원정보를 불러옴
	
	// board 관련 메소드
	public void writeDao(String mid, String mname, String ftitle, String fcontent); // 게시판에 글쓰기
}