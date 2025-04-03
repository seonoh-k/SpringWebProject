package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.AddressVO;
import org.nonage.mapper.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Log4j
public class AddressServiceImpl implements AddressService {
    private AddressMapper addressMapper;

    @Override
    public ArrayList<AddressVO> findZipNum(String dong) {
        return addressMapper.findByDong(dong);
    }
}
