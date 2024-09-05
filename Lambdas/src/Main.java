import java.util.*;
import java.util.function.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        // 1. Use a Predicate to check if a string is empty
        Predicate<String> isEmpty = (String s) -> ((s.length() == 0));
        System.out.println("Is empty: " + isEmpty.test("")); // Expected: true

        // 2. Use a Function to convert a string to its length
        Function<String, Integer> stringLength = (String s) -> (s.length());
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello")); // Expected: 5

        // 3. Use a Consumer to print a message
        Consumer<String> printMessage = (String s) -> System.out.println(s);
        printMessage.accept("Hello, World!"); // Expected: Hello, World!

        // 4. Use a Supplier to generate a random number (I did a random number between 0 and 100)
        Supplier<Double> randomSupplier = () -> (Math.random());
        System.out.println("Random number: " + randomSupplier.get());

        // 5. Use a Comparator to compare two strings by length
        Comparator<String> compareByLength = (String s1, String s2) -> {
        	if(s1.length() > s2.length()) {
        		return 1;
        	}
        	
        	if(s2.length() > s1.length()) {
        		return -1;
        	}
        	
        	else {
        		return 0;
        	}
        };
        
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Collections.sort(words, compareByLength);
        System.out.println("Words sorted by length: " + words); // Expected: [apple, cherry, banana]

        // 6. Use a BiFunction to multiply two integers
        BiFunction<Integer, Integer, Integer> multiply = (Integer a, Integer b) -> (a*b);
        System.out.println("3 * 4 = " + multiply.apply(3, 4)); // Expected: 12

        // 7. Use a UnaryOperator to square an integer
        UnaryOperator<Integer> square = (Integer a) -> (a*a);
        System.out.println("Square of 5: " + square.apply(5)); // Expected: 25

        // 8. Use a BiConsumer to print two strings concatenated
        BiConsumer<String, String> printConcatenated = (String a, String b) -> System.out.println(a+b);
        printConcatenated.accept("Hello, ", "World!"); // Expected: Hello, World!

        // 9. Use a BinaryOperator to find the maximum of two integers
        BinaryOperator<Integer> max = (Integer a, Integer b) -> {
        	if(a >= b) {
        		return a;
        	}
        	
        	else {
        		return b;
        	}
        	
        };
        System.out.println("Max of 10 and 20: " + max.apply(10, 20)); // Expected: 20

        // 10. Use a Predicate to check if a number is even
        Predicate<Integer> isEven = (Integer a) -> (a % 2 == 0);
        System.out.println("Is 8 even? " + isEven.test(8)); // Expected: true
    }
}