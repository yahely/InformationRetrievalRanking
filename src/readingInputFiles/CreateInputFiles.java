package readingInputFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
	
	public void Create(String dataDirPath) throws IOException
	{
		File dir = new File (dataDirPath);
		boolean bool=dir.mkdirs();
		int indexFile=1;
		
		while(indexFile < dict.length)
		{ 
			String fileName = indexFile+".txt";		
			File actualFile = new File (dir, fileName);
			
			// writing to file
			// if file doesnt exists, then create it
			if (!actualFile.exists()) {
				actualFile.createNewFile();
			}
		
			FileWriter fw = new FileWriter(actualFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dict[indexFile-1]);
			bw.close();
			indexFile++;
		}
	}
}
