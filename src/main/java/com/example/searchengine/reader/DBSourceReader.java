package com.example.searchengine.reader;

import java.util.List;
import java.util.Map;

public class DBSourceReader implements ISourceReader {

    private String dbUrl ;
    private String query;

    public DBSourceReader(String dbUrl, String query){

        this.dbUrl = dbUrl;
        this.query= query;

    }
    @Override
    public List<Map<String, Object>> readData() {
        return List.of();
    }
}
