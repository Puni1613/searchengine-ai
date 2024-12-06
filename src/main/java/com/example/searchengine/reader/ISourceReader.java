package com.example.searchengine.reader;

import java.util.List;
import java.util.Map;

public interface ISourceReader {

    List<Map<String, Object>> readData();
}
