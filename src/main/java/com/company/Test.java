package com.company;

import com.company.statistic.*;
import com.company.statistic.fileReader.*;

import java.util.*;

public class Test {
    private class Test3{

    }
    Test3 t3 = new Test3();
    public static void main(String[] args) {
        // test Reader
        String filePath = "test.pdf";
        MyReader myReader = ReaderFactory.getReader(filePath);
        HashMap hm = myReader.countWords(filePath);
        System.out.println(hm.size());


//        DataProcess reader = new DataProcess();
//        String pdfPath = "test.pdf";
//        String pdfContent = reader.readPDF(pdfPath);
        //reader.voidWordsBuilder();
    }
}
class Test2{

}

