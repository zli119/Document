package com.utpe;

import com.utpe.dataProcess.fileReader.*;

import java.util.*;

public final class Test {
    public final int a;
    public static int b;
    protected int c;
    public final void check() {

    }
    private Test() {
        a = 5;
        b = 6;
    }
    private class Test3{
        void get() {
            b = 9;
        }
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

