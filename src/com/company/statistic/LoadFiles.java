package com.company.statistic;

import java.io.File;
import java.util.ArrayList;


public class LoadFiles {
    public static ArrayList<String> filePaths = new ArrayList<String>();
    public static void main(String[] args)throws Exception{
//        loadAllFiles("data/");
//        System.out.println(filePaths.size());
    }
    public static void loadAllFiles(String filepath) {
        File file= new File(filepath);
        if(!file.isDirectory()){
            filePaths.add(file.getName());
        }else if(file.isDirectory()){
            System.out.println("文件");
            String[] filelist=file.list();
            for(int i = 0;i<filelist.length;i++){
                File readfile = new File(filepath);
                if (!readfile.isDirectory()) {
                    filePaths.add(readfile.getName());
                } else if (readfile.isDirectory()) {
                    loadAllFiles(filepath + "\\" + filelist[i]);//递归
                }
            }
        }
        for(int i = 0; i< filePaths.size(); i++){
            System.out.println(filePaths.get(i));
        }
    }
}
