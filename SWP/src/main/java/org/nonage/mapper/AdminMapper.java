package org.nonage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nonage.domain.AdminVO;

@Mapper
public interface AdminMapper {
    AdminVO confirmAuth(@Param("id") String id, @Param("pwd") String pwd);
    AdminVO getAdminById(@Param("id") String id);
}