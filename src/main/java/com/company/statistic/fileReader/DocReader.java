package com.company.statistic.fileReader;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.ooxml.extractor.ExtractorFactory;

public class DocReader extends AbstactReader {
    public HashMap<String, Integer> countWords(String filePath) {
        HashMap<String, Integer> wordCounter = new HashMap<>();;
        Set<String> voidWords = super.getVoidWords();
        try {
            File file = new File(filePath);
            POITextExtractor extractor = ExtractorFactory.createExtractor(file);
            String str = extractor.getText();
            String[] line = str.split("\\s+");
            for (String word : line) {
                if (!voidWords.contains(word)) {
                    wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return wordCounter;
    }
}

