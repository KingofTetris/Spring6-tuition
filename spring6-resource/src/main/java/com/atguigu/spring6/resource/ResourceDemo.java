package com.atguigu.spring6.resource;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * Resource的作用在于URL不能访问低级别的资源，但是它可以。它是一个接口，有很多实现类
 * 演示urlResource访问网络资源
 */
public class ResourceDemo {

    public static void main(String[] args) {
        //http开头
//        loadUrlResource("http://www.baidu.com");
        //file开头 注意path是根路径，是spring6这个父工程下才叫根路径
        //当然你可以直接写绝对路径就没那么多B事
//        loadUrlResource("file:atguigu.txt");
//        loadClassPathResource("atguigu.txt");

//        loadFileSystemResource("d:\\atguigu.txt");
        //相对路径是相对根路径
        loadFileSystemResource("atguigu.txt");
    }
    //访问前缀是http,file的资源
    public static void loadUrlResource(String path){
        //创建Resource实现类的对象UrlResource
        try {
            Resource url = new UrlResource(path);
            //获取资源信息
            System.out.println(url.getFilename());
            System.out.println(url.getURL());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //访问类加载路径中的资源
    public static void loadClassPathResource(String path){
        Resource resource = new ClassPathResource(path);//ClassPathResource可以读取类加载路径下的资源
        //类加载路径下的资源是指src下面的target文件夹下classes文件夹下的东西
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());//class path resource [atguigu.txt]

        InputStream inputStream = null;
        try {
            //通过流的方法输出文件内容
            inputStream = resource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //访问系统资源
    public static void loadFileSystemResource(String path){
        Resource resource = new FileSystemResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try {
            InputStream inputStream = resource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1){
                System.out.println(new String(b));//输出文件内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
