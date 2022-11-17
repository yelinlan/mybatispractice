package com.yll.proxy.service.impl;

import com.yll.proxy.service.Animal;

/**
 *@项目名称: mybatispractice
 *@类名称: Cat
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/15 21:47
 **/
public class Cat implements Animal {

	@Override
	public void eat() {
		System.out.println(" 正在吃鱼食，喵~");
	}

}