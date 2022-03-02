package game.gui;

import game.Board;
import game.Information;
import game.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Visualization {
  private final App app;
  private final Board board;
  private final Information information;

  public Visualization(App app, Board board, Information information) {
    this.app = app;
    this.board = board;
    this.information = information;
  }

  public VBox drawBoard() {
    this.board.draw();
    return this.board.getVbox();
  }

  public VBox drawInfo() {
    VBox vbox = new VBox();
    Player currentPlayer = this.information.getCurrentPlayer();
    Label label1 = new Label("CURRENT PLAYER: ");
    label1.setPrefWidth(120);
    HBox hbox1 = new HBox(label1, new Label(currentPlayer.getName()));
    vbox.getChildren().add(hbox1);
    Label label2 = new Label("CURRENT SIGN: ");
    label2.setPrefWidth(120);
    HBox hbox2 = new HBox(label2, new Label(currentPlayer.getSign()));
    vbox.getChildren().add(hbox2);
    Button restart = new Button("RESTART");
    restart.setOnMouseClicked((e) -> {
      this.app.loadSettingsPanel();
    });
    vbox.getChildren().add(restart);
    vbox.setAlignment(Pos.CENTER);
    vbox.setMaxWidth(150);
    vbox.setMinWidth(150);
    return vbox;
  }

  public VBox drawWinner() {
    Player currentPlayer = this.information.getCurrentPlayer();
    Label label1 = new Label("WINNER IS: " + currentPlayer.getName());
    Button restart = new Button("RESTART");
    restart.setOnMouseClicked((e) -> {
      this.app.loadSettingsPanel();
    });
    VBox vbox = new VBox(label1, restart);
    vbox.setAlignment(Pos.CENTER);
    vbox.setMaxWidth(150);
    vbox.setMinWidth(150);
    return vbox;
  }
}
