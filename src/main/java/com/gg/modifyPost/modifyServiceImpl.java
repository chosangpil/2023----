package com.gg.modifyPost;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class modifyServiceImpl implements modifyService {
    @Autowired
    modifyDAO dao;

    @Autowired
    SqlSessionTemplate session;

    @Override
    public void modifyPos(modifyDTO dto) {
        System.out.println("===========================");
        System.out.println("    Pos ServiceImpl..");
        System.out.println("===========================");
        dao.modifyPos(dto, session);
    }
}
