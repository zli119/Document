package com.utpe.dataProcess.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class TextReader extends AbstactReader {

    public HashMap<String, Integer> countWords(String filePath) {
        HashMap<String, Integer> wordCounter = new HashMap<>();;
        Set<String> voidWords = super.getVoidWords();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String str = "";
            while ((str = br.readLine()) != null) {
                String[] line = str.split("\\s+");
                for (String word : line) {
                    if (!voidWords.contains(word)) {
                        wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
                    }
                }
            }
            br.close();
        }
        catch (Exception e) {}
        return wordCounter;
    }
}
