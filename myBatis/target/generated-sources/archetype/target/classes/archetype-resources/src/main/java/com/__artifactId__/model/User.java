#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.${artifactId}.model;

import java.sql.Date;

public class User {
	private int id;
	private Date time;
	private String name;
	private String sqlstring;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getSqlstring() {
		return sqlstring;
	}
	public void setSqlstring(String sqlstring) {
		this.sqlstring = sqlstring;
	}
}
