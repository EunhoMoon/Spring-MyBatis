package com.janek.company.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
	private int id;
	private String name;
	private String address;
	private List<Employee> employeeList;
}
