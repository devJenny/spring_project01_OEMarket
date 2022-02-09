package com.OEMarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.encryption.UserSha256;
import com.OEMarket.service.MemberLoginService;
import com.OEMarket.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AccountController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberLoginService memberLoginService;

	UserSha256 userSha256 = new UserSha256();

	// 회원가입
	@GetMapping(value = "/account/join.do")
	public String AccountJoinForm() {
		return "account/join";
	}

	// 회원가입처리
	@PostMapping(value = "/account/join.do")
	public String JoinAction(MemberDTO memberDTO) {

		System.out.println("회원가입 화면에서 입력한 이메일 : " + memberDTO.getEmail());
		System.out.println("회원가입 화면에서 입력한 비밀번호 : " + memberDTO.getPassword());
		// 비밀번호 암호화
		String encryPassword = userSha256.encrypt(memberDTO.getPassword());
		memberDTO.setPassword(encryPassword);

		System.out.println("sha-256으로 암호화되어 나온 비밀번호 : " + memberDTO.getPassword());
		memberService.registerMember(memberDTO);
		return "redirect:/";
	}

	// 로그인
	@GetMapping(value = "/account/login.do")
	public String AccountLoginForm(@ModelAttribute MemberDTO memberDTO) {
		return "account/login";
	}

	// 로그인 처리
	@PostMapping(value = "/account/login.do")
	public String loginCheck(MemberDTO memberDTO, HttpServletRequest req) {
		HttpSession session = req.getSession();

		// 로그인 화면에서 입력받은 비밀번호 암호화해서 DB와 확인
		System.out.println("로그인 화면에서 입력한 비밀번호 : " + memberDTO.getPassword());

		String encryPassword = userSha256.encrypt(memberDTO.getPassword());
		memberDTO.setPassword(encryPassword);

		System.out.println("sha-256으로 암호화되어 나온 비밀번호 : " + memberDTO.getPassword());
		MemberDTO login = memberLoginService.loginCheck(memberDTO);

		if (login == null) {
			session.setAttribute("loginMember", null);
		} else {
			session.setAttribute("loginMember", login);
		}
		System.out.println("세션아이디 " + session.getAttribute("loginMember"));
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/account/emailCheck.do", method = RequestMethod.POST)
	public int emailCheck(String email) {
		int result = memberService.emailCheck(email);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/account/nickCheck.do", method = RequestMethod.POST)
	public int nickCheck(String nickname) {
		int result = memberService.nickCheck(nickname);
		return result;
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 비밀번호 찾기
	@GetMapping(value = "/account/find_pw.do")
	public String AccountFindPw() {
		return "account/find_pw";
	}

	// 아이디 찾기
	@GetMapping(value = "/account/find_id.do")
	public String AccountFindId() {
		return "account/find_id";
	}

	// 비밀번호 찾기 결과
	@GetMapping(value = "/account/find_pw_result.do")
	public String AccountFindPwResult() {
		return "account/find_pw_result";
	}

}
