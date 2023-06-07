package com.atguigu.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class jdbcTemplateTest {

    @Autowired
    //没有创建类但是，这里能Autowired
    /**
     * 是因为beans.xml已经注入了bean到IoC容器中，jdbcTemplate 它的类型是JdbcTemplate
     * 用注解到IoC容器中去取就可以了
     *  <!--创建jdbcTemplate,注入数据源-->
     *     <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
     *         <!--外部bean-->
     *         <property name="dataSource" ref="druidDataSource"></property>
     *     </bean>
     */
    private JdbcTemplate jdbcTemplate;


    /**
     * 添加，修改，删除都是update
     */
    @Test
    public void testAdd(){
//        1.编写sql
        //id,姓名，年龄，性别
        String sql = "insert into t_emp values(null,?,?,?)";//因为用的是预编译，所有用?代替参数
//        2.调用方法，传入参数 参数要按照顺序插入
        //返回的值是影响行数
//        int update = jdbcTemplate.update(sql, "张阿森纳", 12, "男");
        Object[] args = {"令狐冲", 12, "男"};
        Object[] args2 = {"岳不群", 133, "男"};
        Object[] args3 = {"林平之", 31, "女"};
        int update = jdbcTemplate.update(sql,args);
        jdbcTemplate.update(sql,args2);
        jdbcTemplate.update(sql,args3);
        System.out.println(update);
    }

    @Test
    public void testUpdate(){
        String sql = "update t_emp set name=? where id=?";//因为用的是预编译，所有用?代替参数
        int rows = jdbcTemplate.update(sql,"宁中则",6);
        System.out.println(rows);
    }

    @Test
    public void testDelete(){
        String sql = "delete from t_emp where id=?";//因为用的是预编译，所有用?代替参数
        int rows = jdbcTemplate.update(sql,6);
        System.out.println(rows);
    }

    //查询返回对象，集合，单个值
    @Test
    public void testSelectObejct(){
        String sql = "select * from t_emp where id=?";//因为用的是预编译，所有用?代替参数

        /**
         * 法1 自己实现mapRow这个接口
         */
        //T mapRow(ResultSet rs, int rowNum) throws SQLException;
        //直接用java8的特性（函数数编程？？） 自己实现这个接口
        //把构造参数(ResultSet rs, int rowNum)放入，返回结果emp
//        Emp empRs = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
//            Emp emp = new Emp();
//            emp.setId(rs.getInt("id"));
//            emp.setName(rs.getString("name"));
//            emp.setAge(rs.getInt("age"));
//            emp.setSex(rs.getString("sex"));
//            return emp;
//        }, 7);
        /**
         * 直接用RowMapper的实现类，BeanPropertyRowMapper传入结果的class类型。
         * 就会自动帮我们实现上面那一大段set
         */
        Emp empRs = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 6);
        System.out.println(empRs);
    }



    @Test
    public void testSelectList(){
        String sql = "select * from t_emp";//因为用的是预编译，所有用?代替参数
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    @Test
    public void testSelectSingleValue(){
        String sql = "select name from t_emp where id = ?";
        //也是forObject但是 第二个参数是返回值的类型
        String s = jdbcTemplate.queryForObject(sql, String.class, 5);
        System.out.println(s);
    }
}
