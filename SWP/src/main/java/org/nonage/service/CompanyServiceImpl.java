package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.CompanyVO;
import org.nonage.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j
public class CompanyServiceImpl implements CompanyService{

    @Setter(onMethod_ = @Autowired)
    CompanyMapper mapper;

    @Override
    public CompanyVO getCompany(String id) {

        log.info("service get : " + mapper.getCompany(id));

        return mapper.getCompany(id);
    }

    @Override
    public CompanyVO getNonage() {

        log.info("getNonage work");

        return mapper.getNonage();
    }

    @Override
    public int cCheck(String id) {

        log.info("service get id : " + id);

        return mapper.cCheck(id);
    }

    @Override
    public List<CompanyVO> invoiceList() {

        log.info("invoiceList work");

        return mapper.invoiceList();
    }
}
