package ds.trie;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestTrie {

	
	 private Trie trie;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	 @BeforeEach
	    public void setUp() {
	        trie = new MyTrie(); // Replace with your actual Trie implementation class
	    }

	 @Test
	    public void testInsertAndContainsBasic() {
	        trie.insert("apple");
	        trie.insert("app");
	        trie.insert("banana");

	        assertTrue(trie.contains("apple"), "Trie should contain 'apple'");
	        assertTrue(trie.contains("app"), "Trie should contain 'app'");
	        assertTrue(trie.contains("banana"), "Trie should contain 'banana'");
	        assertFalse(trie.contains("grape"), "Trie should not contain 'grape'");
	    }

	    @Test
	    public void testInsertDuplicate() {
	        trie.insert("apple");
	        trie.insert("apple"); // Insert duplicate

	        assertTrue(trie.contains("apple"), "Trie should contain 'apple'");
	    }

	    @Test
	    public void testCaseSensitivity() {
	        trie.insert("Apple");
	        assertFalse(trie.contains("apple"), "Trie should not contain lowercase 'apple' if case-sensitive");
	        assertTrue(trie.contains("Apple"), "Trie should contain 'Apple' as inserted");

	        trie.insert("banana");
	        assertFalse(trie.contains("Banana"), "Trie should not contain uppercase 'Banana' if case-sensitive");
	    }

	    @Test
	    public void testSortAlphabeticalOrder() {
	        trie.insert("banana");
	        trie.insert("apple");
	        trie.insert("cherry");

	        ArrayList<String> sortedList = trie.sort();
	        ArrayList<String> expectedList = new ArrayList<>();
	        expectedList.add("apple");
	        expectedList.add("banana");
	        expectedList.add("cherry");

	        assertEquals(expectedList, sortedList, "Sorted list should match expected alphabetical order.");
	    }

	    @Test
	    public void testSortEmptyTrie() {
	        ArrayList<String> sortedList = trie.sort();
	        assertTrue(sortedList.isEmpty(), "Sorted list should be empty when the trie is empty.");
	    }

	    @Test
	    public void testPrefixSearchWithMatchingResults() {
	        trie.insert("app");
	        trie.insert("apple");
	        trie.insert("apricot");
	        trie.insert("banana");

	        ArrayList<String> prefixResults = trie.search("app");
	        ArrayList<String> expectedResults = new ArrayList<>();
	        expectedResults.add("app");
	        expectedResults.add("apple");

	        assertEquals(expectedResults, prefixResults, "Search results should match words with 'app' prefix.");
	    }

	    @Test
	    public void testPrefixSearchWithNoMatchingResults() {
	        trie.insert("dog");
	        trie.insert("cat");

	        ArrayList<String> prefixResults = trie.search("zoo");
	        assertTrue(prefixResults.isEmpty(), "Search results should be empty when no words match the prefix.");
	    }

	    @Test
	    public void testPrefixSearchWithPartialMatches() {
	        trie.insert("testing");
	        trie.insert("test");
	        trie.insert("tested");

	        ArrayList<String> prefixResults = trie.search("test");
	        ArrayList<String> expectedResults = new ArrayList<>();
	        expectedResults.add("test");
	        expectedResults.add("tested");
	        expectedResults.add("testing");

	        assertEquals(expectedResults, prefixResults, "Search results should match all words with 'test' prefix.");
	    }

	    @Test
	    public void testPrefixSearchEmptyTrie() {
	        ArrayList<String> prefixResults = trie.search("any");
	        assertTrue(prefixResults.isEmpty(), "Search results should be empty when the trie is empty.");
	    }

	    @Test
	    public void testContainsOnEmptyTrie() {
	        assertFalse(trie.contains("anyword"), "Contains should return false for any word in an empty trie.");
	    }

	   


}
