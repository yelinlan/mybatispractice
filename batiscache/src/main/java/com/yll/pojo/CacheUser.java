package com.yll.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *@项目名称: mybatispractice
 *@类名称: CacheUser
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/20 21:10
 **/
@Data
@Builder
public class CacheUser implements Serializable {
	private int id;
	private String name;
	private String pwd;
}