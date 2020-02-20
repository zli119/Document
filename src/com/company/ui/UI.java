/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ui;
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
        JMenu m1=new JMenu("File");
        JMenuItem mi1=new JMenuItem("New");
        JMenuItem mi2=new JMenuItem("Open Folder");
        JMenuItem mi3=new JMenuItem("Open File");
        JMenuItem mi4=new JMenuItem("Quit");
        m1.add(mi1);
        m1.add(mi3);
        m1.add(mi2);        
        m1.add(mi4);        
        JMenu m2=new JMenu("Excuse");
        JMenuItem mi5=new JMenuItem("Classify File");
        JMenuItem mi6=new JMenuItem("Run");
        m2.add(mi5);
        m2.add(mi6);
        JMenuBar mb=new JMenuBar();
        mb.add(m1);
        mb.add(m2);
        c.add(mb,BorderLayout.NORTH);
        JTextArea ta=new JTextArea();
        c.add(ta,BorderLayout.CENTER);
        setVisible(true);
        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ta.setText("");
            }
        });
        mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser fc=new JFileChooser();
                fc.showSaveDialog(null);
                fc.setVisible(true);
                try {                      			
                    BufferedWriter bw=new BufferedWriter(new FileWriter(fc.getSelectedFile().getAbsolutePath()));
                    bw.write(ta.getText());           
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mi3.addActionListener(new ActionListener(){        
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
         mi4.addActionListener(new ActionListener(){
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
         mi5.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                Runtime r=Runtime.getRuntime();
                 try {
                     Process p=r.exec("test.java");                     
                 } catch (IOException ex) {
                     Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         });
         mi6.addActionListener(new ActionListener(){
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
        
        
    }
    
}
