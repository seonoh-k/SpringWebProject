package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.AdminVO;
import org.nonage.mapper.AdminMapper;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
@Log4j
public class AdminServiceImpl implements AdminService{


    private AdminMapper adminMapper;

    @Override
    public AdminVO login(String id, String pwd) {

        return adminMapper.loginAdmin(id, pwd);
    }

}
