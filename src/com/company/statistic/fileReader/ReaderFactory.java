package com.company.statistic.fileReader;

public class ReaderFactory {
    public static MyReader getReader(String filePath) {
        if (filePath.endsWith(".txt")) return new TextReader();
        if (filePath.endsWith(".pdf")) return new PDFReader();
        if (filePath.endsWith(".doc") || filePath.endsWith("docx")) return new DocReader();
        //if (filePath.endsWith(".csv")) return new CSVReader();
        return new TextReader();
    }
}
