package org.nonage.service;

import lombok.RequiredArgsConstructor;
import org.nonage.domain.AdminVO;
import org.nonage.mapper.AdminMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    @Override
    public AdminVO confirmAuth(String id, String pwd) {
        return adminMapper.confirmAuth(id, pwd);
    }

    @Override
    public AdminVO getAdminById(String id) {
        return adminMapper.getAdminById(id);
    }
}