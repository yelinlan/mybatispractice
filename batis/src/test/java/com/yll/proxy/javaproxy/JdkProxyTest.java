package com.yll.proxy.javaproxy;

import com.yll.proxy.service.Animal;
import com.yll.proxy.service.impl.Cat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

	public static void main(String[] args) {
		System.out.println("*JDK动态代理*");
		//创建被代理的实例对象
		Animal cat = new Cat();
		Class<?>[] classes = {Animal.class};
		ClassLoader loader = Animal.class.getClassLoader();
		Animal renterProxy = getProxy(cat, classes, loader);
		renterProxy.eat();

	}

	private static <T> T getProxy(Object o, Class<?>[] classes, ClassLoader loader) {
		//创建InvocationHandler对象
		InvocationHandler renterHandler = new CustomInvocationHandler<>(o);
		//创建代理对象,代理对象的每个执行方法都会替换执行Invocation中的invoke方法
		return (T) Proxy.newProxyInstance(loader, classes, renterHandler);
	}

}
