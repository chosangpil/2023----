package com.gg.careerInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CareerController {
	@Autowired
	CareerService service;

	@PostMapping("/success-join-ci")
	public void InsertCareerInfo(@RequestBody List<CareerDTO> listDTO) {
		System.out.println("***Career Controller..***");
		System.out.println("   career.id      : " + listDTO.get(0).P_ID);
		System.out.println("   career.company : " + listDTO.get(0).P_COMPANY);
		System.out.println("   career.dept    : " + listDTO.get(0).P_DEPARTMENT);
		System.out.println("   career.duty    : " + listDTO.get(0).P_DUTY);

		for (int i = 0; i < listDTO.size(); i++)
			service.insertCareer(listDTO.get(i));
	}

	@GetMapping("/mypage-indv-ci")
	public List<CareerDTO> GetCareerInfoList(String userID) {
		System.out.println("***Career Controller..***");
		return service.careerList(userID);
	}

}