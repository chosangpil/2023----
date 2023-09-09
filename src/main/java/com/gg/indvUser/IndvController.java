package com.gg.indvUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class IndvController {
	@Autowired
	IndvService service;

	@PostMapping("/success-join-indv")
	public void InsertIndvUser(@RequestBody IndvDTO dto) {
		System.out.println("***Indv Controller..***");
		System.out.println("   indv.name   : " + dto.getNAME());
		System.out.println("   indv.id     : " + dto.getP_ID());
		System.out.println("   indv.pw     : " + dto.getP_PW());
		System.out.println("   indv.email  : " + dto.getP_EMAIL());
		System.out.println("   indv.contact: " + dto.getPHONE());
		System.out.println("   indv.BOD    : " + dto.getBIRTH_DATE());
		System.out.println("   indv.gender     : " + dto.getGENDER());
		service.insertIndv(dto);
	}

	@GetMapping("/mypage-indv")
	public IndvDTO getIndvUser(String userID) {
		IndvDTO dto = service.getIndv(userID);
		System.out.println("***Indv Controller..***");
		System.out.println("   indv.name   : " + dto.getNAME());
		return dto;
	}

}
