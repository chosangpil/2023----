package com.gg.CompanyDetail;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ComDetailController {
    @Autowired
    ComDetailService service;

    @PostMapping("/checkcompanydetail")
    boolean JobDetail(@RequestBody ComDetailDTO dto, HttpServletRequest request) {
        System.out.println(" input uc: " + dto.getCO_ID());
        /*
         * JobDTO detail = service.getJobDetail(dto.getPOST_NO());
         * if (detail != null) {
         * HttpSession session_D = request.getSession();
         * session_D.setAttribute("post_no", detail.getPOST_NO());
         * System.out.println("success call" + session_D.getAttribute("post_NO"));
         * }
         */
        return true;
    }

    @GetMapping("/aboutcomp")
    public ComDetailDTO getComDetail(String co_ID) {
        ComDetailDTO dto = service.getComDetail(co_ID);
        System.out.println("***Compdetail Controller..***");
        System.out.println(co_ID);
        System.out.println("   comp.name   : " + dto.getCO_ID());
        return dto;
    }
}
