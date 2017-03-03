#共享连接池服务
**此服务由RMI远程调用C3P0连接池，兼容jdk1.6**


**客户端使用方法：**
	1. 首先创建远程接口，参考src/main/java/com/ysstech/micro/model/DataRemote.java(包名最好一样)
	2. 客户端代码：
```java
	Properties properties = new Properties();
	properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, 	"com.sun.jndi.rmi.registry.RegistryContextFactory");
	properties.setProperty(Context.PROVIDER_URL, "rmi://localhost:1111");
	if (System.getSecurityManager() == null) {
		System.setSecurityManager(new RMISecurityManager());
	}
	InitialContext ctx = new InitialContext(properties);
	DataRemote remote = (DataRemote)ctx.lookup("dataSource");
	//获取OracleDataSource
	DataSource ds = remote.getOracleDataSource();
	//获取DB2DataSource
	DataSource ds = remote.getDB2DataSource();
	//获取SqlServerDataSource
	DataSource ds = remote.getSqlserverDataSource();
```