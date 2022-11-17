package com.yll.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * @TableName user
 */
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 学号
	 */
	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String pwd;

}