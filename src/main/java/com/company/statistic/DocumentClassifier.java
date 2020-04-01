package com.company.statistic;

import com.company.ui.UI;
import edu.stanford.nlp.classify.ColumnDataClassifier;


public class DocumentClassifier {
    public ColumnDataClassifier cdc;
    private static DocumentClassifier classifier = new DocumentClassifier();
    private DocumentClassifier() {
        if (cdc == null) cdc = new ColumnDataClassifier("C:\\Users\\rocky\\IdeaProjects\\DocumentClassify\\data\\20news1.prop");
    }
    public static DocumentClassifier getClassifier() {
        return classifier;
    }

    public static void main(String[] args) {
        UI ui = new UI();
    }
}
