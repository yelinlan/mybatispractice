package com.yll.mapper;

import com.yll.pojo.Teacher;
import com.yll.pojo.User;
import com.yll.utils.MybatisUtils;
import com.yll.utils.Page;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest extends TestCase {
	private static Logger log = Logger.getLogger(TeacherMapperTest.class);

	@Test
	public void testGetById() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teacherList = mapper.getById(1);
		System.out.println(teacherList);
		sqlSession.close();
	}
	@Test
	public void testGetTeacherList() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teacherList = mapper.getTeacherList();
		System.out.println(teacherList);
		sqlSession.close();
	}
}