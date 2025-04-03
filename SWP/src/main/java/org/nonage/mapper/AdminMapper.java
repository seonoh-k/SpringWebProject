package org.nonage.mapper;

import org.apache.ibatis.annotations.Param;
import org.nonage.domain.AdminVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nonage.domain.AdminVO;


public interface AdminMapper {
    public AdminVO loginAdmin(@Param("id") String id, @Param("pwd") String pwd);

}
