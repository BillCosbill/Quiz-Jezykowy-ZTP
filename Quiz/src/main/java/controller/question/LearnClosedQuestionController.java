package controller.question;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;
import model.question.ClosedQuestion;
import model.quiz.Quiz;

import java.io.IOException;

public class LearnClosedQuestionController extends QuestionController {

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;
    public Label respondLabel;

    public LearnClosedQuestionController(Quiz quiz) throws IOException {
        super();
        this.quiz = quiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/ClosedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Nauka słówek " + quiz.getDictionaryProxy().getLevel().getName() + " - pytanie zamknięte");
        this.window.show();
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

    public void checkAnswer(ActionEvent actionEvent) {
        if (((Button) actionEvent.getSource()).getText().equals(quiz.getCurrentQuestion().getCorrectAnswer())) {
            respondLabel.setText("Poprawna odpowiedź");
            progress.updateProgressLevel(quiz.getDictionaryProxy().getLevel(), quiz.getCurrentQuestion().getCorrectWord(), +1);
        } else {
            respondLabel.setText("Błędna odpowiedź");
            progress.updateProgressLevel(quiz.getDictionaryProxy().getLevel(), quiz.getCurrentQuestion().getCorrectWord(), -2);
        }

    }
}
