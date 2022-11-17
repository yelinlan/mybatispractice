package com.yll.mapper;

import com.yll.pojo.User;
import com.yll.utils.Page;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

	List<User> getById(int id);
	List<User> list();
	int add(User user);
	int update(User user);
	int delById(int id);
	List<User> getNamelike(String name);
	//不建议使用，复杂sql不易维护且混乱
	@Select("select * from user limit #{startIndex},#{pageSize}")
	List<User> page(Page page);


}
