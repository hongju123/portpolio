package com.portpolio.controller.ocoController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portpolio.domain.dto.ocoDto.BusinessDTO;
import com.portpolio.domain.dto.ocoDto.KakaoUserDTO;
import com.portpolio.domain.dto.ocoDto.UserDTO;
import com.portpolio.service.ocoService.BusinessService;
import com.portpolio.service.ocoService.EmailService;
import com.portpolio.service.ocoService.KakaoLoginService;
import com.portpolio.service.ocoService.KakaoService;
import com.portpolio.service.ocoService.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user/*")
public class OcoUserController {
	@Autowired
	UserService user;
	@Autowired
	BusinessService buser;

	@Autowired
	EmailService emailservice;
	@Autowired
	KakaoService kakaoUser;

	@GetMapping("")
	public String Test() {
		return "ocoProject/userDirectory/login_Page.html";
	}

	@GetMapping("login-kakao")
	public String login(String code, HttpServletRequest req) {
		KakaoUserDTO kakaoUserDto = new KakaoLoginService().login(code);

		if (kakaoUser.findKakao(kakaoUserDto.getKakaoIdx())) {
			req.getSession().setAttribute("loginUser", kakaoUserDto.getKakaoName());
			req.getSession().setAttribute("businessUser", "X");
			req.getSession().setAttribute("socialUser", "kakao");
			return "redirect:/ocoProject/index";
		} else if (kakaoUser.insert(kakaoUserDto)) {
			req.getSession().setAttribute("loginUser", kakaoUserDto.getKakaoName());
			req.getSession().setAttribute("socialUser", "kakao");
			req.getSession().setAttribute("businessUser", "X");
			return "redirect:/ocoProject/index";
		} else {
			return "ocoProject/userDirectory/login_Page";
		}
	}

	@GetMapping("join")
	public String joinPage() {
		return "ocoProject/userDirectory/join_Page";
	}

	@PostMapping("join")
	public String join(UserDTO userDto, HttpServletRequest req, HttpServletResponse res) {
		System.out.println(userDto);

		if (user.join(userDto)) {
			System.out.println(userDto.getUserId());
			Cookie cookie = new Cookie("userId", userDto.getUserId());
			cookie.setMaxAge(1);
			res.addCookie(cookie);
			return "userDirectory/login_Page";
		} else {
			Cookie cookie = new Cookie("joinStatus", "fals");
			cookie.setMaxAge(1);
			res.addCookie(cookie);
			return "ocoProject/userDirectory/join_business_Page";
		}
	}

	@GetMapping("join_business_Page")
	public String joinBusinessPage() {
		return "ocoProject/userDirectory/join_business_Page.html";
	}

	@PostMapping("join_business")
	public String joinBusiness(@ModelAttribute BusinessDTO businessDto, HttpServletResponse res) {
		log.info("{}", businessDto);
		businessDto.setBusinessCategory(businessDto.getBusinessCategory().replace(",", "/"));
		log.info("현재 비지니스 카테고리:" + businessDto.getBusinessCategory());
		if (buser.insert(businessDto)) {
			System.out.println(businessDto.getBusinessId());
			Cookie cookie = new Cookie("userId", businessDto.getBusinessId());
			cookie.setMaxAge(1);
			res.addCookie(cookie);
			return "ocoProject/userDirectory/login_Page";
		} else {
			Cookie cookie = new Cookie("joinStatus", "fals");
			cookie.setMaxAge(1);
			res.addCookie(cookie);
			return "ocoProject/userDirectory/join_business_Page";
		}
	}

	@ResponseBody // ajax 아이디 중복확인
	@GetMapping("findbyid")
	public boolean findById(String userid) {
		return user.findById(userid);
	}

	@PostMapping("login")
	public String login() {
		return "ocoProject/userDirectory/login_Page";
	}

	@PostMapping("checklogin") // id 비밀번호 확인
	public String checklogin(String userId, String userPassword, HttpServletRequest req, HttpServletResponse res) {
		UserDTO loginUser = user.login(userId, userPassword);
		if (loginUser != null) {
			// user가 있는 것을 확인 했으니 여기서 business user에 아이디 값이 있는지 확인
			if (buser.findById(loginUser.getUserId())) {
				req.getSession().setAttribute("loginUser", loginUser.getUserId());
				req.getSession().setAttribute("businessUser", "O");
				return "redirect:/ocoProject/index";
			} else {
				req.getSession().setAttribute("loginUser", loginUser.getUserId());
				req.getSession().setAttribute("businessUser", "X");
				return "redirect:/ocoProject/index";
			}
		} else {
			Cookie cookie = new Cookie("login", "fail");
			cookie.setMaxAge(1);
			res.addCookie(cookie);
			System.out.println(cookie.getValue());
			return "ocoProject/userDirectory/login_Page";
		}
	}

	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		log.info("........................");
		req.getSession().invalidate();
		return "redirect:/ocoProject/index";
	}

	@GetMapping("finduser_Page")
	public String findpw_page() {
		return "ocoProject/userDirectory/finduser_Page";
	}

	// 유저 아이디를 이메일로 찾기
	@PostMapping("onlyFindUserID")
	public String onlyFindUserID(HttpServletResponse res, @ModelAttribute UserDTO userDto) {
		UserDTO findUser = user.findByEmail(userDto.getUserEmail());
		if (findUser != null) {
			Cookie cookie = new Cookie("userid", findUser.getUserId());
			Cookie alert = new Cookie("onlyFindUserID", findUser.getUserId());
			cookie.setMaxAge(1);
			alert.setMaxAge(1);
			res.addCookie(cookie);
			res.addCookie(alert);
			return "ocoProject/userDirectory/login_Page";
		} else {
			Cookie cookie = new Cookie("info", "false");
			cookie.setMaxAge(1);
			res.addCookie(cookie);
			return "ocoProject/userDirectory/finduser_Page";
		}
	}

	// 이메일과, 아이디로 있는 계정찾기
	@PostMapping("checkUserInfo")
	public String checkUserInfo(@ModelAttribute UserDTO userDto, HttpServletResponse res) {
		System.out.println(userDto);
		userDto = user.findByUserInfo(userDto);
		if (userDto != null) {
			// 유저 이메일에 비밀번호 보내야함
			emailservice.sendUserpassword(userDto);
			Cookie cookie = new Cookie("userId", userDto.getUserId());
			Cookie cookie1 = new Cookie("userpw", "true");
			cookie.setMaxAge(1);
			cookie1.setMaxAge(1);
			res.addCookie(cookie);
			res.addCookie(cookie1);
			return "ocoProject/userDirectory/login_Page";
		} else {
			// else시 없는 것이기때문에 홈페이지 이동하지 않고 다시 제자리
			return "ocoProject/user/finduser_Page";
		}
	}

	// 회원탈퇴 로직
	@GetMapping("withdraw")
	public String withdrow(HttpServletRequest req) {
		log.info("{}", req.getSession().getAttribute("loginUser"));
		String userId = (String) req.getSession().getAttribute("loginUser");

		if (req.getSession().getAttribute("businessUser") != "O") {
			user.withdrawBusinessUser(userId);
		} else {
			user.withdrawUser(userId);

		}
		return "redirect:/user/logout";
	}

}
