package com.yll.utils;

import lombok.Builder;
import lombok.Data;

/**
 *@项目名称: mybatispractice
 *@类名称: Page
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/15 19:55
 **/
@Data
@Builder
public class Page {

	private int startIndex;
	private int pageSize;

}