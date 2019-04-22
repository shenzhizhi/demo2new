package com.example.ceshi;

import java.io.File;

public class FileUtilDemo01 {
    //pathname参数表示自己制定的文件路径的
    public static void m1(String pathname) {
         int i=0;
        //先将指定路径下的所有文件实例化
        File file = new File(pathname);
        //判断实例化的对象file是否存在，即指定路径是否存在
        if (!file.exists()) {
            //若file不存在，则抛出异常
            throw new IllegalArgumentException("目录" + pathname + "不存在");
        }
        //若文件存在，则将所有文件的实例化对象转化为数组形式
        File[] files = file.listFiles();
        //遍历文件数组
        for (File file2 : files) {
            //如果从数组中拿出来的值是File是文件类型，就直接先打印这个文件的路径名称
            System.out.println(file2.getPath());
            //如果是拿出来的File是文件夹类型，就调用自己，利用递归的思想，即一层一层地打开
            if (file2.isDirectory()) {
                //调用自己时候传入的参数为上一句判断出来的文件夹路径
                m1(file2.getAbsolutePath());
            }

        }
    }

}
