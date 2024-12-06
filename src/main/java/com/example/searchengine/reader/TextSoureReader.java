package com.example.searchengine.reader;

import java.util.List;
import java.util.Map;

public class TextSoureReader  implements  ISourceReader{
    private String filePath;

    public TextSoureReader(String filePath){
        this.filePath = filePath;
    }
    @Override
    public List<Map<String, Object>> readData() {
        return List.of();
    }
}
