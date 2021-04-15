// This class is a generic base for one question
public abstract class QuizItem
{
    // ---------------------------------------------------------
    protected String question;
    protected String answer;

    // No-arg constructor
    public QuizItem()
    {
        question = "";
        answer   = "";
    }

    public QuizItem(String q, String a)
    {
        question = q;
        answer   = a;
    }

    // ---------------------------------------------------------
    // Set methods
    public void setQuestion(String q)
    {
        question = q;
    }

    public void setAnswer(String a)
    {
        answer = a;
    }

    // ---------------------------------------------------------
    // Get methods
    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }

    // ---------------------------------------------------------
    // Abstract method for generating a quiz question,
    // depending on the type of question it is
    public abstract String generateQuestion();

    // ---------------------------------------------------------
    // This class generates a string with the current data
    public String toString()
    {
        String outputString = "The question is: " + question + "\n"
                            + "The answer is: "   + answer;
        return outputString;
    }
}

