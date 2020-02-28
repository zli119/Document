package com.company.statistic.fileReader;

import java.util.HashMap;

public interface MyReader {
    public abstract HashMap<String, Integer> countWords(String filePath);
}
