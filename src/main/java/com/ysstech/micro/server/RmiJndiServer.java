package com.ysstech.micro.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;
import com.ysstech.micro.model.DataRemote;
import com.ysstech.micro.model.impl.DataRemoteImpl;

/**
 * RMI服务的实现
 * */
@WebListener
public class RmiJndiServer implements ServletContextListener {
	
	private static Logger log = Logger.getLogger(RmiJndiServer.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			//注册RMI服务器端口
			LocateRegistry.createRegistry(1111);
			//建立RMI服务端接口实现对象
			DataRemote server = new DataRemoteImpl();
			//设置JNDI属性
			Properties properties = new Properties();
			//RMI的JNDI工厂类
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"com.sun.jndi.rmi.registry.RegistryContextFactory");
			//RMI服务端的访问地址
			properties
					.setProperty(Context.PROVIDER_URL, "rmi://localhost:1111");
			//根据JNDI属性，创建上下文
			InitialContext ctx = new InitialContext(properties);
			//将服务端接口实现对象与JNDI命名绑定，这个地方写的并不是很规范
            //如果在J2EE开发中，规范的写法是，绑定的名字要以java:comp/env/开头
			ctx.bind("dataSource", server);
			ctx.close();
			log.info("RMI与JNDI集成服务启动，等待客户端调用...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}
}
