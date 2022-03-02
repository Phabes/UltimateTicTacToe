package game.gui;

import game.Board;
import game.Information;
import game.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application {
  private Board board;
  private Visualization visualization;
  private GridPane grid;
  private Stage stage;

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.stage = primaryStage;
    this.loadSettingsPanel();
  }

  public void loadSettingsPanel() {
    SettingsPanel settingsPanel = new SettingsPanel(this);
    Scene worldScene = new Scene(settingsPanel.getVbox());
    this.stage.setTitle("Settings");
    this.stage.setScene(worldScene);
    this.stage.show();
  }

  public void loadGame(String firstPlayerName, String secondPlayerName) {
    Player p1 = new Player(firstPlayerName, "O");
    Player p2 = new Player(secondPlayerName, "X");
    p1.setNextPlayer(p2);
    p2.setNextPlayer(p1);
    Information information = new Information(p1);
    this.board = new Board(this, information);
    this.visualization = new Visualization(this, this.board, information);
    this.grid = new GridPane();
    this.grid.setVgap(20);
    this.grid.setHgap(20);
    this.grid.add(this.visualization.drawBoard(), 0, 0);
    this.grid.add(this.visualization.drawInfo(), 1, 0);
    Scene worldScene = new Scene(this.grid);
    this.stage.setTitle("Game");
    this.stage.setScene(worldScene);
    this.stage.show();
  }

  public void refreshBoard() {
    Platform.runLater(() -> {
      this.grid.getChildren().clear();
      this.grid.add(this.visualization.drawBoard(), 0, 0);
      if (this.board.checkIfWon())
        this.grid.add(this.visualization.drawWinner(), 1, 0);
      else
        this.grid.add(this.visualization.drawInfo(), 1, 0);
    });
  }
}
