package com.ysstech;

import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ysstech.micro.model.DataRemote;
import com.ysstech.micro.model.impl.DataRemoteImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {
	@Test
	public void test() throws Exception{
		DataRemote server = new DataRemoteImpl();
		DataSource ds = server.getOracleDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		jdbcTemplate.update("delete from users");
		jdbcTemplate.update("insert into users(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		jdbcTemplate.update("insert into users(id,name,age) values(?, ?, ?)", 2, "bbb", 30);
		System.out.println(jdbcTemplate.queryForObject("select count(1) from users", String.class));
		Assert.assertEquals("2", jdbcTemplate.queryForObject("select count(1) from users", String.class));
	}
}
