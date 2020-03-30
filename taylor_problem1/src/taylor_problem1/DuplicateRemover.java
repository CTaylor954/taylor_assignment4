package taylor_problem1;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover 
{

	Set<String> uniqueWords;
	void remove(String dataFile)
		{
			Scanner fileReader = null;
			try {
	            uniqueWords = new LinkedHashSet<>();
	            fileReader = new Scanner(new File(dataFile));
	            while(fileReader.hasNextLine())
		            {
		                String readLine = fileReader.nextLine();
		                String[] words = readLine.split(" ");
		                for(int i=0;i<words.length;i++) 
			                {
			                    String str=words[i].toLowerCase();
			                    uniqueWords.add(str);
			                }
		            }

	        	}
			
	        catch(Exception e)
		        {
		            System.out.println("Exceptional IO event occurred while opening "+dataFile);
		        }
	        
			if(fileReader != null)
	        	fileReader.close();
	    }
	    
	
	void write(String outputFile)
	    {
	        FileWriter output = null;
	        try 
		        {
		            output = new FileWriter(outputFile);
		            for(String UniqueWords:uniqueWords)
		            	{
		                	output.write(UniqueWords+"\n");
		            	}
		            output.close();
		        }
	        catch(Exception e)
		        {
		            System.out.println("Exceptional IO event occurred while writing to "+outputFile);
		        }

	    }

}
