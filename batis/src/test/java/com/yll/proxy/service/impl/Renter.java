package com.yll.proxy.service.impl;

import com.yll.proxy.service.Person;

public class Renter implements Person {

	@Override
	public void rentHouse() {
		System.out.println("租客租房成功！");
	}

}
