package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.ranking.Ranking;

import java.io.FileNotFoundException;

public class RankingController {
    private Ranking rankingModel;

    @FXML
    private ListView list;

    @FXML
    public void initialize() throws FileNotFoundException {
        this.rankingModel = new Ranking();

        rankingModel.setList(list);
    }

    public void back() throws Exception {
        new MenuController();
    }

    public void reset() throws Exception {
        rankingModel.resetRanking();
        rankingModel.setList(list);
    }

    public void sortByPoints() {
        rankingModel.setSortingByPoints();
        rankingModel.setList(list);
    }

    public void sortByLevels() {
        rankingModel.setSortingByLevel();
        rankingModel.setList(list);
    }
}
