package ds.recursivebacktrack;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {


	
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
	
	public static String canBeSegmented( String string,Set<String> dictionary) {
		if(string.equals("")){
			return "";
		}

		for(int i = 0; i <= string.length(); i++) {			
			if(dictionary.contains(string.substring(0, i))) {			
				if(canBeSegmented(string.substring(i), dictionary) == null) {
					continue;
				}
				
				else {
					return string.substring(0, i) + " " + canBeSegmented(string.substring(i), dictionary);
				}
			}
		}
		
		return null;// if I make it here I did not find a word indicate with null
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
