import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> dictionary = new HashMap<String, String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("5000_words_definitions.csv"))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] string = line.split(",");
				dictionary.put(string[0], string[1]);
				
			}
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String word = scanner.next();
		if(dictionary.containsKey(word)) {
			System.out.println("Definition: " + dictionary.get(word));
		}
		
		else {
			System.out.println("Word not found in the dictionary.");
		}
		

	}

}
