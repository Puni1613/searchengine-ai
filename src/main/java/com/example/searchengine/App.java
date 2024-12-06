package com.example.searchengine;

import com.example.searchengine.pipeline.PipeLine;
import com.example.searchengine.indexing.SolrIndexer;
import com.example.searchengine.reader.DBSourceReader;
import com.example.searchengine.reader.ISourceReader;
import com.example.searchengine.reader.PDFSourceReader;
import com.example.searchengine.reader.TextSoureReader;
import com.example.searchengine.transform.Transformer;

/**
 * Solr Indexing !
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ISourceReader pdfReader = new PDFSourceReader("path/to/file.pdf");
        ISourceReader textFileReader = new TextSoureReader("path/to/file.txt");
        ISourceReader dbReader = new DBSourceReader("jdbc:postgres://localhost:5431/database", "SELECT * FROM sampeld");

        Transformer transformer = new Transformer();
        SolrIndexer solrIndexer = new SolrIndexer("http://localhost:8983/solr/my_core");

        // Example: Index PDF data
        PipeLine pdfPipeline = new PipeLine(pdfReader, transformer, solrIndexer);
        pdfPipeline.execute();

        // Example: Index text file data
        PipeLine textPipeline = new PipeLine(textFileReader, transformer, solrIndexer);
        textPipeline.execute();

        // Example: Index database data
        PipeLine dbPipeline = new PipeLine(dbReader, transformer, solrIndexer);
        dbPipeline.execute();
    }
}
