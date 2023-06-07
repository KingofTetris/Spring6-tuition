package com.atguigu.spring6.tx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

/**
 * 所有其实全注解开发，也不一定就好，写起来挺麻烦的，而且不如xml规整
 */
@Configuration //标明配置类 相当于说明这是个beans.xml
@ComponentScan("com.atguigu.spring6.tx")//全注解事务
// 等于 <context:component-scan base-package="com.atguigu"></context:component-scan>
@EnableTransactionManagement
//开启事务 等于<tx:annotation-driven transaction-manager="transactionManager"/>
public class SpringConfig {
    //下面的Bean就等于 /**
    //     *  <!--xml注入-->
    //     *     <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
    //     *         <property name="username" value="${jdbc.user}"></property>
    //     *         <property name="password" value="${jdbc.password}"></property>
    //     *         <property name="url" value="${jdbc.url}"></property>
    //     *         <!--driveClassName-->
    //     *         <property name="driverClassName" value="${jdbc.driver}"></property>
    //     *     </bean>
    //     * @return
    //     */
    @Bean //这个Bean注解就相当于<bean>
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
//    <!--创建jdbcTemplate,注入数据源-->
//    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
//        <!--注入数据源 外部bean dataSource-->
//        <property name="dataSource" ref="druidDataSource"></property>
//    </bean>
//
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //    <!--事务管理器 注入数据源-->
//    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
//        <property name="dataSource" ref="druidDataSource"></property>
//    </bean>
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
