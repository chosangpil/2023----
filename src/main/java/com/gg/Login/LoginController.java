package com.gg.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	LoginService service;

	// 로그인
	@PostMapping("/login")
	public boolean Login(@RequestBody LoginDTO dto,
			HttpServletRequest request) {

		System.out.println("***Login Controller..***");
		System.out.println(" input ID: " + dto.getID());
		System.out.println(" input PW: " + dto.getPW());
		System.out.println(" input uc: " + dto.getUser_code());

		LoginDTO loginUser = service.checkLogin(dto);

		if (loginUser == null) { // 로그인 실패한 경우
			System.out.println(" login failed...");
			return false;
		} else { // 로그인 성공한 경우
			System.out.println(" login success! getting session...");
			HttpSession session = request.getSession(); // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
			session.setAttribute("loginUser", loginUser.getID()); // 세션에 로그인 회원 정보 보관
			session.setAttribute("usercode", loginUser.getUser_code());
			System.out.println(" complete login!!:" + session.getAttribute("loginUser"));
			return true;
		}
	}

	// 로그아웃
	@PostMapping("/logout")
	public void logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate(); // 세션 날림
		}
	}

	// 로그인 세션 검사
	@PostMapping("/check-session")
	public String checkSession(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			return session.getAttribute("loginUser").toString();
		}
		return null;
	}

	// 로그인 유저코드 검사
	@PostMapping("/check-usercode")
	public int isUser(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			// System.out.println(session.getAttribute("usercode").toString());
			if (session.getAttribute("usercode").toString().equals("1")) {// comp
				return 1;
			} else if (session.getAttribute("usercode").toString().equals("2")) {// manager
				return 2;
			} else if (session.getAttribute("usercode").toString().equals("0")) {// indv
				return 0;
			}

		}
		return -1;
	}
}