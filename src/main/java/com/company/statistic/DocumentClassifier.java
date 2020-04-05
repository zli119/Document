package com.company.statistic;

import com.company.statistic.fileReset.filesReset;
import com.company.ui.UI;
import edu.stanford.nlp.classify.ColumnDataClassifier;


public class DocumentClassifier {
    public ColumnDataClassifier cdc;
    private static DocumentClassifier classifier = new DocumentClassifier();
    private DocumentClassifier() {
        if (cdc == null) cdc = new ColumnDataClassifier("C:\\Users\\rocky\\IdeaProjects\\DocumentClassify\\src\\test\\data\\my.prop");
    }
    public static DocumentClassifier getClassifier() {
        return classifier;
    }

    public static void main(String[] args) {
        UI ui = new UI();
    }
}
