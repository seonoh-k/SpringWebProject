package org.nonage.service;

import org.nonage.domain.AdminVO;

public interface AdminService {
    public AdminVO login(String id, String pwd);
}
