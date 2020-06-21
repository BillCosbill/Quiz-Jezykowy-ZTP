package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.Main;
import model.quiz.TestQuiz;

import java.io.IOException;

public class EndTestQuizController {
    public Stage window;
    @FXML
    public Label scoreLabel;
    private TestQuiz testQuiz;

    public EndTestQuizController(TestQuiz testQuiz) throws IOException {
        this.testQuiz = testQuiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/EndTestQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        testQuiz.updateScore();
        this.window.setTitle("Wyniki testu");
        this.window.show();
    }

    @FXML
    public void initialize() {
        this.window = Main.window;
        this.scoreLabel.setText(testQuiz.getScore() + "/" + (testQuiz.getQuestions().size()));
    }

    public void back() throws Exception {
        new QuizSelectController();
    }
}
