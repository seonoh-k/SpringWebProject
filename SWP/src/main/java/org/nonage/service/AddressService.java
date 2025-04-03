package org.nonage.service;

import org.nonage.domain.AddressVO;

import java.util.ArrayList;

public interface AddressService {
    ArrayList<AddressVO> findZipNum(String dong);
}