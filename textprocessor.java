import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextProcessor {
    // Lists to store positive and negative words
    private ArrayList<String> positiveWords; // Words with positive sentiment
    private ArrayList<String> negativeWords; // Words with negative sentiment

    // Constructor to initialize the TextProcessor
    public TextProcessor(String filePath) throws FileNotFoundException {
        positiveWords = new ArrayList<>();
        negativeWords = new ArrayList<>();
        loadWords(filePath); // Load words from the file
    }

    // Method to load words from the file
    private void loadWords(String filePath) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filePath)); // Open the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim(); // Read each line
            if (line.isEmpty() || line.startsWith("#")) {
                continue; // Skip empty lines or comments
            }

            String[] parts = line.split("\\s+"); // Split the line into word and score
            if (parts.length != 2) {
                System.out.println("Skipping invalid line: " + line);
                continue;
            }

            String word = parts[0].toLowerCase(); // Convert word to lowercase
            double score = Double.parseDouble(parts[1]); // Parse the score

            // Add the word to the appropriate list
            if (score > 0) {
                positiveWords.add(word); // Positive word
            } else if (score < 0) {
                negativeWords.add(word); // Negative word
            }
        }
        fileScanner.close(); // Close the file
    }

    // Method to analyze the sentiment of a sentence
    public String analyzeSentiment(String sentence) {
        double totalScore = 0.0; // Total sentiment score
        String[] words = sentence.toLowerCase().split("\\s+"); // Split sentence into words
        ArrayList<String> foundPositiveWords = new ArrayList<>(); // Found positive words
        ArrayList<String> foundNegativeWords = new ArrayList<>(); // Found negative words

        // Check each word in the sentence
      
        
        for (String word : words) {
            if (positiveWords.contains(word)) {
                totalScore += 1.0; // Add 1 for positive words
                foundPositiveWords.add(word); // Add to found positive words
            } else if (negativeWords.contains(word)) {
                totalScore -= 1.0; // Subtract 1 for negative words
                foundNegativeWords.add(word); // Add to found negative words
            }
        }

        // Determine the sentiment
        if (totalScore > 0) {
            return "Positive sentiment. Positive words found: " + foundPositiveWords;
        } else if (totalScore < 0) {
            return "Negative sentiment. Negative words found: " + foundNegativeWords;
        } else {
            return "Neutral sentiment. No strong positive or negative words found.";
        }
    }
}
