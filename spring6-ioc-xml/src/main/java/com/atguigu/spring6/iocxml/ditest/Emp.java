package com.atguigu.spring6.iocxml.ditest;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class Emp {

    private Dept dept;
    private String ename;
    private Integer age;
    private String[] hobbies;

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void work(){
        System.out.println(ename + "正在工作......" + "年龄是" + age);
        dept.info();
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                '}';
    }
}
