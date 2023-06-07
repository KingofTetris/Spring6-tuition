package com.atguigu.bean;

import com.atguigu.anno.Bean;
import com.atguigu.anno.DI;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */


/**
 * #TODO 模仿Spring 手写IoC DI。
 * 常看常新
 */
public class AnnotationApplicationContext implements ApplicationContext {

    //Spring把实力对象放入一个map集合中，我们也这样做
    private Map<Class, Object> beanFactory = new HashMap<>();

    //取绝对路径中的不变路径rootPath
    private String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);//直接根据类型，返回对象
    }

    //创建有参勾走，传递包的路径，设置包的扫描规则
    //如果类上面有@Bean，把这个类进行反射构造实例对象。
    public AnnotationApplicationContext(String basePackage){
//    public static void pathDemo1(String basePackage) {
        //com.atguigu.xx.xx.....
        //先找到绝对路径
        try {
            //1.替换.为\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
            //因为.在正则里面表示任意字符，所以要转义一下。
            //TODO 另外Java比较NT的一点是 正则表达式中一个斜杠要用 \\\\ 来表示
            //2.获得绝对路径 获得盘符
            Enumeration<URL> urls = Thread.currentThread().
                    getContextClassLoader().
                    getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
//                System.out.println(url);
                //url里面会因为编码问题把\变成%5 要多一步decode转回来
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
//                System.out.println(filePath);//   /D:/atguiguProject/atguigu-spring/target/classes/com\atguigu

                //获取包前面不变的rootPath /D:/atguiguProject/atguigu-spring/target/classes/
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());//截取
//                System.out.println(rootPath);
                //包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //属性注入
        loadDi();
    }


    private void loadBean(File file) throws Exception {
        //1 判断当前是否为文件夹，如果是文件就不用再扫描了
        if (file.isDirectory()) {
            //2 获取文件夹中的所有内容
            File[] childrenFiles = file.listFiles();//取得所有文件
            //3 判断文件夹为空，直接返回
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;//没有东西
            }

            //4 如果不为空，遍历文件夹所有内容
            for (File child : childrenFiles) {
                //4.1 遍历得到每个File对象，继续判断，如果还是文件夹，继续递归
                if (child.isDirectory()) loadBean(child);
                    //4.2如果得到的File对象是文件不是文件夹，是文件
                else {
                    //4.3 得到包路径+类名称部分 -- 字符串截取  com\atguigu\service\UserServiceImpl.class
                    String pathWithClass =
                            //把完整路径中的前面不变部分给去掉，也就是从rootPath.length-1开始往后取
                            //-1是因为从0开始
                            child.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4 虽然得到了是文件，但是不知道是哪种文件，判断当前文件类型是否是.class
                    if (pathWithClass.contains(".class")){ //如果包含.class后缀名就是字节码文件
                        //4.5 如果是.class类型，把路径\替换成. 把.class去掉
                        //com.atguigu.service.UserServiceImpl 全类名
                        String allName = pathWithClass.replaceAll("\\\\", "\\.").replaceAll("\\.class", "");
                        //4.6.1
                        //获得类的Class
                        //因为不知道是什么类，得再Class后面加上泛型
                        Class<?> clazz = Class.forName(allName);
                        //4.6.2 判断Class不是接口,是接口就没必要继续了。接口不能实例化
                        if (!clazz.isInterface()){
                            //4.6.3 判断类上面是不是有注解@Bena
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null){
                                //4.6.4 实例化
                                Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
                                declaredConstructor.setAccessible(true);
                                Object instance = declaredConstructor.newInstance();//实例化
                                //4.7 最后把实例化对象放入BeanFactory中。
                                //4.7.1 判断当前类如果有接口，让第一个接口class作为map的key
                                if (clazz.getInterfaces().length > 0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else {
                                    //没有就直接把class当作Key
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }

                    }

                }

            }

        }
    }

    //属性注入
    private void loadDi() {
        //1 实例化对象都是在beanFactory集合中
        //因此先遍历这个集合
        for (Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
            //2 获取map集合每个对象，
            Object obj = entry.getValue();
            //3 遍历得到每个对象的属性数组，得到每个属性
            Class<?> clazz = obj.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();

            for (Field field : declaredFields) {
                //4 判断属性上是否有@DI注解
                DI annotation = field.getAnnotation(DI.class);
                //5 如果有，把对象进行注入
                if (annotation != null){
                    //如果是私有属性还得设置一下
                    field.setAccessible(true);
                    //注入
                    try {
                        //向obj对象中注入field。
                        //field.getType获取类型
                        //再通过beanFactory获得对象
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
