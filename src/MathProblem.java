// This class generates a random question of
// either multiplication or addition

public class MathProblem extends QuizItem
{
    // ---------------------------------------------------------
    private final int ADD_MIN      = 100;
    private final int ADD_MAX      = 999;
    private final int MULTIPLY_MIN = 10;
    private final int MULTIPLY_MAX = 99;

    int randomNum1, randomNum2;

    // ---------------------------------------------------------
    // No-args constructor
    public MathProblem()
    {
        randomNum1 = 0;
        randomNum2 = 0;
        answer     = "";
        question   = "";
    }

    // ---------------------------------------------------------
    // Method getters
    public int getRandomNum1()
    {return randomNum1;}
    public int getRandomNum2()
    {return randomNum2;}

    // ---------------------------------------------------------
    // Method Setters
    public void setRandomNum1(int randomNum1)
    {this.randomNum1 = randomNum1;}
    public void setRandomNum2(int randomNum2)
    {this.randomNum2 = randomNum2; }

    // ---------------------------------------------------------
    public String generateQuestion()
    {
        String outputString; // Use to build output

        // Randomly generate an addition problem
        if (Math.random() < 0.50)
        {
            randomNum1 = getRandomNumber(ADD_MIN, ADD_MAX);             // Generate random numbers
            randomNum2 = getRandomNumber(ADD_MIN, ADD_MAX);
            answer     = Integer.toString(randomNum1 + randomNum2);  // Find answer

            question = "Calculate " + randomNum1 + " + " + randomNum2;  // build question
        }
        // Randomly generate a multiplication problem
        else
        {
            randomNum1 = getRandomNumber(MULTIPLY_MIN, MULTIPLY_MAX);   // Generate random numbers
            randomNum2 = getRandomNumber(MULTIPLY_MIN, MULTIPLY_MAX);
            answer     = Integer.toString(randomNum1 * randomNum2);  // Find answer

            question = "Calculate " + randomNum1 + " X " + randomNum2;  // Build question
        }
        outputString = question + "\t\t" + answer;  // Build output

        return outputString;
    }

    // ---------------------------------------------------------
    // This method generates a random number using
    // given minimum and maximum values
    public int getRandomNumber(int min, int max)
    {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
