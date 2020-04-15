package com.utpe.dataProcess;

import com.utpe.ui.UI;
import edu.stanford.nlp.classify.ColumnDataClassifier;

import java.io.File;

// create a singleton DocumentClassifier class that has property of columnDataClassifier
public class DocumentClassifier {
    public ColumnDataClassifier columnDataClassifier;
    private static DocumentClassifier documentClassifier = new DocumentClassifier();
    private DocumentClassifier() {
        String propPath = System.getProperty("user.dir") + "\\data\\property\\" + "my.prop";
        if (columnDataClassifier == null) columnDataClassifier = new ColumnDataClassifier(propPath);
    }
    public static DocumentClassifier getDocumentClassifier() {
        return documentClassifier;
    }

    public static void main(String[] args) {
        UI ui = new UI();
    }

}
