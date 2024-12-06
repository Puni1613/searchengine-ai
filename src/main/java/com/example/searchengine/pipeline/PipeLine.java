package com.example.searchengine.pipeline;

import com.example.searchengine.indexing.SolrIndexer;
import com.example.searchengine.reader.ISourceReader;
import com.example.searchengine.transform.Transformer;

import java.util.List;
import java.util.Map;

public class PipeLine {

    private ISourceReader reader;
    private Transformer transformer;
    private SolrIndexer indexer;

    public  PipeLine(ISourceReader soureReader,Transformer transformation,SolrIndexer indexer){
        this.reader = soureReader;
        this.transformer = transformation;
        this.indexer = indexer;
    }

    public void execute() {
        try {
            // Read data
            List<Map<String, Object>> rawData = reader.readData();

            // Transform data
            List<Map<String, Object>> transformedData = transformer.transform(rawData);

            // Index data
            indexer.indexData(transformedData);

            System.out.println("Data indexed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
