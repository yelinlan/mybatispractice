package com.yll.mapper;

import com.yll.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

	@Select("select * from teacher where id =#{id}")
	List<Teacher> getById(int id);

	List<Teacher> getTeacherList();

}
