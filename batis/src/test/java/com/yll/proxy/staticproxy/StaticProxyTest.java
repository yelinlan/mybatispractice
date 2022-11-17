package com.yll.proxy.staticproxy;

import com.yll.proxy.service.Person;
import com.yll.proxy.service.impl.Renter;
import com.yll.proxy.staticproxy.RenterProxy;

public class StaticProxyTest {

	public static void main(String[] args) {
		System.out.println("*静态代理*");
		Person renter = new Renter();
		RenterProxy proxy = new RenterProxy(renter);
		proxy.rentHouse();
	}

}
