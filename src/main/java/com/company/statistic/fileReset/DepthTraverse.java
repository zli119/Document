package com.company.statistic.fileReset;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class DepthTraverse {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File dirFile = new File("C:\\Users\\rocky\\IdeaProjects\\DocumentClassify\\data");
        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                // TODO Auto-generated method stub
                return name.endsWith("1");
            }
        };
        List<File> list = new ArrayList<File>();
        try {
            getFile(dirFile, filter, list);//查找符合条件的文件
            WriteToFile(list);//将查找到的指定格式的文件放入指定的文件夹中
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void getFile(File dir, FilenameFilter filter, List<File> list) throws IOException {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory())//是文件夹则递归查询
                getFile(file, filter, list);
            else {
                if (filter.accept(dir, file.getName()))//是文件则将文件放入list列表中
                    list.add(file);
            }

        }
    }

    public static void WriteToFile(List<File> list) throws IOException {
        String dirString = "C:\\Users\\rocky\\IdeaProjects\\DocumentClassify\\data\\reset";//将查找到的.mobi格式文件存放于此
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int num = 0;
        byte[] bt = new byte[1024];
        try {
            for (File file : list) {
                fis = new FileInputStream(file);//读文件
                fos = new FileOutputStream(new File(dirString, file.getName()));//写文件
                System.out.println(file.getAbsolutePath());
                while ((num = fis.read(bt)) != -1) {
                    fos.write(bt, 0, num);
                    fos.flush();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            fis.close();
            fos.close();
        }
    }
}
