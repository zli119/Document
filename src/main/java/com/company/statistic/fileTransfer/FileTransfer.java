package com.company.statistic.fileTransfer;

import java.io.*;

public class FileTransfer {
    public static void format(File srcFile, String desPathStr, int i) {
        File[] files = srcFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                format(file, desPathStr, i);
            } else {
                String fileName = file.getName();
                String path = file.getAbsolutePath();
                //System.out.println(path + "   " + fileName + "  " + i);
                String cls = path.substring(i + 1, path.length() - fileName.length() - 1);
                try {
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"));
                    FileWriter fw = new FileWriter(desPathStr, true);
                    fw.write(cls + "\t" + fileName + "\t");    // a\b   c.txt  content \n
                    while (in.ready()) {
                        String line = in.readLine().replaceAll("\n", "");
                        fw.append(line + " ");
                    }
                    in.close();
                    fw.write("\n");
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


