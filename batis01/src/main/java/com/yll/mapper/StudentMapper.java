package com.yll.mapper;

import com.yll.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

	List<Student> getStudentList();


}
