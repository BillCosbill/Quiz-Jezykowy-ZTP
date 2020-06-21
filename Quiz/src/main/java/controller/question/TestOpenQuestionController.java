package controller.question;

import controller.EndTestQuizController;
import controller.QuizSelectController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import main.Main;
import model.quiz.Quiz;
import model.quiz.TestQuiz;

import java.io.IOException;

public class TestOpenQuestionController extends QuestionController {

    @FXML
    public TextField answerTextField;

    public TestOpenQuestionController(Quiz quiz) throws IOException {
        this.quiz = quiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/OpenedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Test " + quiz.getDictionaryProxy().getLevel().getName() + " - pytanie otwarte");
        this.window.show();
    }

    @Override
    public void next() throws Exception {
        if (answerTextField.getText().equals(quiz.getCurrentQuestion().getCorrectAnswer())) {
            ((TestQuiz) (quiz)).incrementScore(1);
        }
        if (quiz.getCurrentQuestionNumber() + 1 == 10) {
            new EndTestQuizController((TestQuiz) quiz);
        } else {
            super.next();
        }
    }

    public void back() throws Exception {
        new QuizSelectController();
    }
}
