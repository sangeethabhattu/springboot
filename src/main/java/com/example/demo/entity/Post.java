package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.tuple.ValueGenerator;




@Entity
@Table(name="employee")
public class Post {
	
	
	
	
	@Id
	
	@Column(name="empid",nullable = false)
	
	int empid;
	
	@NotBlank(message="please provide a empname")
	@Column(name="empname",nullable = false)
	String empname;
	
	@Min(value=30,message="enter the correct min age")
	@Max(value=60,message = "enter the correct max age")
	
	@Positive(message="this field is mandatory, AGE")
    @Digits(fraction = 0, integer = 10, message ="add a correct age as a number")
	@Column(name="age",nullable = false)
	
	int age;
	 
	@NotBlank(message="please provide a employee profession")
	@Column(name="employeeprofession",nullable = false)
	
	String employeeprofession;
    public Post() {}
	public Post(String empname, int age, String employeeprofession,int empId)
	{
        this.empid = empId;
		this.empname = empname;
		this.age = age;
		this.employeeprofession = employeeprofession;
	}

	

	

	
	public int getEmpId() {
		return empid;
	}
	public void setEmpId(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmployeeprofession() {
		return employeeprofession;
	}
	public void setEmployeeprofession(String employeeprofession) {
		this.employeeprofession = employeeprofession;
	}
	@Override
	public String toString() {
		return "Post [empname=" + empname + ", age=" + age + ", empId=" + empid + "]";
	}
	
	
	
}

