package com.yll.pojo;

import lombok.Data;

/**
 *@项目名称: mybatispractice
 *@类名称: Student
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/17 23:07
 **/
@Data
public class Student {
	private int id;
	private String name;
	private Teacher teacher;

}