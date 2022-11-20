package com.yll.mapper;

import com.yll.pojo.CacheUser;
import com.yll.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest extends TestCase {

	/**
	 * <ul>
	 * <li>方法名： testGetById </li>
	 * <li>功能描述：测试一次会话mybatis默认开启了本地（一级）缓存 作用域：单个会话 </li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/20 21:53   </li>
	 * </ul>
	 *
	 * @param
	 * @return void
	 */
	@Test
	public void testGetById() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CacheUserMapper mapper = sqlSession.getMapper(CacheUserMapper.class);
		CacheUser user1 = mapper.getById("2");
		CacheUser user2 = mapper.getById("2");
		System.out.println(user1);
		System.out.println(user2);
		//true  两次查询的一样，说明mybatis使用了缓存
		System.out.println("user1==user2："+(user1==user2));
		sqlSession.close();
	}

	/**
	 * <ul>
	 * <li>方法名： testUpdate </li>
	 * <li>功能描述：缓存失效的情况  </li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/20 22:03   </li>
	 * </ul>
	 *
	 * @param
	 * @return void
	 */
	@Test
	public void testUpdate() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CacheUserMapper mapper = sqlSession.getMapper(CacheUserMapper.class);
		CacheUser user1 = mapper.getById("2");
		//1.增删改查
		//mapper.update(CacheUser.builder().id(1).name("zs").pwd("123").build());
		//2.手动清除了缓存 其他情况：3.查询不同mapper
		//sqlSession.clearCache();
		CacheUser user2 = mapper.getById("2");
		System.out.println(user1);
		System.out.println(user2);
		//true  两次查询的一样，说明mybatis使用了缓存
		System.out.println("user1==user2："+(user1==user2));
		sqlSession.close();
	}

	/**
	 * <ul>
	 * <li>方法名： testLevel2Cache </li>
	 * <li>功能描述：测试mybatis二级缓存（作用域：namespace即同一个mapper，多个会话）  </li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/20 22:41   </li>
	 * </ul>
	 *
	 * @param
	 * @return void
	 */
	@Test
	public void testLevel2Cache() {
		//CacheUserMapper.xml中开启二级缓存<cache/>
		//所有数据在一级缓存，当会话结束，会放到二级缓存
		System.out.println("开启会话");
		System.out.println("查寻二级缓存（当前mapper）中。。。。。。。。。。");
		System.out.println("未找到结果。。。。。。。。。。");
		System.out.println("查寻一级缓存（当前sql会话）中。。。。。。。。。。");
		System.out.println("未找到结果。。。。。。。。。。");
		System.out.println("查寻数据库中中。。。。。。。。。。");
		SqlSession sqlSession1 = MybatisUtils.getSqlSession();
		CacheUserMapper mapper1 = sqlSession1.getMapper(CacheUserMapper.class);
		CacheUser user1 = mapper1.getById("2");
		System.out.println("查寻到数据。。。。。。。。。。");
		System.out.println("数据为："+user1);
		System.out.println("数据放入一级缓存（当前sql会话）中。。。。。。。。。。");
		System.out.println("当前会话没有发现其他增删改操作、其他mapper操作、清理缓存操作。。。。。。。。。。");
		System.out.println("准备关闭会话。。。。。。。。。。");
		System.out.println("转移一级缓存到二级缓存。。。。。。。。。。");
		System.out.println("关闭会话。。。。。。。。。。");
		sqlSession1.close();

		System.out.println("开启会话");
		System.out.println("查寻二级缓存（当前mapper）中。。。。。。。。。。");
		SqlSession sqlSession2 = MybatisUtils.getSqlSession();
		CacheUserMapper mapper2 = sqlSession2.getMapper(CacheUserMapper.class);
		CacheUser user2 = mapper2.getById("2");
		System.out.println("查寻到数据。。。。。。。。。。");
		System.out.println("数据为："+user1);
		System.out.println("返回数据。。。。。。。。。。");
		System.out.println("数据放入一级缓存（当前sql会话）中。。。。。。。。。。");
		System.out.println("当前会话没有发现其他增删改操作、其他mapper操作、清理缓存操作。。。。。。。。。。");
		System.out.println("准备关闭会话。。。。。。。。。。");
		System.out.println("转移一级缓存到二级缓存。。。。。。。。。。");
		System.out.println("关闭会话。。。。。。。。。。");
		sqlSession2.close();
		System.out.println(user2);

		//true  两次查询的一样，说明mybatis使用了缓存
		//这里使用<cache/>开启缓存会是false，原因readOnly:true读对象，false:读对象的拷贝。
		// 但是数据库确实只查询了一次
		System.out.println("user1==user2："+(user1==user2));
	}
}