/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utpe.ui;

import com.utpe.dataProcess.DocumentClassifier;
import com.utpe.dataProcess.fileReset.FolderInfo;
import com.utpe.dataProcess.fileReset.filesReset;
import com.utpe.dataProcess.fileTransfer.FileTransfer;
import edu.stanford.nlp.classify.ColumnDataClassifier;
import edu.stanford.nlp.ling.Datum;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Administrator
 */
public class UI extends JFrame {

    public UI() {
        super("Document Classify");
        setSize(400, 200);
        setLocation(500, 100);
        Container c = getContentPane();
        c.setBackground(Color.BLUE);
        JMenu file = new JMenu("File");
        JMenuItem resetClassifier = new JMenuItem("Reset Classifier");
        JMenuItem openTrainFolder = new JMenuItem("Open Train Folder");
        JMenuItem openTestFolder = new JMenuItem("Open Test Folder");

//        JMenuItem openFile = new JMenuItem("Open File");
        JMenuItem quit = new JMenuItem("Quit");
        file.add(resetClassifier);
//        file.add(openFile);
        file.add(openTrainFolder);
        file.add(openTestFolder);
        file.add(quit);
        JMenu run = new JMenu("Run");
        JMenuItem predictFile = new JMenuItem("Predict File");
        JMenuItem classifyFolder = new JMenuItem("Classify Folder");
//        JMenuItem wait = new JMenuItem("Run");
        run.add(predictFile);
        run.add(classifyFolder);
//        run.add(wait);
        JMenuBar mb = new JMenuBar();
        mb.add(file);
        mb.add(run);
        c.add(mb, BorderLayout.NORTH);
        JTextArea ta = new JTextArea();
        c.add(ta, BorderLayout.CENTER);
        setVisible(true);
        Font f = new Font("sans-serif", Font.PLAIN, 5);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);

        DocumentClassifier dc = DocumentClassifier.getClassifier();
        ColumnDataClassifier cdc = dc.cdc;
        FolderInfo folderInfo = FolderInfo.getFolderInfo();
        Map<String, String> filePathMap = folderInfo.filePathMap;

        resetClassifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resetChoose = JOptionPane.showConfirmDialog(ta, "Are you sure to clean the classifier?", "Reset Tip", JOptionPane.OK_CANCEL_OPTION);
                if (resetChoose == JOptionPane.OK_OPTION) {
                    if (new File("model.txt").delete()) {
                        int successTip = JOptionPane.showConfirmDialog(ta, "Reset successfully!", "Result", JOptionPane.CLOSED_OPTION);
                    } else {
                        int alreadyTip = JOptionPane.showConfirmDialog(ta, "Already reset!", "Result", JOptionPane.CLOSED_OPTION);
                    }
                } else {
                    return;
                }
            }
        });
        openTrainFolder.addActionListener(new ActionListener() { // get train data path, transfer to train data type, run training function
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                    File folder = chooser.getSelectedFile();
                    String folderPath = folder.toString();
                    Date dNow = new Date( );
                    SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd.hh:mm:ss");
                    String desPathStr = folderPath + File.separator + "StanfordTrain" + File.separator + folder.getName() + ft.format(dNow) + ".txt";


                    if (!new File(desPathStr).exists()) {
                        FileTransfer.formatFolder(folder, desPathStr, folderPath.length());
                    }
                    String trainFile = desPathStr;
                    System.out.println(trainFile);
                    try {
                        cdc.trainClassifier(trainFile);
//                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("model.txt"));
//                        cdc.serializeClassifier(os);
//                        os.close();
                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }
                }
            }
        });
        openTestFolder.addActionListener(new ActionListener() { // get train data path, transfer to train data type, run training function
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                    File folder = chooser.getSelectedFile();
                    String folderPath = folder.toString();
                    int j = folderPath.lastIndexOf("\\");
                    String desPathStr = folderPath.substring(0, j) + File.separator + "test.txt";
                    if (!new File(desPathStr).exists()) {
                        FileTransfer.formatFolder(folder, desPathStr, folderPath.length());
                    }
                    String testFile = desPathStr;
                    System.out.println(testFile);
                    try {
                        cdc.testClassifier(testFile);
//                        cdc.trainClassifier(testFile);
//                        ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("model.txt"));
//                        cdc.serializeClassifier(os);
//                        os.close();
                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }
                }
            }
        });
        classifyFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                    File folder = chooser.getSelectedFile();
                    String folderPath = folder.toString();
                    int j = folderPath.lastIndexOf("\\");
                    String desPathStr = folderPath.substring(0, j) + File.separator + "predict.txt";
                    if (!new File(desPathStr).exists()) {
                        FileTransfer.formatFolder(folder, desPathStr, folderPath.length());
                    }
                    String filePath = desPathStr;
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(filePath));
                        String str = "";
                        String getAll = "";
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("model.txt"));
                        ColumnDataClassifier t = ColumnDataClassifier.getClassifier(ois);
                        ois.close();
                        while ((str = br.readLine()) != null) {
                            Datum datum = t.makeDatumFromLine(str);
                            String[] words = str.split("\\s+");
                            String oldPath = folderPath + "\\" + words[0] + "\\" + words[1];
                            String cls = (String) t.classOf(datum);
                            String newPath = cls.toLowerCase().trim();
                            filePathMap.put(oldPath, newPath);
                            getAll += oldPath + "               " + cls + "\r\n";
                        }
                        ta.setText("Success!");
                        br.close();
                        filesReset.reset(folderPath);
                    } catch (Exception ee) {
                    }
                }
            }
        });
//        openFile.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser fc = new JFileChooser();
//                fc.showOpenDialog(fc);
//                try {
//                    BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile().getAbsolutePath()));
//                    String getAll = "";
//                    while ((br.readLine()) != null) {
//                        getAll += br.readLine() + "\r\n";
//                    }
//                    ta.setText(getAll);
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int exitChoose = JOptionPane.showConfirmDialog(ta, "Are you sure to close?", "Close Tip", JOptionPane.OK_CANCEL_OPTION);
                if (exitChoose == JOptionPane.OK_OPTION) {
                    System.exit(0);
                } else {
                    return;
                }
            }
        });
        predictFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Runtime r = Runtime.getRuntime();
//                Process p = r.exec("test.java");
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                    File file1 = chooser.getSelectedFile();
                    try {
                        String str = FileTransfer.formatFile(file1);
                        Datum datum = cdc.makeDatumFromLine(str);
                        String cls = cdc.classOf(datum);
                        ta.setText(cls);
                        System.out.println(cls);
                    } catch (Exception ex) {
                        Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Runtime r = Runtime.getRuntime();
                try {
                    Process p = r.exec("javac test.java");
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        File f = new File("test.java");
//        long t = f.lastModified();
    }


    public static void main(String[] args) {
//        new UI();
    }
}
