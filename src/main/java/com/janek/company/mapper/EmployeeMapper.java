package com.janek.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.janek.company.model.Employee;


@Mapper
public interface EmployeeMapper {
	
	@Insert("INSERT INTO employee(company_id, employee_name, employee_address) VALUES (#{employee.companyId}, #{employee.name}, #{employee.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("employee") Employee employee);
	
	@Select("SELECT * FROM employee")
	@Results(id = "EmployeeMap", value = {
		@Result(property = "companyId", column = "company_id"),
		@Result(property = "name", column = "employee_name"),
		@Result(property = "address", column = "employee_address")
	})
	List<Employee> getAll();
	
	@Select("SELECT * FROM employee WHERE id=#{id}")
	@ResultMap("EmployeeMap")
	Employee getById(@Param("id") int id);
	
	@Select("Select * FROM employee WHERE company_id=#{companyId}")
	@ResultMap("EmployeeMap")
	List<Employee> getByCompanyId(@Param("companyId") int companyId);
	
}
