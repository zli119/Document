//package com.company.statistic.FileReader;
//
//import java.io.*;
//
//public class CSVReader {
//    public static void readWriteCSV(String fileName) {
//
//        try {
//            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
//            BufferedReader br = new BufferedReader(new FileReader(fileName));
//            String lineDta = "";
//
//            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
//            while ((lineDta = br.readLine()) != null) {
//                System.out.println(lineDta);
//            }
//
//            br.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("没有找到指定文件");
//        } catch (IOException e) {
//            System.out.println("文件读写出错");
//        }
//
//        File writeFile = new File("write.csv");
//
//        try {
//            //第二步：通过BufferedReader类创建一个使用默认大小输出缓冲区的缓冲字符输出流
//            BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));
//
//            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
//            for (int i = 1; i <= 10; i++) {
//                bw.newLine();    //换行
//                //调用write的方法将字符串写到流中
//                bw.write("new user" + i + ",male," + (18 + i));
//            }
//
//            //使用缓冲区的刷新方法将数据刷到目的地中
//            bw.flush();
//            //关闭缓冲区，缓冲区没有调用系统底层资源，真正调用底层资源的是FileWriter对象，缓冲区仅仅是一个提高效率的作用
//            //因此，此处的close()方法关闭的是被缓存的流对象
//            bw.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("没有找到指定文件");
//        } catch (IOException e) {
//            System.out.println("文件读写出错");
//        }
//    }
//}
