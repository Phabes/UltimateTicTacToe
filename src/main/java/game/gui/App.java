package game.gui;

import game.Board;
import game.Information;
import game.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class App extends Application {
  //  private Player p1 = new Player("PLAYER1", "O");
//  private Player p2 = new Player("PLAYER2", "X");
//  private Information information = new Information(p1, p2);
//private Board board = new Board(this, information);
  private Information information;
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
    this.stage.setScene(worldScene);
    this.stage.show();
  }

  public void loadGame(String firstPlayerName, String secondPlayerName) {
    Player p1 = new Player(firstPlayerName, "O");
    Player p2 = new Player(secondPlayerName, "X");
    this.information = new Information(p1, p2);
    this.board = new Board(this, this.information);
    this.visualization = new Visualization(this, this.board, this.information);
    this.grid = new GridPane();
    this.grid.setVgap(20);
    this.grid.setHgap(20);
    this.grid.add(this.visualization.drawBoard(), 0, 0);
    this.grid.add(this.visualization.drawInfo(), 1, 0);
    Scene worldScene = new Scene(this.grid);
    this.stage.setScene(worldScene);
    this.stage.show();
  }

  public void refreshBoard() {
    Platform.runLater(() -> {
      this.grid.getChildren().clear();
      this.grid.add(this.visualization.drawBoard(), 0, 0);
      this.grid.add(this.visualization.drawInfo(), 1, 0);
    });
  }
}
