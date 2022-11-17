package com.yll.mapper;

import com.yll.pojo.User;
import com.yll.utils.MybatisUtils;
import com.yll.utils.Page;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserMapperTest extends TestCase {
	private static Logger log = Logger.getLogger(UserMapperTest.class);
	@Test
	public void testPage() {
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			Page page = new Page();
			page.setStartIndex(0);
			page.setPageSize(3);
			List<User> userList = mapper.page(page);
			System.out.println(userList);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testGetNameLike() {
		 log.info("进入testGetNameLike方法");
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = mapper.getNamelike("a");
			System.out.println(userList);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		log.info("退出testGetNameLike方法");
	}
	@Test
	public void testList() {
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = mapper.list();
			System.out.println(userList);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}

	@Test
	public void testGetById() {
		//建议使用
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = mapper.getById(1);
			System.out.println(userList);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//不建议使用
		//SqlSession sqlSession = MybatisUtils.getSqlSession();
		//List<User> userList = sqlSession.selectList("com.yll.mapper.UserMapper.getUserList",1);
		//System.out.println(userList);
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
			System.out.println(a);
			sqlSession.commit();  //增删改要手动提交
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
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
			user.setId(1);
			user.setName("yll");
			user.setPwd("yll");
			int a = mapper.update(user);
			System.out.println(a);
			sqlSession.commit();  //增删改要手动提交
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
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
			System.out.println(a);
			sqlSession.commit();  //增删改要手动提交
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
}