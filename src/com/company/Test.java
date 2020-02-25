package com.company;

import com.company.statistic.DataProcess;

public class Test {
    public static void main(String[] args) {
        DataProcess reader = new DataProcess();
        String pdfPath = "test.pdf";
        String pdfContent = reader.readPDF(pdfPath);
        //reader.voidWordsBuilder();
    }
}
