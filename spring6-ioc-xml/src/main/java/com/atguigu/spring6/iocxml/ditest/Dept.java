package com.atguigu.spring6.iocxml.ditest;

import java.util.List;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class Dept {

    private String dname;
    private List<Emp> emps;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public void info(){
        System.out.println("部门名称" + dname);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                ", emps=" + emps +
                '}';
    }
}
