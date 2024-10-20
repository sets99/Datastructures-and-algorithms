package ds.recursivebacktrack;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SegementMeaningful {

	  private static Set<String> wordSet;

	    // Load words from the file
	    @BeforeAll
	    public static void setUp() throws IOException {
	        wordSet = new HashSet<String>(Files.readAllLines(Paths.get("words.txt")));
	    }


	    @Test
	    public void testIHaveAnAgreement() {
	    
	        // Arrange
	        String input2 = "ihaveanagreement";
	        String expected2 = "i have an agreement";

	        // Act
	        String result2 = Main.canBeSegmented(input2, wordSet);
	        System.out.println(result2);
	        // Assert
	        assertEquals(expected2, result2, "Failed for: " + input2);
	    }

	    @Test
	    public void testFredIsHere() {
	        // Arrange
	        String input = "fredishere";
	        String expected = "fred is here";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testWeWalkTogetherAtNight() {
	        // Arrange
	        String input = "wewalktogetheratnight";
	        String expected = "we walk to get her at night";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testTheDogChasedTheBall() {
	        // Arrange
	        String input = "thedogchasedtheball";
	        String expected = "the dog chased the ball";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testTheChildIsHappy() {
	        // Arrange
	        String input = "thechildishappy";
	        String expected = "the child is happy";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testItIsNotPossible() {
	        // Arrange
	        String input = "itisnotpossible";
	        String expected = "it is not possible";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testBusinessMeetingAtNoon() {
	        // Arrange
	        String input = "businessmeetingatnoon";
	        String expected = "business meeting at no on";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testMusicAndArtAreFun() {
	        // Arrange
	        String input = "musicandartarefun";
	        String expected = "music and art are fun";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testSchoolIsClosedToday() {
	        // Arrange
	        String input = "schoolisclosedtoday";
	        String expected = "school is closed to day";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	    @Test
	    public void testScienceIsInteresting() {
	        // Arrange
	        String input = "scienceisinteresting";
	        String expected = "science is interesting";

	        // Act
	        String result = Main.canBeSegmented(input, wordSet);

	        // Assert
	        assertEquals(expected, result, "Failed for: " + input);
	    }

	 

}
