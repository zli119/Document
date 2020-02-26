//package com.company.statistic.FileReader;
//
//import com.company.statistic.DataProcess;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
//public class TextReader implements MyReader {
//
//    public HashMap<String, Integer> countWords() throws FileNotFoundException, IOException {
//        HashMap<String, Integer> wordCounter;
//        Set<String> voidWords = DataProcess.voidWordsBuilder();
//        BufferedReader br = new BufferedReader(new FileReader(".txt"));
//        String s = "";
//        wordCounter = new HashMap<>();
//        while ((s = br.readLine()) != null) {
//            String[] line = s.split("\\s+");
//            for (String word : line) {
//                if (!voidWords.contains(word)) {
//                    wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
//                }
//            }
//        }
//        br.close();
//        return wordCounter;
//    }
//}
