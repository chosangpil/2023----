package com.gg.compList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CompListController {
	@Autowired
	CompListService service;

	@GetMapping("/comp-list")
	public List<CompListDTO> SelectAllFromComp() {
		System.out.println("-----------------------------");
		System.out.println("   Comp List Controller..");
		System.out.println("-----------------------------");
		List<CompListDTO> a = service.compList();
		System.out.println("company no   :" + a.get(0).CO_NO);
		System.out.println("company name :" + a.get(0).COMPANY);
		return service.compList();
	}

	@GetMapping("/comp-number")
	public int SelectCompNo(String co_id) {
		return service.compNo(co_id);
	}
}
