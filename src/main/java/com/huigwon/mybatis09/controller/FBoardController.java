package com.huigwon.mybatis09.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huigwon.mybatis09.dao.mapper.IDao;
import com.huigwon.mybatis09.dto.MemberDto;

@Controller
public class FBoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="joinMember")
	public String joinMember() {
		return "joinMember";
	}
	
	@RequestMapping(value="joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
				
		int checkIdFlag = dao.checkIdDao(mid);
				
		if(checkIdFlag  == 0) {
			
		dao.joinMemberDao(mid, mpw, mname, memail);
		model.addAttribute("mname", mname);
		model.addAttribute("checkIdFlag", checkIdFlag);
		}
		
		return "joinOk";
	}
	
		@RequestMapping(value = "checkId")
		public String checkId(HttpServletRequest request, Model model) {
			IDao dao = sqlSession.getMapper(IDao.class);
			String mid = request.getParameter("checkId");
			int checkIdFlag = dao.checkIdDao(mid);
			model.addAttribute("checkIdFlag", checkIdFlag);
			return "checkId";
		
	}	
		@RequestMapping(value="login")
		public String login() {
			return "login";
			
		}
		
		@RequestMapping(value="loginOk", method = RequestMethod.POST)
		public String loginOk(HttpServletRequest request, Model model) {
			IDao dao = sqlSession.getMapper(IDao.class);
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			
			int checkIdFlag = dao.checkIdDao(mid);
			int checkPwFlag = dao.checkPwDao(mid, mpw);
			
			model.addAttribute("checkIdFlag", checkIdFlag);
			model.addAttribute("checkPwFlag", checkPwFlag);
			model.addAttribute("mid", mid);
			
			if(checkPwFlag == 1) { //로그인 성공시 세션에 아이디와 로그인 유효값을 설정
				
				HttpSession session = request.getSession();
				
				session.setAttribute("sessionId", mid);
				session.setAttribute("ValidMen", "yes");
				
				MemberDto dto = dao.memberInfoDao(mid);
				String mname = dto.getMname();
				model.addAttribute("mname",mname);
			} else {
				model.addAttribute("mname","guest");
			}
			
			return "loginOk";
		}
		
		@RequestMapping(value = "writeForm")
		public String writeForm(HttpServletRequest request, Model model) {
			
			IDao dao = sqlSession.getMapper(IDao.class);
					
			HttpSession session = request.getSession();
			String sid = (String) session.getAttribute("sessionId");
			
			if(sid == null) {
				return "redirect:login";
			} else {
			
			MemberDto dto = dao.memberInfoDao(sid);
			String mid = dto.getMid();
			String mname = dto.getMname();
			model.addAttribute("mname",mname);
			model.addAttribute("mid",mid);
			
			return "writeForm";
			}
		}
		@RequestMapping(value="write")
		public String write(HttpServletRequest request) {
			IDao dao = sqlSession.getMapper(IDao.class);
			HttpSession session = request.getSession();
			String sid = (String) session.getAttribute("sessionId");
			
//			String mname="";
//			String mid="";
//			
//			if(sid.equals(null)) {
//			
//				mname="손님";
//				mid="guest";
//			} else {
//				
			MemberDto dto = dao.memberInfoDao(sid);
			String mid = dto.getMid();
			String mname = dto.getMname();
//			}
			String ftitle = request.getParameter("ftitle");
			String fcontent = request.getParameter("fcontent");
			dao.writeDao(mid, mname, ftitle, fcontent);
			return "redirect:list";
		}
		
		@RequestMapping(value="logOut")
		public String logOut(HttpServletRequest request) {
		
			HttpSession session = request.getSession();
			session.invalidate(); // 로그아웃(세션삭제)
			System.out.println(session.getId());
			return "logOut";
		}
}
