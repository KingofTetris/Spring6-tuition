package com.atguigu.spring6.iocxml.dimap;

import java.util.List;
import java.util.Map;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class Student {

    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    private Map<String,Teacher> teacherMap;

    private String sid;
    private String sname;
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public void run(){
        System.out.println("学术编号" + sid + ",学上名词" + sname);
        System.out.println(teacherMap);
    }

    @Override
    public String toString() {
        return "Student{" +
                "lessonList=" + lessonList +
                ", teacherMap=" + teacherMap +
                ", sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
