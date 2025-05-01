import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize TextProcessor with the path to your words file
            TextProcessor textProcessor = new TextProcessor("sentiment_words.txt");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a sentence to analyze its sentiment:");
            String sentence = scanner.nextLine();

            String sentiment = textProcessor.analyzeSentiment(sentence);
            System.out.println("Sentiment: " + sentiment);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not load the sentiment words file.");
         
        }
       
    }

}
