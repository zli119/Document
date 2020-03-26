//package com.company.statistic;
//
//import com.company.statistic.FileReader.MyReader;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripperByArea;
//
//import java.io.*;
//import java.util.*;
//
//
//public class DataProcess {
//    private static Set<String> voidWords;
//    private static List<Set<String>> setList;
//
//    // Builder void words set
//    public static Set<String> voidWordsBuilder() throws FileNotFoundException, IOException {
//        if (voidWords != null) return voidWords;
//        voidWords = new HashSet<>();
//        BufferedReader br = new BufferedReader(new FileReader("voidWords.txt"));
//        String s = "";
//        while ((s = br.readLine()) != null) {
//            String[] line = s.split("\\s+");
//            if (line != null && line.length > 0) voidWords.add(line[0]);
//        }
//        br.close();
//
//    }
//
//    // build words number map
//
//
//    // create data set, compare the keywords set and data set, to figure out the class(use HashMap)
//    public static Set top20Keyword(HashMap<String, Integer> map) {
//        Data[] data = new Data[map.size()];
//        int i = 0;
//        for (String key : map.keySet()) {
//            data[i].word = key;
//            data[i].count = map.get(key);
//            i++;
//        }
//        Arrays.sort(data, (a, b) -> Integer.compare(b.count, a.count));
//        Set<String> set = new HashSet<>();
//        i = 0;
//        while (i < 10 && i < data.length) {
//            set.add(data[i].word);
//        }
//        return set;
//    }
//
//    // compare set
//    public Set compareSet(Set input) {
//        int maxIndex = 0;
//        int size = 0;
//        for (int i = 0; i < setList.size(); i++) {
//            Set t = new HashSet(input);
//            t.retainAll(setList.get(i));
//            if (size < t.size()) {
//                size = t.size();
//                maxIndex = i;
//            }
//        }
//        return setList.get(maxIndex);
//    }
//

//
//
//
//
//
//    public static void main(String[] args) throws IOException{
//        String input="";
//        voidWordsBuilder();
//        System.out.println(voidWords.size());
//        //readWriteCSV("write.csv");
//    }
//
//}
//class Data{
//    int count;
//    String word;
//}