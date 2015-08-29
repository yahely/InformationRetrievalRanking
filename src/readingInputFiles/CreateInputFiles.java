package readingInputFiles;

import java.io.File;
import java.io.IOException;

public class CreateInputFiles {

	String [] dict;
	
	
	public CreateInputFiles(String parameterFilePath) throws IOException
	{
	
		ReadingParameterFile parameterFile = new ReadingParameterFile(parameterFilePath);
		parameterFile.readFile();
		
		ReadingQueriesFile queriesFile = new ReadingQueriesFile(parameterFile.getQueryFileName());
		queriesFile.readFile();
		
		dict = queriesFile.getDictonaryNumberQueryToQuery();
	}
	
	public void Create(String dataDirPath)
	{
		String fileName = "test.txt";
		File dir = new File (dataDirPath);
		File actualFile = new File (dir, fileName);
	}
}
