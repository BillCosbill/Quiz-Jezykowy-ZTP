package controller.question;

import controller.EndTestQuizController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import main.Main;
import model.question.ClosedQuestion;
import model.quiz.Quiz;
import model.quiz.TestQuiz;

import java.io.IOException;

public class TestClosedQestionController extends QuestionController {

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;

    public TestClosedQestionController(Quiz quiz) throws IOException {
        this.quiz = quiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/ClosedQuestionQuizView.fxml"));
        loader.setController(this);
        window = Main.window;
        window.setScene(new Scene(loader.load()));
        window.setTitle("Test " + quiz.getDictionaryProxy().getLevel().getName() + " - pytanie zamknięte");
        window.show();
    }

    @FXML
    @Override
    public void initialize() {
        super.initialize();
        String[] answerArray = ((ClosedQuestion) this.quiz.getCurrentQuestion()).toAnswerArray();

        buttonA.setText(answerArray[0]);
        buttonB.setText(answerArray[1]);
        buttonC.setText(answerArray[2]);
        buttonD.setText(answerArray[3]);
    }

    @Override
    public void next() throws Exception {
        if (quiz.getCurrentQuestionNumber() + 1 == 10) {
            new EndTestQuizController((TestQuiz) quiz);
        } else {
            super.next();
        }
    }

    public void checkA() throws Exception {
        if (buttonA.getText().equals(quiz.getCurrentQuestion().getCorrectAnswer())) {
            ((TestQuiz) (quiz)).incrementScore(1);
        }
        next();
    }

    public void checkB() throws Exception {
        if (buttonB.getText().equals(quiz.getCurrentQuestion().getCorrectAnswer())) {
            ((TestQuiz) (quiz)).incrementScore(1);
        }
        next();
    }

    public void checkC() throws Exception {
        if (buttonC.getText().equals(quiz.getCurrentQuestion().getCorrectAnswer())) {
            ((TestQuiz) (quiz)).incrementScore(1);
        }
        next();
    }

    public void checkD() throws Exception {
        if (buttonD.getText().equals(quiz.getCurrentQuestion().getCorrectAnswer())) {
            ((TestQuiz) (quiz)).incrementScore(1);
        }
        next();
    }
}
