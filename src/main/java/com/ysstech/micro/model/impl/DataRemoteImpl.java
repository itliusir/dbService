package com.ysstech.micro.model.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ysstech.micro.model.DataRemote;
import com.ysstech.micro.model.JDBCBase;
import com.ysstech.micro.util.ReadXMLUtil;

/**
 * RMI服务端接口的实现
 * */
@Component
public class DataRemoteImpl extends UnicastRemoteObject implements DataRemote{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/*private static ConcurrentHashMap<String, DataSource> map = new ConcurrentHashMap<String, DataSource>();
	
	//oracle dataSource
	@Value("${oracle.datasource.driverClassName}")
	private String oracleDriver;
	
	@Value("${oracle.datasource.url}")
	private String oracleUrl;
	
	@Value("${oracle.datasource.username}")
	private String oracleUserName;
	
	@Value("${oracle.datasource.password}")
	private String oraclePassword;
	
	@Value("${oracle.datasource.max-idle}")
	private String oracleMaxIdle;
	
	@Value("${oracle.datasource.min-idle}")
	private String oracleMinIdle;
	
	@Value("${oracle.datasource.initial-size}")
	private String oracleInitSize;
	
	
	//sqlServer dataSource
	@Value("${SqlServer.datasource.driverClassName}")
	private String sqlDriver;
	
	@Value("${SqlServer.datasource.url}")
	private String sqlUrl;
	
	@Value("${SqlServer.datasource.username}")
	private String sqlUserName;
	
	@Value("${SqlServer.datasource.password}")
	private String sqlPassword;
	
	@Value("${SqlServer.datasource.max-idle}")
	private String sqlMaxIdle;
	
	@Value("${SqlServer.datasource.min-idle}")
	private String sqlMinIdle;
	
	@Value("${SqlServer.datasource.initial-size}")
	private String sqlInitSize;
	
	//db2 dataSource
	@Value("${db2.datasource.driverClassName}")
	private String db2Driver;
	
	@Value("${db2.datasource.url}")
	private String db2Url;
	
	@Value("${db2.datasource.username}")
	private String db2UserName;
	
	@Value("${db2.datasource.password}")
	private String db2Password;
	
	@Value("${db2.datasource.max-idle}")
	private String db2MaxIdle;
	
	@Value("${db2.datasource.min-idle}")
	private String db2MinIdle;
	
	@Value("${db2.datasource.initial-size}")
	private String db2InitSize;*/

	public DataRemoteImpl() throws RemoteException {
		super();
	}

	
	/*@PostConstruct
	public void setDataSourceMap() {
		ComboPooledDataSource oraCpds = new ComboPooledDataSource();
		ComboPooledDataSource sqlCpds = new ComboPooledDataSource();
		ComboPooledDataSource db2Cpds = new ComboPooledDataSource();
		try {
			//oracle dataSource
			oraCpds.setDriverClass(oracleDriver);
			oraCpds.setJdbcUrl(oracleUrl);
			oraCpds.setUser(oracleUserName);
			oraCpds.setPassword(oraclePassword);
			oraCpds.setInitialPoolSize(Integer.parseInt(oracleInitSize));
			oraCpds.setMaxPoolSize(Integer.parseInt(oracleMaxIdle));
			oraCpds.setMinPoolSize(Integer.parseInt(oracleMinIdle));
			//sqlServer dataSource
			sqlCpds.setDriverClass(sqlDriver);
			sqlCpds.setJdbcUrl(sqlUrl);
			sqlCpds.setUser(sqlUserName);
			sqlCpds.setPassword(sqlPassword);
			sqlCpds.setInitialPoolSize(Integer.parseInt(sqlInitSize));
			sqlCpds.setMaxPoolSize(Integer.parseInt(sqlMaxIdle));
			sqlCpds.setMinPoolSize(Integer.parseInt(sqlMinIdle));
			//db2 dataSource
			db2Cpds.setDriverClass(db2Driver);
			db2Cpds.setJdbcUrl(db2Url);
			db2Cpds.setUser(db2UserName);
			db2Cpds.setPassword(db2Password);
			db2Cpds.setInitialPoolSize(Integer.parseInt(db2InitSize));
			db2Cpds.setMaxPoolSize(Integer.parseInt(db2MaxIdle));
			db2Cpds.setMinPoolSize(Integer.parseInt(db2MinIdle));
			map.put("oracleDataSource", (DataSource)oraCpds);
			map.put("sqlServerDataSource", (DataSource)sqlCpds);
			map.put("db2DataSource", (DataSource)db2Cpds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	/*public ConcurrentHashMap<String, DataSource> getDataSourceMap() {
		return map;
	}*/
	
	@Override
	public DataSource getOracleDataSource(String dataSourceName) throws Exception {
		ComboPooledDataSource oraCpds = new ComboPooledDataSource();
		JDBCBase jb = new JDBCBase();
		jb = ReadXMLUtil.read("oracle", dataSourceName);
		System.out.println(jb.toString());
		oraCpds.setDriverClass(jb.getDriverClassName());
		oraCpds.setJdbcUrl(jb.getUrl());
		oraCpds.setUser(jb.getUsername());
		oraCpds.setPassword(jb.getPassword());
		oraCpds.setInitialPoolSize(Integer.parseInt(jb.getInitialSize()));
		oraCpds.setMaxPoolSize(Integer.parseInt(jb.getMaxIdle()));
		oraCpds.setMinPoolSize(Integer.parseInt(jb.getMinIdle()));
		return oraCpds;
	}
	
	@Override
	public DataSource getSqlserverDataSource(String dataSourceName) throws Exception {
		ComboPooledDataSource sqlCpds = new ComboPooledDataSource();
		JDBCBase jb = new JDBCBase();
		jb = ReadXMLUtil.read("sqlServer", dataSourceName);
		sqlCpds.setDriverClass(jb.getDriverClassName());
		sqlCpds.setJdbcUrl(jb.getUrl());
		sqlCpds.setUser(jb.getUsername());
		sqlCpds.setPassword(jb.getPassword());
		sqlCpds.setInitialPoolSize(Integer.parseInt(jb.getInitialSize()));
		sqlCpds.setMaxPoolSize(Integer.parseInt(jb.getMaxIdle()));
		sqlCpds.setMinPoolSize(Integer.parseInt(jb.getMinIdle()));
		return sqlCpds;
	}

	@Override
	public DataSource getDB2DataSource(String dataSourceName) throws Exception {
		ComboPooledDataSource db2Cpds = new ComboPooledDataSource();
		JDBCBase jb = new JDBCBase();
		jb = ReadXMLUtil.read("db2", dataSourceName);
		db2Cpds.setDriverClass(jb.getDriverClassName());
		db2Cpds.setJdbcUrl(jb.getUrl());
		db2Cpds.setUser(jb.getUsername());
		db2Cpds.setPassword(jb.getPassword());
		db2Cpds.setInitialPoolSize(Integer.parseInt(jb.getInitialSize()));
		db2Cpds.setMaxPoolSize(Integer.parseInt(jb.getMaxIdle()));
		db2Cpds.setMinPoolSize(Integer.parseInt(jb.getMinIdle()));
		return db2Cpds;
	}
}
