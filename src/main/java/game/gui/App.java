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
  private Player p1 = new Player("PLAYER1", "O");
  private Player p2 = new Player("PLAYER2", "X");
  private Information information = new Information(p1, p2);
  private Board board = new Board(this, information);
  private Visualization visualization;
  private GridPane grid = new GridPane();

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.visualization = new Visualization(this.board);
//    HBox hbox = new HBox(this.board.getVbox(), this.information.getInfo());
//    Scene worldScene = new Scene(hbox);
    this.grid.add(visualization.draw(), 0, 0);
    Scene worldScene = new Scene(this.grid);
    primaryStage.setScene(worldScene);
    primaryStage.show();
  }

  public void refreshBoard() {
    Platform.runLater(() -> {
      this.grid.getChildren().clear();
      this.grid.add(visualization.draw(), 0, 0);
    });
  }
}
