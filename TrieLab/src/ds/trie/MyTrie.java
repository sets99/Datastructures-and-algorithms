package ds.trie;

import java.io.IOException;
import java.util.ArrayList;

public class MyTrie implements Trie {
	private class TrieNode {
		private boolean validString;
		private TrieNode parent;
		private int currentIndex = 0;
		private TrieNode nodes[] = new TrieNode[26];

		public TrieNode(boolean validString, TrieNode parent) {
			validString = this.validString;
			parent = this.parent;
		}

		public boolean isValidString() {
			return validString;
		}

		public TrieNode getParent() {
			return parent;
		}

		public int getCurrentIndex() {
			return currentIndex;
		}

	};

	@Override
	public void loadWordsFromFile(String filename) throws IOException {
		
	}

	@Override
	public void insert(String insert) {
		TrieNode curr = root;
		for(char character: insert.toCharArray()) {
			int x = character - 'a';
			if(curr.nodes[x] == null) {
				curr.nodes[x] = new TrieNode(false, curr);
			}
			
			curr = curr.nodes[x];
		}
		
		curr.validString = true;

	}

	@Override
	public ArrayList<String> sort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> search(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String find) {
		TrieNode curr = root;
		for(char character: find.toCharArray()) {
			int x = character - 'a';
			if(curr.nodes[x] == null) {
				return false;
			}
			
			curr = curr.nodes[x];
		}
		
		return find.isValidString();
	}

}