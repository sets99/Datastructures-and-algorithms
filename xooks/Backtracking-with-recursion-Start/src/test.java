import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class test {


	
	public static  ArrayList<String>  readStrings(String fileName){
		
		ArrayList<String> strings = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			
			while((line = br.readLine()) !=null) {
				strings.add(line.toLowerCase());
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return strings;
	}
	
	
	
	
	
	public static void checkWord(String string, Set<String > dictionary) {
	
		
		String breakUp = canBeSegmented(string.toLowerCase(),  dictionary);
		if(breakUp == null) {
			System.out.println(String.format("There is no set of words to solve: %s\n", string));
		}
		else
		{
			
			System.out.println(String.format("For %s Found  %s%n", string, breakUp));
		}
			
	}
	
	public static String canBeSegmented(String string, Set<String> dictionary) {
        // Base case: if the string is empty, we return an empty string
        if (string.equals("")) {
            return "";
        }
    
        // Try all possible prefixes of the string
        for (int i = 1; i <= string.length(); i++) {
            // Check if the prefix is in the dictionary
            String prefix = string.substring(0, i);
            if (dictionary.contains(prefix)) {
                // Recursively check for the rest of the string
                String suffixResult = canBeSegmented(string.substring(i), dictionary);
                
                // If the suffix can be segmented, return the result
                if (suffixResult != null) {
                    return prefix + (suffixResult.isEmpty() ? "" : " " + suffixResult);
                }
            }
        }
    
        // If no valid segmentation is found, return null
        return null;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
		ArrayList<String> words = readStrings("words.txt"); // reuse readstrings for both reads (add filename paremeter)
		HashSet<String> wordSet = new HashSet<>(words);
		ArrayList<String> strings = readStrings("strings.txt");
			
		
		for(String string: strings) {
			checkWord(string, wordSet);
		}
		
	}

}
