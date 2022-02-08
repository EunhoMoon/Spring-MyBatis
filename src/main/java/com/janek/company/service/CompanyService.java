package com.janek.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.janek.company.mapper.CompanyMapper;
import com.janek.company.mapper.EmployeeMapper;
import com.janek.company.model.Company;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Company> getAll() {
		List<Company> companyList = companyMapper.getAll();
		
		if (companyList != null && companyList.size() > 0) {
			for (Company company : companyList) {
				company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
			}
		}
		
		return companyList;
	}
	
	@Transactional
	public Company add(Company company) {
		companyMapper.insert(company);
		// add company into legacy system
		
		if (true) {
			throw new RuntimeException("Legacy Exception");
		}
		
		return company;
	}
	
}
