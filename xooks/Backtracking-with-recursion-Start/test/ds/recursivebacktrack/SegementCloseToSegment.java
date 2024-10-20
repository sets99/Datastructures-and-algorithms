package ds.recursivebacktrack;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class SegementCloseToSegment {

	  private static Set<String> wordSet;

	    // Load words from the file
	    @BeforeAll
	    public static void setUp() throws IOException {
	        wordSet = new HashSet<>(Files.readAllLines(Paths.get("words.txt")));
	    }


	    @Test
	    public void testAlmostSentence2() {
	        // Arrange
	        String input = "thedogchasethebal";
	        String expected = null;

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testAlmostSentence3() {
	        // Arrange
	        String input = "schoolisopenoday";
	        String expected = null;

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testAlmostSentence4() {
	        // Arrange
	        String input = "businessmetingatnoon";
	        String expected = null;

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testAlmostSentence5() {
	        // Arrange
	        String input = "childhappandplay";
	        String expected = null;

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testAlmostSentence6() {
	        // Arrange
	        String input = "musicararefun";
	        String expected = null;

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testAlmostSentence7() {
	        // Arrange
	        String input = "thechiledishappy";
	        String expected = null;

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testAlmostSentence8() {
	        // Arrange
	        String input = "scienceisfuny";
	        String expected = null;

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

}
