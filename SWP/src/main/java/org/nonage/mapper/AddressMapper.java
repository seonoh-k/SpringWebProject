package org.nonage.mapper;

import org.nonage.domain.AddressVO;

import java.util.ArrayList;

public interface AddressMapper {
    ArrayList<AddressVO> findByDong(String dong);
}
