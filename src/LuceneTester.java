
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import readingInputFiles.CreateInputFiles;
import readingInputFiles.ReadingParameterFile;
import readingInputFiles.ReadingQueriesFile;

public class LuceneTester {
	
   static String  dataDir= "D:\\Lucene\\Index";
   String  indexDir= "D:\\Lucene\\Data";
   Indexer indexer;
   
   public static void main(String[] args) throws ParseException {
      LuceneTester tester;
      try {
    	  String parameterFilePath="parameterFile.txt";
    	  CreateInputFiles createInputFiles=new CreateInputFiles(parameterFilePath);
  		  createInputFiles.Create(dataDir);
          tester = new LuceneTester();
          tester.createIndex();
         
          ReadingParameterFile parameterFile = new ReadingParameterFile(parameterFilePath);
  		  parameterFile.readFile();
          ReadingQueriesFile queriesFile = new ReadingQueriesFile(parameterFile.getQueryFileName());
  		  queriesFile.readFile();
  		
  		  String [] dict= queriesFile.getDictonaryNumberQueryToQuery();
          tester.search(dict[0]);
         
         
      } catch (IOException e) {
         e.printStackTrace();
      } 
   }

   private void createIndex() throws IOException{
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }
   
   private void search(String searchQuery) throws IOException, ParseException{
	      Searcher searcher = new Searcher(indexDir);
	      long startTime = System.currentTimeMillis();
	      TopDocs hits = searcher.search(searchQuery);
	      long endTime = System.currentTimeMillis();
	   
	      System.out.println(hits.totalHits +
	         " documents found. Time :" + (endTime - startTime));
	      for(ScoreDoc scoreDoc : hits.scoreDocs) {
	         Document doc = searcher.getDocument(scoreDoc);
	            System.out.println("File: "
	            + doc.get(LuceneConstants.FILE_PATH));
	      }
	      searcher.close();
	   }
}