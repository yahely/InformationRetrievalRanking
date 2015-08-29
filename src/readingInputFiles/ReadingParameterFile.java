package readingInputFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/*
 * The structure of the file is:
 * 		queryFile=queries.txt
 * 		docsFile=docs.txt
 * 		outpotFile=output.txt
 * 		etrievalAlgorithm=basic
 */
public class ReadingParameterFile {
	
	String parameterFileName;
	String queryFileName;
	String docsFileName;
	String outputFileName;
	String retrievalAlgorithmType;
	
	public ReadingParameterFile(String parameterFilePath)
	{
		parameterFileName = parameterFilePath;
		queryFileName = "";
		docsFileName = "";
		outputFileName = "";
		retrievalAlgorithmType = "";
	}
	
	public String getQueryFileName()
	{
		return queryFileName;
	}
	
	public String getDocsFileName()
	{
		return docsFileName;
	}
	
	public String getOutputFileName()
	{
		return outputFileName;
	}
	
	public String getRetrievalAlgorithmType()
	{
		return retrievalAlgorithmType;
	}
	
	public void readFile() throws IOException 
	{
		
		String content;
		String [] splitedContent;
		byte[] bytesContentFile;
		Path pathParameterFile = Paths.get(parameterFileName);
		bytesContentFile = Files.readAllBytes(pathParameterFile);
		content = new String(bytesContentFile);
		
		splitedContent = content.split("queryFile=");
		queryFileName = splitedContent[1].split("\r\n")[0];
		
		splitedContent = content.split("docsFile=");
		docsFileName = splitedContent[1].split("\r\n")[0];
		
		splitedContent = content.split("outpotFile=");
		outputFileName = splitedContent[1].split("\r\n")[0];
		
		splitedContent = content.split("retrievalAlgorithm=");
		retrievalAlgorithmType = splitedContent[1].split("\r\n")[0];

	}
	
}
