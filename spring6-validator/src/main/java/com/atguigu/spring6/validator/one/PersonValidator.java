package com.atguigu.spring6.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */
public class PersonValidator implements Validator {

    //support 是对指定的类型进行校验
    @Override
    public boolean supports(Class<?> clazz) {

        //单纯对Person进行校验
        return Person.class.equals(clazz);
    }

    //validate是具体的校验逻辑，比如不能为空，长度限制等。
    @Override
    public void validate(Object target, Errors errors) {
        //name不能为空
        //Spring自带一个校验工具类ValidationUtils
        //第一个参数固定为errors,后面跟着校验参数，错误状态码，和错误信息
        ValidationUtils.rejectIfEmpty(errors,
                "name",
                "name.empty",
                "name is null");
        //age 不能小于0，大于200
        Person p = (Person) target;//目标对象

        if (p.getAge() < 0){
            errors.rejectValue("age","age.value.error","age < 0");
        }
        else if (p.getAge() > 200){
            errors.rejectValue("age","age.value.error.old","age > 200");
        }
    }
}
