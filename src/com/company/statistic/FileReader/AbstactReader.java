package com.company.statistic.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public abstract class AbstactReader implements MyReader{
    private static Set<String> voidWords;
    private static List<Set<String>> setList;
    // Builder void words set
    public static Set<String> voidWordsBuilder() throws FileNotFoundException, IOException {
        if (voidWords != null) return voidWords;
        voidWords = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("voidWords.txt"));
        String s = "";
        while ((s = br.readLine()) != null) {
            String[] line = s.split("\\s+");
            if (line != null && line.length > 0) voidWords.add(line[0]);
        }
        br.close();
        return voidWords;
    }
    public abstract HashMap<String, Integer> countWords(String filePath);
}
