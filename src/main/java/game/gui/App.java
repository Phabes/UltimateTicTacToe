package game.gui;

import game.Board;
import game.Information;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
  private Board board = new Board();
  private Information information = new Information();

  @Override
  public void start(Stage primaryStage) throws Exception {
    HBox hbox = new HBox(this.board.getVbox(), this.information.getInfo());
    Scene worldScene = new Scene(hbox);
    primaryStage.setScene(worldScene);
    primaryStage.show();
  }
}
