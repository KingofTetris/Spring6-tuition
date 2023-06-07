package com.atguigu.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
//手写IoC 用Bean取代@Component,@Repository,@Service,@Controller
@Target({ElementType.TYPE}) //TYPE就是类
@Retention(RetentionPolicy.RUNTIME)//运行时生效
public @interface Bean {
}
