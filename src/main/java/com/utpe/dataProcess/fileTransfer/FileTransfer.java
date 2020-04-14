package com.utpe.dataProcess.fileTransfer;

import java.io.*;
import java.util.*;

public class FileTransfer {
    public static Set<String> localVisited = new HashSet<>();
    public static Set<String> totalVisited = new HashSet<>();

    public static void formatFolder(File srcFile, String desPathStr, int i) {
        File[] files = srcFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                formatFolder(file, desPathStr, i);
            } else {
                String fileName = file.getName();
                String path = file.getAbsolutePath();
                try {
                    //System.out.println(path + "   " + fileName + "  " + i);
                    String cls = path.substring(i + 1, path.length() - fileName.length() - 1);
                    String id = cls + "\t" + fileName + "\t" + file.length() + "\t";
                    if (localVisited.add(id)) {
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                        BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"));
                        FileWriter fw = new FileWriter(desPathStr, true);
                        fw.write(id);    // a\b   c.txt  content \n
                        while (in.ready()) {
                            String line = in.readLine().replaceAll("\n", "");
                            fw.append(line + " ");
                        }
                        fw.write("\n");
                        fw.flush();
                        bis.close();
                        in.close();
                        fw.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("This file has problem " + path + " " + fileName);
                }
            }
        }
    }

    public static String formatFile(File srcFile) {
        if (!srcFile.isFile()) return "";
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("class" + "\t" + srcFile.getName() + "\t" + srcFile.length());
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"));
            while (in.ready()) {
                String line = in.readLine().replaceAll("\n", "");
                sb.append(line + " ");
            }
            sb.append("\n");
            in.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

    public static void mergeDataSet(File srcFile, String desFilePath) {
        File[] files = srcFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) mergeDataSet(file, desFilePath);
            else {
                try {
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"));
                    FileWriter fw = new FileWriter(desFilePath, true);
                    while (in.ready()) {
                        String line = in.readLine();
                        String[] words = line.split("\t");
                        String id = words[0].trim() + "\t" + words[1].trim() + "\t" + words[2].trim() + "\t";
                        System.out.println(id);
                        if (!totalVisited.add(id)) continue;
                        System.out.println(id);
                        fw.append(line);
                        fw.append("\n");
                    }
                    fw.flush();
                    bis.close();
                    in.close();
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}


//                try {
//                    FileInputStream fis = new FileInputStream(file);
//                    FileOutputStream fos = new FileOutputStream(desPathStr);
//                    fos.write((loc + "\t").getBytes());
//
//
//
//                    int len = 0;
//                    byte datas[] = new byte[1024 * 8];
//                    while ((len = fis.read(datas)) != -1) {
//                        fos.write(datas, 0, len);
//                        fos.flush();
//                    }
//                    fos.write(("\n").getBytes());
//                    fis.close();
//                    fos.close();
//                }
//                catch (Exception e) {
//                }
//            }


