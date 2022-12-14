package com.yll.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *@项目名称: mybatispractice
 *@类名称: s
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/13 21:59
 **/
public class MybatisUtils {
	private static SqlSessionFactory factory = null;
	static {
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		//手动提交
		//return factory.openSession();
		//自动提交
		return factory.openSession(true);
	}
}