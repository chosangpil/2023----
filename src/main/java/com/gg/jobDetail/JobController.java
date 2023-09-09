package com.gg.jobDetail;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class JobController {
    @Autowired
    JobService service;

    @PostMapping("/checkdetail")
    boolean JobDetail(@RequestBody JobDTO dto, HttpServletRequest request) {
        System.out.println(" input uc: " + dto.getPOST_NO());
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

    @GetMapping("/jobdetail")
    public JobDTO getDetail(int post_NO) {
        JobDTO dto = service.getJobDetail(post_NO);
        System.out.println("***Detail Controller..***");
        System.out.println("   Detail.num   : " + dto.getPOST_NO());
        System.out.println("post_detail : " + dto.getJOB());
        /*
         * String target = dto.JOB;
         * String regEX = "[\n]";
         * Pattern pat = Pattern.compile(regEX);
         * String result = target.replaceAll(regEX,
         * "<br>");
         * dto.JOB = result;
         */
        return dto;
    }

}