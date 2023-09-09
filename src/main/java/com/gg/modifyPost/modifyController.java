package com.gg.modifyPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class modifyController {
    @Autowired
    modifyService service;

    @PostMapping("/modify-position")
    public void ModifyPos(@RequestBody modifyDTO dto) {
        System.out.println("***mod Controller..***");
        System.out.println("   mod.posNO   : " + dto.getPOST_NO());
        System.out.println("   mod.posNO   : " + dto.getPOSITION());
        service.modifyPos(dto);
    }
}