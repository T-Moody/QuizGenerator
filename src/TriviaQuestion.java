// This class chooses a random trivia question from a list
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TriviaQuestion extends QuizItem
{
    // ---------------------------------------------------------
    private final String fileName = "trivia.txt";
    private final int    MAX_ARRAY_SIZE = 2000;

    private String[] triviaQuestionList;
    private String[] triviaAnswerList;
    private int      numElements;

    // ---------------------------------------------------------
    // No-arg constructor reads from file and adds possible answers and questions to a list
    public TriviaQuestion()
    {
        // Instantiate list answer list
        triviaQuestionList = new String[MAX_ARRAY_SIZE];
        triviaAnswerList   = new String[MAX_ARRAY_SIZE];

        try
        {
            File inputFile = new File(fileName);
            Scanner inputFileScanner = new Scanner(inputFile);

            int i = 0;  // Counting variable

            // Add questions and answers to list while file has more elements
            while (inputFileScanner.hasNext())
            {
                triviaQuestionList[i] = inputFileScanner.nextLine();
                triviaAnswerList[i]   = inputFileScanner.nextLine();
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
    // This class generates a random question from the list
    public String generateQuestion()
    {
        String outputString;
        int    randomIndex;

        randomIndex = (int) (Math.random() * numElements);  // Get random index

        question = triviaQuestionList[randomIndex];         // Get question at index
        answer   = triviaAnswerList[randomIndex];           // Get answer at index

        outputString = question + "\t\t" + answer;          // Build output

        return outputString;
    }
}
