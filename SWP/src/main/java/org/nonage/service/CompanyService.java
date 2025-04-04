package org.nonage.service;

import org.nonage.domain.CompanyVO;

import java.util.List;

public interface CompanyService {

    public CompanyVO getCompany(String id);

    public CompanyVO getNonage();

    public int cCheck(String id);

    public List<CompanyVO> invoiceList();
}
