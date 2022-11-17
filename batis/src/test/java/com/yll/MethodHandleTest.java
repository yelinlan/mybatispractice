package com.yll;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
	static class classA {
		public void println(String s) {
			System.out.println("classA-->" + s);
		}
	}

	public static void main(String[] args) throws Throwable{
		// 随机选定一个接收者
		// 无论obj最终是那个实现类，都能正确调用到println方法
		Object obj=System.currentTimeMillis()%2==0 ? System.out : new classA();
		method(obj).invokeExact("test");
	}

	private static MethodHandle method(Object reciever) throws Throwable {
		// MethodType 代表“方法类型”，包含类方法的返回值methodType()的第一个参数
		// 和具体参数methodType()第二个及以后de参数。
		MethodType methodType = MethodType.methodType(void.class,String.class);
		// lookup()方法来自于MethodHandles.lookup()，这句的作用十izai指定类中
		// 查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
		// 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐士的，
		// 代表该方法的接收者，即this指向的对象，这个参数以前是放在参数列表中进行
		// 传递，现在提供类bindTo()方法来完成这件事。
		return MethodHandles.lookup().findVirtual(reciever.getClass(),"println",methodType).bindTo(reciever);
	}
}
