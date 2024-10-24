package itec220.labs;

import java.util.*;
import java.io.*;

public class MorseConverter implements Converter {

	private HashMap<String, String> letterToMorse;
	private HashMap<String, String> morseToLetter;
	
	public MorseConverter(String fileName) {
		List<String> lines;
		
		try {
			lines = FileUtility.readfile("MorseCodeTable.txt");
		}
		
		
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < lines.size(); i++) {
			String[] arr = new String[2];
			arr = lines.get(i).split("~");
			letterToMorse.put(arr[0], arr[1]);
			morseToLetter.put(arr[1], arr[0]);
		}
		
		
	}
	@Override
	public void printKeyValuePairs() {
		for (String letter: this.letterToMorse.keySet()) {
		    String morse = this.letterToMorse.get(letter);
		    System.out.println(letter + " " + morse);
		}

	}

	@Override
	public String encodeSentence(String textToEncode) {
		String encoded = "";
		
		for(int i = 0; i < textToEncode.length(); i++) {
			encoded = encoded + letterToMorse.get(String.valueOf(textToEncode.charAt(i)));
		}
		
		return encoded;
	}

	@Override
	public String encodeWord(String textToEncode) {
		String encoded = "";
		
		for(int i = 0; i < textToEncode.length(); i++) {
			encoded = encoded + letterToMorse.get(String.valueOf(textToEncode.charAt(i)));
		}
		
		return encoded;
	}

	@Override
	public String decodeText(String textToDecode) {
		String decoded = "";
		
		for(int i = 0; i < textToDecode.length(); i++) {
			decoded = decoded + morseToLetter.get(String.valueOf(textToDecode.charAt(i)));
		}
		
		return decoded;
	}

	@Override
	public boolean encodeFileToFile(String plainTextFileName, String encodedTextFileName) {
		List<String> lines;
		
		try {
			lines = FileUtility.readfile(plainTextFileName);
		}
		
		
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
		for(int i = 0; i < lines.size(); i++) {
			lines.set(i, encodeSentence(lines.get(i)));
		}
		
		for(int i = 0; i < lines.size(); i++) {
			PrintStream filePrinter = new PrintStream(new File(encodedTextFileName));
			filePrinter.println(lines.get(i));
		}
		
		return true;
		
	}

	@Override
	public boolean decodeFileToFile(String encodedTextFileName, String plainTextFileName) {
		List<String> lines;
		
		try {
			lines = FileUtility.readfile(plainTextFileName);
		}
		
		
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
		for(int i = 0; i < lines.size(); i++) {
			lines.set(i, decodeText(lines.get(i)));
		}
		
		for(int i = 0; i < lines.size(); i++) {
			PrintStream filePrinter = new PrintStream(new File(encodedTextFileName));
			filePrinter.println(lines.get(i));
		}
	}

}
