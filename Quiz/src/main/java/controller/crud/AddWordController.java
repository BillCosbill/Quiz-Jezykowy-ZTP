package controller.crud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import main.MainLauncher;
import model.proxy.DictionaryProxy;
import model.Word;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class AddWordController {
    public Stage window;
    private DictionaryProxy dictionaryProxy;

    @FXML
    public TextField polishTextField, englishTextField;
    public Label resultLabel;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void addWord(ActionEvent actionEvent) throws IOException {
        String polishWord = polishTextField.getText();
        String englishWord = englishTextField.getText();
        Iterator<Word> it = dictionaryProxy.iterator();
        Word word;
        while (it.hasNext()) {
            word = it.next();
            if(word.getPolishWord().equals(polishWord) && word.getEnglishWord().equals(englishWord)){
                resultLabel.setText("Dane słowo już jest w słowniku!");
                return;
            }
        }
        if (polishTextField.getText().equals("") || englishTextField.getText().equals("")) {
            resultLabel.setText("Pola nie mogą być puste!");
        } else {
            FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(dictionaryProxy.getLevel().getName() + "dictionary")).getFile()), true);
            writer.write(englishTextField.getText() + "=" + polishTextField.getText() + "\n");
            resultLabel.setText("Dodano słowo.");
            writer.close();
            dictionaryProxy = new DictionaryProxy(dictionaryProxy.getLevel());
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/crud/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.setTitle("Menu słownika");
        window.show();
    }

    public void setDictionaryProxy(DictionaryProxy dictionaryProxy) {
        this.dictionaryProxy = dictionaryProxy;
    }
}
