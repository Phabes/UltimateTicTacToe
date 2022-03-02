package game;

import game.gui.App;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends Square {
  private final BigSquare[][] bigSquares = new BigSquare[3][3];

  public Board(App app, Information information) {
    this.y = 0;
    this.x = 0;
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        this.bigSquares[y][x] = new BigSquare(y, x, information, this, app);
      }
    }
  }

  public boolean checkNextBigSquare(int y, int x) {
    return this.bigSquares[y][x].checkIfWon();
  }

  public boolean checkWin(int i, int j, Player winner) {
    return super.checkWin(i, j, winner, this.bigSquares);
  }

  public void draw() {
    this.vbox = new VBox();
    for (BigSquare[] bigSquareRow : this.bigSquares) {
      HBox hbox = new HBox();
      for (BigSquare bigSquare : bigSquareRow) {
        if (!bigSquare.checkIfWon()) {
          bigSquare.draw();
          hbox.getChildren().add(bigSquare.getVbox());
        } else {
          Label label = new Label(bigSquare.getWinner().getSign());
          label.setStyle("-fx-font: 100 arial;");
          VBox box = new VBox(label);
          box.setPrefWidth(140);
          box.setPrefHeight(140);
          box.setAlignment(Pos.CENTER);
          hbox.getChildren().add(box);
        }
      }
      hbox.setSpacing(10);
      this.vbox.getChildren().add(hbox);
    }
    this.vbox.setSpacing(10);
  }
}