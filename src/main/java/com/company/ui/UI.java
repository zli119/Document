/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ui;
import com.company.statistic.LoadFiles;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class UI extends JFrame{
        private FileReader fileReader;
        private BufferedReader bufferedReader;
        private FileWriter fileWriter;
        private BufferedWriter bufferedWriter;
    public UI(){
        super("Document Classify");
        setSize(400,500);
        setLocation(500,100);
        Container c=getContentPane();
        c.setBackground(Color.BLUE);
        JMenu file=new JMenu("File");
        JMenuItem aNew=new JMenuItem("New");
        JMenuItem openFolder=new JMenuItem("Open Folder");
        JMenuItem openFile=new JMenuItem("Open File");
        JMenuItem quit=new JMenuItem("Quit");
        file.add(aNew);
        file.add(openFile);
        file.add(openFolder);
        file.add(quit);
        JMenu excuse=new JMenu("Excuse");
        JMenuItem classifyFile=new JMenuItem("Classify File");
        JMenuItem run=new JMenuItem("Run");
        excuse.add(classifyFile);
        excuse.add(run);
        JMenuBar mb=new JMenuBar();
        mb.add(file);
        mb.add(excuse);
        c.add(mb,BorderLayout.NORTH);
        JTextArea ta=new JTextArea();
        c.add(ta,BorderLayout.CENTER);
        setVisible(true);
        aNew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ta.setText("");
            }
        });

        openFolder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser=new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(chooser.showOpenDialog(chooser)==JFileChooser.APPROVE_OPTION){
                    System.out.println(chooser.getSelectedFile());
                    String folderPath = chooser.getSelectedFile().toString();
                    LoadFiles.loadAllFiles(folderPath);
                }
                System.out.println(LoadFiles.filePaths.size());
            }
        });
        openFile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser fc=new JFileChooser();
                fc.showOpenDialog(fc);
                try {
                    BufferedReader br=new BufferedReader(new FileReader(fc.getSelectedFile().getAbsolutePath()));
                    String getAll="";
                    while((br.readLine())!=null){
                    getAll+=br.readLine()+"\r\n";
                }
                    ta.setText(getAll);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
		}
        });
         quit.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 int exitChoose=JOptionPane.showConfirmDialog(ta,"Are you sure to close?","Close Tip",JOptionPane.OK_CANCEL_OPTION);
			if(exitChoose==JOptionPane.OK_OPTION)
			{	System.exit(0);
			}
			else
			{	return;
			}
             }
         });
         classifyFile.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                Runtime r=Runtime.getRuntime();
                 try {
                     Process p=r.exec("test.java");                     
                 } catch (IOException ex) {
                     Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         });
         run.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 Runtime r=Runtime.getRuntime();
                 try {
                     Process p=r.exec("javac test.java");                     
                 } catch (IOException ex) {
                     Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         });        
            File f=new File("test.java");
            long t=f.lastModified();       
    }
    public static void main(String[] args){
        new UI();
        System.out.println(LoadFiles.filePaths.size());
        System.out.println(LoadFiles.filePaths.size());
    }
}
