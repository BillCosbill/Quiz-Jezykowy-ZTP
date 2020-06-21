package controller.question;

import controller.QuizSelectController;
import controller.level.LearnQuizLevelSelectController;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.progress.Progress;
import model.question.ClosedQuestion;
import model.question.OpenedQuestion;
import model.quiz.LearnQuiz;
import model.quiz.Quiz;
import model.quiz.TestQuiz;

public abstract class QuestionController {
    public Stage window;
    public Text questionText;

    protected Quiz quiz;
    protected Progress progress;

    public QuestionController() {
        progress = Progress.getInstance();
    }

    @FXML
    public void initialize() {

        questionText.setText(quiz.getCurrentQuestion().getQuestionText());
    }

    public void next() throws Exception {
        quiz.nextQuestion();
        if (quiz.getCurrentQuestionNumber() >= quiz.getQuestions().size()) {
            progress.saveProgress();
            new LearnQuizLevelSelectController();
            return;
        }

        if (quiz instanceof LearnQuiz && quiz.getCurrentQuestion() instanceof ClosedQuestion)
            new LearnClosedQuestionController(quiz);
        else if (quiz instanceof LearnQuiz && quiz.getCurrentQuestion() instanceof OpenedQuestion)
            new LearnOpenQuestionController(quiz);
        else if (quiz instanceof TestQuiz && quiz.getCurrentQuestion() instanceof ClosedQuestion)
            new TestClosedQestionController(quiz);
        else if (quiz instanceof TestQuiz && quiz.getCurrentQuestion() instanceof OpenedQuestion)
            new TestOpenQuestionController(quiz);
    }

    //tej metody używają jedynie pytania LearnQuiz (otwarte i zamknięte)
    public void back() throws Exception {
        progress.saveProgress();
        new QuizSelectController();
    }
}
