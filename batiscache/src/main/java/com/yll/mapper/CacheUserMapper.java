package com.yll.mapper;

import com.yll.pojo.CacheUser;
import org.apache.ibatis.annotations.Param;

/**
 *@项目名称: mybatispractice
 *@类名称: CacheUserMapper
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/20 21:11
 **/
public interface CacheUserMapper {

	CacheUser getById(@Param("id") String id);

	int update(CacheUser cacheUser);

}