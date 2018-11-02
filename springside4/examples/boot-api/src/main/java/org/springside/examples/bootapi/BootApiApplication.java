package org.springside.examples.bootapi;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

// SpringBoot 应用标识
@SpringBootApplication
public class BootApiApplication {

	/**
	 * 启动嵌入式的Tomcat并初始化Spring环境.
	 * 
	 * 无 applicationContext.xml 和 web.xml, 靠下述方式进行配置：
	 * 
	 * 1. 扫描当前package下的class设置自动注入的Bean<br/>
	 * 2. 也支持用@Bean标注的类配置Bean <br/>
	 * 3. 根据classpath中的三方包Class及集中的application.properties条件配置三方包，如线程池 <br/>
	 * 4. 也支持用@Configuration标注的类配置三方包.
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootApiApplication.class, args);
	}

	@Autowired
	private Environment env;

	//destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
	@Bean()
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setInitialSize(2);//初始化时建立物理连接的个数
		dataSource.setMaxActive(20);//最大连接池数量
		dataSource.setMinIdle(0);//最小连接池数量
		dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
		dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
		dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
		dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
		dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
		return dataSource;
	}
}
