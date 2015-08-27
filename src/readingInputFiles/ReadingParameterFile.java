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
	
	static String parameterFileName;
	static String queryFileName;
	static String docsFileName;
	static String outputFileName;
	static String retrievalAlgorithmType;
	
	public ReadingParameterFile()
	{
		parameterFileName = InputConstants.PARAMETER_FILE;
		queryFileName = InputConstants.EMPTY_STRING;
		docsFileName = InputConstants.EMPTY_STRING;;
		outputFileName = InputConstants.EMPTY_STRING;;
		retrievalAlgorithmType = InputConstants.EMPTY_STRING;;
	}
	
	public static void readFile() throws IOException 
	{
		
		String content;
		String [] splitedContent;
		byte[] bytesContentFile;
		Path pathParameterFile = Paths.get(parameterFileName);
		bytesContentFile = Files.readAllBytes(pathParameterFile);
		content = new String(bytesContentFile);
		
		splitedContent = content.split("queryFile=");
		queryFileName = splitedContent[0];
		
		splitedContent = content.split("docsFile=");
		docsFileName = splitedContent[0];
		
		splitedContent = content.split("outpotFile=");
		outputFileName = splitedContent[0];
		
		splitedContent = content.split("retrievalAlgorithm=");
		retrievalAlgorithmType = splitedContent[0];

	}
	
}
