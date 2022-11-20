package com.yll.mapper;

import com.yll.pojo.Student;
import com.yll.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest extends TestCase {
	private static Logger log = Logger.getLogger(TeacherMapperTest.class);

	/**
	 * <ul>
	 * <li>方法名： testGetStudentList </li>
	 * <li>功能描述：多对一  </li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/18 20:37   </li>
	 * </ul>
	 */
	@Test
	public void testGetStudentList() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> teacherList = mapper.getStudentList();
		System.out.println(teacherList);
		sqlSession.close();
	}

}