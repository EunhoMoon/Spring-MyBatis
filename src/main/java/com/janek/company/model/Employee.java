package com.janek.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private int id;
	private int companyId;
	private String name;
	private String address;
}
