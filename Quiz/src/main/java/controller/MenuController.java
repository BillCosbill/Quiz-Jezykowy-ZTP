package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;

public class MenuController {
    public Stage window;

    public Button quizSelectButton;
    public Button rankingButton;
    public Button dictionaryButton;
    public Button exitButton;

    public MenuController() throws IOException {
        window = Main.window;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuView.fxml"));
        loader.setController(this);
        window.setTitle("Menu główne");
        window.setScene(new Scene(loader.load()));
        window.show();
    }

    public void quizSelect(ActionEvent actionEvent) throws Exception {
        new QuizSelectController();
    }

    public void ranking(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/RankingView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void dictionary(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/crud/DictionaryLevelSelectView.fxml"));
        window.setScene(new Scene(root));
        window.setTitle("Wybierz poziom zaawansowania");
        window.show();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(1);
    }

}
