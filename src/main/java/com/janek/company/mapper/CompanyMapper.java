package com.janek.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.janek.company.model.Company;

@Mapper
public interface CompanyMapper {
	
	@Insert("INSERT INTO company(company_name, company_address) VALUES (#{company.name}, #{company.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("company") Company company);
	
	@Select("SELECT * FROM company")
	@Results(id = "CompanyMap", value = {
		@Result(property = "id", column = "id"),
		@Result(property = "name", column = "company_name"),
		@Result(property = "address", column = "company_address"),
		@Result(property = "employeeList", column = "id", many = @Many(select="com.janek.company.mapper.EmployeeMapper.getByCompanyId"))
	})
	List<Company> getAll();
	
	@Select("SELECT * FROM company WHERE id=#{id}")
	@ResultMap("CompanyMap")
	Company getById(@Param("id") int id);
	
}
