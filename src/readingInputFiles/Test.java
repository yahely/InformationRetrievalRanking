package readingInputFiles;

import java.io.IOException;

public class Test {

	public static void main(String[]args) throws IOException
	{
		//ReadingDocsFile docsFile = new ReadingDocsFile();
		String parameterFilePath="parameterFile.txt";
		ReadingParameterFile parameterFile = new ReadingParameterFile(parameterFilePath);
		parameterFile.readFile();
		
		ReadingQueriesFile queriesFile = new ReadingQueriesFile(parameterFile.getQueryFileName());
		queriesFile.readFile();
		
		String [] dict= queriesFile.getDictonaryNumberQueryToQuery();
		
		CreateInputFiles createInputFiles=new CreateInputFiles(parameterFilePath);
		createInputFiles.Create("D:\\Lucene\\Index");

		int x=0;
	}
}
