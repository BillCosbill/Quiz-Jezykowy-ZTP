package controller;

import controller.level.LearnQuizLevelSelectController;
import controller.level.TestQuizLevelSelectController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;

public class QuizSelectController {
    public Stage window;

    public Button returnButton;
    public Button learningButton;
    public Button testButton;

    public QuizSelectController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/QuizSelectView.fxml"));
        loader.setController(this);
        window = Main.window;
        window.setScene(new Scene(loader.load()));
        window.setTitle("Wybór rodzaju quizu");
        window.show();
    }

    public void back() throws Exception {
        new MenuController();
    }

    public void learnQuizLevelSelect() throws Exception {
        new LearnQuizLevelSelectController();
    }

    public void testQuizLevelSelect() throws Exception {
        new TestQuizLevelSelectController();
    }
}
