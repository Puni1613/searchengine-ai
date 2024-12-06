package com.example.searchengine.reader;

import java.util.List;
import java.util.Map;

public class PDFSourceReader implements  ISourceReader{
    private String filePath;

    public PDFSourceReader(String filePath){
        this.filePath = filePath;
    }
    @Override
    public List<Map<String, Object>> readData() {
        return List.of();
    }
}
