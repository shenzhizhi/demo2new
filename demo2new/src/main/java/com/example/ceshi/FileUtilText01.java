package com.example.ceshi;

public class FileUtilText01 {
    public static void main(String[] args) {
        //因为FileUtilDemo01不是私有的，所有可以直接通过类调用类中的方法，如下：
        FileUtilDemo01.m1("\\\\pacsmscslanwon\\ImagesNet");
        //后面引号中的内容就是人为规定的指定目录，即FileUtilDemo中的入参patchname
    }
}
