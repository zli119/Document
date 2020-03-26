package com.company.statistic.fileReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.*;
import java.util.*;

public class PDFReader extends AbstactReader {

    public HashMap<String, Integer> countWords(String filePath) {
        HashMap<String, Integer> wordCounter = new HashMap<>();;
        Set<String> voidWords = super.getVoidWords();
        try {
            PDDocument document = null;
            document = PDDocument.load(new File(filePath));
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper Tstripper = new PDFTextStripper();
                String str = Tstripper.getText(document);
                String[] line = str.split("\\s+");
                for (String word : line) {
                    if (!voidWords.contains(word)) {
                        wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordCounter;
    }
}
