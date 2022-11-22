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

	/**
	 * <ul>
	 * <li>方法名： testGetById </li>
	 * <li>功能描述：注解写sql  </li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/18 20:39   </li>
	 * </ul>
	 */
	@Test
	public void testGetById() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teacherList = mapper.getById(1);
		System.out.println(teacherList);
		sqlSession.close();
	}

	/**
	 * <ul>
	 * <li>方法名： testGetTeacherList </li>
	 * <li>功能描述：一对多  </li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/18 20:38   </li>
	 * </ul>
	 */
	@Test
	public void testGetTeacherList() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teacherList = mapper.getTeacherList();
		System.out.println(teacherList);
		sqlSession.close();
	}
}