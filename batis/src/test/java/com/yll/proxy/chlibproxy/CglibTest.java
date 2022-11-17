package com.yll.proxy.chlibproxy;

import com.yll.proxy.service.Person;
import com.yll.proxy.service.impl.Renter;
import com.yll.proxy.service.impl.RenterNoInterface;

/**
 *@项目名称: mybatispractice
 *@类名称: CglibTest
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/15 22:13
 **/
public class CglibTest {
	public static void main(String[] args) {

		ProxyFactory<Renter> factory = new ProxyFactory<>(new Renter());
		Person proxy = (Person) factory.getProxyInstance();
		proxy.rentHouse();

		ProxyFactory<RenterNoInterface> factory1 = new ProxyFactory<>(new RenterNoInterface());
		RenterNoInterface proxy1 = (RenterNoInterface) factory1.getProxyInstance();
		proxy1.rentHouse();

	}
}