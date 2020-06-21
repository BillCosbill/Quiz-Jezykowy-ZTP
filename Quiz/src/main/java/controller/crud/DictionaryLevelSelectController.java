package controller.crud;

import controller.MenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;

public class DictionaryLevelSelectController {
    public Stage window;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void dictionaryCrud(ActionEvent actionEvent) throws IOException {
        String selectedLevel = ((Button) actionEvent.getSource()).getText();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/crud/DictionaryView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        DictionaryController controller = fxmlLoader.<DictionaryController>getController();
        controller.setLevel(selectedLevel);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Menu słownika");
        window.show();
    }

    public void back(ActionEvent actionEvent) throws IOException {
        new MenuController();
    }

}
