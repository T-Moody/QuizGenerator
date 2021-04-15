// This class allows the user to generate a random quiz through a
// user interface and allows them to reveal the answers when they choose to do so
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz extends Application
{
    // ---------------------------------------------------------
    private static final int MAX_ARRAY_SIZE = 10;

    private QuizItem[] quizItems = new QuizItem[MAX_ARRAY_SIZE];
    private String     questions;
    private String     answerKey;
    private TextArea   questionArea, answerArea;
    private Label      questionLabel, answerLabel;
    private Button     generateButton, showAnswerButton;

    public static void main(String[] args)
    {
        launch(args);
    }
    // ---------------------------------------------------------
    @Override
    public void start(Stage primaryStage)
    {
        // Instantiate labels
        questionLabel = new Label("Questions");
        answerLabel   = new Label("Answer Key");

        // Instantiate TextAreas
        questionArea = new TextArea(questions);
        answerArea   = new TextArea(answerKey);

        // Instantiate generateButton and set click action
        generateButton = new Button("Create Quiz");
        generateButton.setOnAction(e ->
        {
            // Initialize questions and answer key to null
            questions = "";
            answerKey = "";

            // Build the list of questions
            for (int i = 0; i < MAX_ARRAY_SIZE; i++)
            {
                newQuestion(quizItems, i);            // Select random quiz item
                do
                {
                    quizItems[i].generateQuestion();  // Generate question
                }
                while (questionIsUsed(quizItems, i)); // Re-generate questions while duplicate exists

                questions += (i + 1 + ". "  + quizItems[i].getQuestion() + "\n");  // Accumulate questions
                answerKey += (i + 1 + ". "  + quizItems[i].getAnswer() + "\n");    // Accumulate answers
            }
            questionArea.setText(questions);  // Show questions to user
            answerArea.setText("");           // Clear out answer key for new questions
        });

        // Instantiate showAnswerButton and set click action
        showAnswerButton = new Button("Show Answers");
        showAnswerButton.setOnAction(event ->
        {
            answerArea.setText(answerKey);  // Show answer key to user
        });

        // Set up main layout
        VBox questionBox = new VBox(10, questionLabel, questionArea, generateButton);
        VBox answerBox   = new VBox(10, answerLabel, answerArea, showAnswerButton);
        HBox mainBox     = new HBox(10, questionBox, answerBox);
        mainBox.setPadding(new Insets(20,20,20,20));

        // Set up overall scene
        Scene scene = new Scene(mainBox,800, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz");
        primaryStage.show();

    }

    // ------------------------------------------------------------------------
    // This method randomly selects from three different types of questions
    // and adds it to the quiz
    public static void newQuestion(QuizItem[] quizItem, int currentQuestion)
    {
        // Possible question types
        String[] questionTypes = {"Math Problem", "Word Scramble", "Trivia Question"};
        int      randomNum;

        // Random number for selecting a question
        randomNum = (int) (Math.random() * 3);

        // Switch uses random number to create a new question
        switch (questionTypes[randomNum])
        {
            case "Math Problem":
            {
                quizItem[currentQuestion] = new MathProblem();     // Create MathProblem object
                break;
            }
            case  "Word Scramble":
            {
                quizItem[currentQuestion] = new WordScramble();    // Create WordScramble object
                break;
            }
            case "Trivia Question":
            {
                quizItem[currentQuestion] = new TriviaQuestion();  // Create TriviaQuestion object
                break;
            }
        }
    }

    // ------------------------------------------------------------------------
    // This method checks to see if a questions has already been used
    public static boolean questionIsUsed(QuizItem[] quizItem, int currentQuestion)
    {
        boolean isUsed = false;

        // Loop through previous questions to see if question has been used
        for (int i = 0; i < currentQuestion; i++)
        {
            if (quizItem[currentQuestion].getAnswer().equals(quizItem[i].getAnswer()))
            {
                isUsed = true;
            }
        }
        return isUsed;
    }
}
