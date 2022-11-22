package com.yll.mapper;

import com.yll.pojo.User;
import com.yll.utils.MybatisUtils;
import com.yll.utils.Page;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
/*CRUD*/
public class UserMapperTest extends TestCase {
	private static Logger log = Logger.getLogger(UserMapperTest.class);

	@Test
	public void testPage() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.page(Page.builder().startIndex(0).pageSize(3).build());
		log.info(userList);
		sqlSession.close();
	}

	@Test
	public void testGetNameLike() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.getNamelike("a");
		log.info(userList);
		sqlSession.close();
	}

	@Test
	public void testList() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.list();
		log.info(userList);
		sqlSession.close();
	}

	@Test
	public void testGetById() {
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.getById(2);
		log.info(userList);
		sqlSession.close();
		//不建议使用
		//SqlSession sqlSession = MybatisUtils.getSqlSession();
		//List<User> userList = sqlSession.selectList("com.yll.mapper.UserMapper.getUserList",1);
		//log.info(userList);
		//sqlSession.close();
	}

	@Test
	public void testAdd() {
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setId(4);
			user.setName("yll");
			user.setPwd("yll");
			int a = mapper.add(user);
			log.info(a);
			//sqlSession.commit();  //增删改要手动提交
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testUpdate() {
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setId(2);
			user.setName("yll");
			user.setPwd("yll");
			int a = mapper.update(user);
			log.info(a);
			//sqlSession.commit();  //增删改要手动提交
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testDelById() {
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			int a = mapper.delById(1);
			log.info(a);
			//sqlSession.commit();  //增删改要手动提交
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}