package com.company.statistic;

import java.io.*;
import java.util.*;


public class Reader {
    private static Set<String> voidWords;
    // Builder void words set
    public static void voidWordsBuilder() throws FileNotFoundException, IOException {
        voidWords = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("voidWords.txt"));
        String s ="";
        while((s=br.readLine())!=null){
            String[] line=s.split("\\s+");
            if (line != null && line.length > 0) voidWords.add(line[0]);
        }
        br.close();
    }

    // build words number map, then ranking words
    public static void countWords() throws FileNotFoundException, IOException{
        HashMap <String, Integer> wordCounter;
        BufferedReader br=new BufferedReader(new FileReader(".txt"));
        String s="";
        wordCounter = new HashMap<>();
        while((s=br.readLine())!=null){
            String[] line=s.split("\\s+");
            for (String word : line) {
                if (!voidWords.contains(word)) {
                    wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
                }
            }
        }
        br.close();
    }
    public static void main(String[] args) throws IOException{
        String input="";
        voidWordsBuilder();
        System.out.println(voidWords.size());
    }

}