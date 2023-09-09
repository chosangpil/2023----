package com.gg.academicCareerInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AcademicController {
	@Autowired
	AcademicService service;

	@PostMapping("/success-join-aci")
	public void InsertACInfo(@RequestBody List<AcademicDTO> listDTO) {
		System.out.println("*Academic Career Controller..*");
		System.out.println("   aci.id     : " + listDTO.get(0).P_ID);
		System.out.println("   aci.degree : " + listDTO.get(0).DEGREE);
		System.out.println("   aci.school : " + listDTO.get(0).SCHOOL_NAME);
		System.out.println("   aci.major  : " + listDTO.get(0).MAJOR);

		for (int i = 0; i < listDTO.size(); i++)
			service.insertAcademic(listDTO.get(i));
	}

	@GetMapping("/mypage-indv-aci")
	public List<AcademicDTO> GetACInfoList(String userID) {
		System.out.println("*Academic Career Controller..*");
		return service.academicList(userID);
	}
}
