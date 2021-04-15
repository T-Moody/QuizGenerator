// This class chooses a word randomly from a list
// and generates a word scramble question

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordScramble extends QuizItem
{
    // ---------------------------------------------------------
    private final String fileName = "compWords.txt";
    private final int    MAX_ARRAY_SIZE = 2000;

    String[] answerList;  // Holds all possible answers
    int      numElements;

    // ---------------------------------------------------------
    // No-arg constructor reads from file and adds possible answers to a list
    public WordScramble()
    {
        // Instantiate list answer list
        answerList = new String[MAX_ARRAY_SIZE];

        try
        {
            File inputFile = new File(fileName);
            Scanner inputFileScanner = new Scanner(inputFile);

            int i = 0;  // Counting variable

            // Add answers to list while file has more elements
            while (inputFileScanner.hasNext())
            {
                answerList[i] = inputFileScanner.nextLine();
                i++;
            }
            numElements = i;  // Capture number of elements
        }
        catch (IOException e)
        {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    // ---------------------------------------------------------
    // This method selects an answer at random from a list
    // and scrambles the answer to create the question
    public String generateQuestion()
    {

        String outputString = "Unscramble the following computer term: ";  // Start to build output
        int    randomIndex = (int) (Math.random() * numElements);          // Get random index
        char   tempChar;                                                   // Temp variable for preforming swaps

        answer = answerList[randomIndex];  // Capture answer

        // Create StringBuilder for scrambling word
        StringBuilder scrambledString = new StringBuilder(answer);

        // Swap each letter in the word with a random index
        for (int i = 0; i < answer.length(); i++)
        {
            randomIndex = (int) (Math.random() * answer.length());  // Get random index
            tempChar = scrambledString.charAt(randomIndex);         // Get char at random index

            // Swap current character with random index character
            scrambledString.setCharAt(randomIndex, scrambledString.charAt(i));
            scrambledString.setCharAt(i, tempChar);
        }

        question = outputString + scrambledString.toString();  // Capture question

        outputString += question + "\t\t" + answer;            // Build output

        return outputString;
    }
}
