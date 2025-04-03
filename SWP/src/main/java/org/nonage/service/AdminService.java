package org.nonage.service;

import org.nonage.domain.AdminVO;

public interface AdminService {
    AdminVO confirmAuth(String id, String pwd);
    AdminVO getAdminById(String id);
}