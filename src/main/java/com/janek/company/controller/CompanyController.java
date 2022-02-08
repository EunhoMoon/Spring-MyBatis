package com.janek.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janek.company.mapper.CompanyMapper;
import com.janek.company.model.Company;
import com.janek.company.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("")
	public Company post(@RequestBody Company company) {
		companyMapper.insert(company);
		return company;
	}
	
	@PostMapping("/test")
	public Company test(@RequestBody Company company) {
		companyService.add(company);
		return company;
	}
	
	@GetMapping("")
	public List<Company> getAll() {
		return companyMapper.getAll();
	}
	
	@GetMapping("/{id}")
	public Company getById(@PathVariable("id") int id) {
		return companyMapper.getById(id);
	}
	
}
