package com.itheima.config;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;

//@Configuration
public class DBConfiguration {
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                tomcat.enableNaming();//启用默认禁用的JNDI命名
                return super.getTomcatWebServer(tomcat);
            }
            @Override
            protected void postProcessContext(Context context) {
                //数据源 1
                //构建一个ContextResource对象，然后添加到Context对象中
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/MyFirstMySql");
                resource.setType(DataSource.class.getName());
//                resource.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
                resource.setProperty("driverClassName", "org.h2.Driver");
//                resource.setProperty("url", "jdbc:mysql://192.168.50.154:3306/testdb_jndi?serverTimezone=GMT%2B8");
                resource.setProperty("url", "jdbc:h2:~/test");
//                resource.setProperty("username", "root");
                resource.setProperty("username", "sa");
//                resource.setProperty("password","123321");
                resource.setProperty("password","123456");
                context.getNamingResources().addResource(resource);

                //数据源 2
                //构建一个ContextResource对象，然后添加到Context对象中
//                ContextResource resource1 = new ContextResource();
//                resource1.setName("jdbc/MySecondMySql");
//                resource1.setType(DataSource.class.getName());
//                resource1.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
//                resource1.setProperty("url", "jdbc:mysql://127.0.0.1:3306/osbpm?serverTimezone=GMT%2B8");
//                resource1.setProperty("username", "root");
//                resource1.setProperty("password","123456");
//                context.getNamingResources().addResource(resource1);

//                super.postProcessContext(context);
            }
        };
        return tomcat;
    }

//    @Bean
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:comp/env/jdbc/MyFirstMySql");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource)bean.getObject();
    }
}
