package com.company.statistic;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.*;

public class ReadPDF {
    public static String readPDF(String path) {
        try{
            PDDocument document = null;
            document = PDDocument.load(new File(READ_PDF));
            document.getClass();
            if( !document.isEncrypted() ){
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition( true );
                PDFTextStripper Tstripper = new PDFTextStripper();
                String st = Tstripper.getText(document);
                System.out.println("Text:"+st);
                return st;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    // PDF to be read
    public static final String READ_PDF = "test.pdf";
    public static void main(String[] args) {
        readPDF(READ_PDF);
    }
}
