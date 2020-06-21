package controller.level;

import controller.QuizSelectController;
import controller.question.LearnClosedQuestionController;
import controller.question.LearnOpenQuestionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;
import model.proxy.DictionaryProxy;
import model.progress.Level;
import model.question.OpenedQuestion;
import model.quiz.LearnQuiz;

import java.io.IOException;

public class LearnQuizLevelSelectController {
    public Stage window;
    private String selectedLevel;
    private DictionaryProxy dictionaryProxy;
    //private Progress progress;

    public LearnQuizLevelSelectController() throws IOException {
        //this.progress = Progress.getInstance();
        this.selectedLevel = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/LearnQuizLevelSelectView.fxml"));
        loader.setController(this);
        window = Main.window;
        window.setScene(new Scene(loader.load()));
        window.setTitle("Wybór poziomu nauki");
        window.show();
    }

    public DictionaryProxy getDictionaryProxy() {
        return dictionaryProxy;
    }

    public void startLearnQuiz(ActionEvent actionEvent) throws Exception {
        this.selectedLevel = ((Button) actionEvent.getSource()).getText();
        this.dictionaryProxy = new DictionaryProxy(new Level(this.selectedLevel));

        LearnQuiz learnQuiz = new LearnQuiz(dictionaryProxy, 20);
        if (learnQuiz.getCurrentQuestion() instanceof OpenedQuestion) {
            new LearnOpenQuestionController(learnQuiz);
        } else {
            new LearnClosedQuestionController(learnQuiz);
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        new QuizSelectController();
    }
}
