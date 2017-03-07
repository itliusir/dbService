package com.ysstech.micro.model;

import java.rmi.Remote;

import javax.sql.DataSource;

/**
 * RMI服务端接口
 * */
public interface DataRemote extends Remote{
	public DataSource getOracleDataSource(String dataSourceName) throws Exception;
	
	public DataSource getSqlserverDataSource(String dataSourceName) throws Exception;
	
	public DataSource getDB2DataSource(String dataSourceName) throws Exception;

}
