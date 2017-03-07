package com.ysstech.micro.model;

/**
 * 定义dbSource属性
 * @author 0.0
 * */
public class JDBCBase {
	
	private String driverClassName = null;
	private String url = null;
	private String username = null;
	private String initialSize = null;
	private String maxIdle = null;
	private String minIdle = null;
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}
	public String getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}
	public String getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password = null;
	@Override
	public String toString() {
		return "JDBCBase [driverClassName=" + driverClassName + ", url=" + url
				+ ", username=" + username + ", initialSize=" + initialSize
				+ ", maxIdle=" + maxIdle + ", minIdle=" + minIdle
				+ ", password=" + password + "]";
	}
	
	
}
