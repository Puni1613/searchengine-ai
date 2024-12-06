package com.example.searchengine.indexing;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.util.List;
import java.util.Map;

public class SolrIndexer {
    private static final String SOLR_URL = "http://localhost:8983/solr/new_core";

    private String solrUrl;

    public SolrIndexer(String solrUrl) {
        this.solrUrl = solrUrl;
    }

    public void indexData(List<Map<String, Object>> documents) throws Exception {
        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
        for (Map<String, Object> doc : documents) {
            SolrInputDocument solrDoc = new SolrInputDocument();
            for (Map.Entry<String, Object> entry : doc.entrySet()) {
                solrDoc.addField(entry.getKey(), entry.getValue());
            }
            solrClient.add(solrDoc);
        }
        solrClient.commit();
    }
}
