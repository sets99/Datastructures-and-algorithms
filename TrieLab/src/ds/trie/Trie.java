package ds.trie;

import java.io.IOException;
import java.util.ArrayList;

public interface Trie {

	
	 /**
     * Loads words from a file and inserts them into the trie.
     * Each line in the file is considered a separate word.
     * 
     * @param filename the path to the file containing words
     * @throws IOException if an I/O error occurs while reading the file
     */
	 public void loadWordsFromFile(String filename) throws IOException;
	
	/**
	adds a new string to the trie.

	@param insert the string to add to the trie.
	@return No return value
	*/
	void insert(String insert);
	
	/**
	returns a ArrayList containing all the strings in the trie.
	In order is a sorted ArrayList
	@return An ArrayList that contains the strings in the trie.
	*/
	 ArrayList<String> sort( ); 

	/**
	returns a vector with all the possible words
	that start with prefix
	@param prefix the string to look for in the trie.
	@return vector with the strings in it.
	*/
	 ArrayList<String> search(String prefix);

	/**
	returns true if the string is in the trie.
	@param find the string to look for in the trie.
	@return true if the strings in the trie.
	*/
	boolean contains(String find);
}
