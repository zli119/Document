/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ui;

import java.io.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class Reader {
    private static HashMap <String,String> dict;
   public static void DictBuilder() throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader("voidWords.txt"));
        String s="";
        dict=new HashMap<>();
        while((s=br.readLine())!=null){
            String[] line=s.split("\\s+");
//            System.out.println(line[0]);
            
            if(line.length>1){
            dict.put(line[0], line[1]);
//            System.out.println(line[1]);
            }
            else{
                dict.put(line[0],null);
            }
        }
        br.close();
    }
    public static void main(String[] args) throws IOException{
        String input="";
        DictBuilder();
        for(int i=0;i<1000;i++){
        System.out.println("please input a word");
//        BufferedReader br=new BufferedReader(System.in);
        Scanner s=new Scanner(System.in);
        if(s.hasNext()){
            input=s.next();
        }
        if(dict.containsKey(input)){
            System.out.println("Found it="+dict.get(input));
        }
                else{
               System.out.println("Not Found it"); 
                }
        }
        
//        for(String x:dict.keySet()){
//            if(input.equals(dict.keySet())){
//                System.out.println(dict.keySet());
//                bl=true;
//            }
//        }
//        if(bl)
//        System.out.println("Found it");

    }
    
}
