package com.OEMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	// 마이페이지 메인
	@GetMapping(value = "/mypage/mypageMain.do")
	public String mainControll() {
		return "mypage/mypageMain";
	}
}
