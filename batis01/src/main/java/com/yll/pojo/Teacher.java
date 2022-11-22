package com.yll.pojo;

import lombok.Data;

import java.util.List;

/**
 *@项目名称: mybatispractice
 *@类名称: Teacher
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/17 23:06
 **/
@Data
public class Teacher {
	private int id;
	private String name;
	private List<Student> studentList;
}