import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter your content: ");
        String input = scanner.nextLine();

        // Tạo một HashMap để lưu trữ số lần xuất hiện của từ và ký tự
        Map<String, Integer> wordCount = new HashMap<>();

        //matches pattern
        Pattern pattern = Pattern.compile("[\\s\\p{Punct} 0-9]+");

        /*
        * \\s = " space"  "tab"
        * \\p{Punct} = special key, .......
        */

        String[] words = pattern.split(input);

        //put to count the words
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        //display words have been counted
        System.out.print("(");
        for (String word : wordCount.keySet()) {
            System.out.print(word + "=" + wordCount.get(word) + ",");
        }
        System.out.println(")");
        //display character
        displayLetterCount(input);

        scanner.close();
    }
    public static void displayLetterCount(String input) {

        System.out.print("{");
        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                char inputChar = Character.toLowerCase(input.charAt(i));
                if (inputChar == c) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.print(c + "=" + count + ",");
            }
        }
        System.out.println("}");
    }
    }


