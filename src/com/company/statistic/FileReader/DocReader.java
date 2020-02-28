package com.company.statistic.FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.ooxml.extractor.ExtractorFactory;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class DocReader extends AbstactReader {
    HashMap<String, Integer> map;
    public HashMap<String, Integer> countWords(String filePath) {
        map = new HashMap<>();
        try {
            File file = new File(filePath);
            POITextExtractor extractor = ExtractorFactory.createExtractor(file);
            String text = extractor.getText();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


}

