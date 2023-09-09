package com.gg.DeletePost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class DeleteController {
    @Autowired
    DeleteService service;

    @PostMapping("/delete")
    public void DeletePos(@RequestBody DeleteDTO dto) {
        System.out.println("***Delete Controller..***");
        System.out.println("   del.posNO   : " + dto.getPOST_NO());
        service.DeletePos(dto);
    }
}