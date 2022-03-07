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
    Label currentPlayerLabel = new Label("CURRENT PLAYER: ");
    currentPlayerLabel.setPrefWidth(120);
    HBox currentPlayerNameHBox = new HBox(currentPlayerLabel, new Label(currentPlayer.getName()));
    vbox.getChildren().add(currentPlayerNameHBox);
    Label currentPlayerSign = new Label("CURRENT SIGN: ");
    currentPlayerSign.setPrefWidth(120);
    HBox currentPlayerSignHBox = new HBox(currentPlayerSign, new Label(currentPlayer.getSign()));
    vbox.getChildren().add(currentPlayerSignHBox);
    Button restartButton = new Button("RESTART");
    restartButton.setOnMouseClicked((e) -> {
      this.app.loadSettingsPanel();
    });
    vbox.getChildren().add(restartButton);
    vbox.setAlignment(Pos.CENTER);
    vbox.setMaxWidth(150);
    vbox.setMinWidth(150);
    return vbox;
  }

  public VBox drawWinner() {
    Player currentPlayer = this.information.getCurrentPlayer();
    Label winnerLabel = new Label("WINNER IS: " + currentPlayer.getName());
    Button restartButton = new Button("RESTART");
    restartButton.setOnMouseClicked((e) -> {
      this.app.loadSettingsPanel();
    });
    VBox vbox = new VBox(winnerLabel, restartButton);
    vbox.setAlignment(Pos.CENTER);
    vbox.setMaxWidth(150);
    vbox.setMinWidth(150);
    return vbox;
  }
}
