package game;

import game.gui.App;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends Square{
//  private VBox vbox = new VBox();
  private Information information;
//  private Player winner = null;
  private BigSquare[][] bigSquares = new BigSquare[3][3];

  public Board(App app, Information information) {
    this.information = information;
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        this.bigSquares[y][x] = new BigSquare(y, x, information, this, app);
      }
    }
  }

//  public VBox getVbox() {
//    return this.vbox;
//  }

  public void draw() {
    this.vbox = new VBox();
    for (BigSquare[] bigSquareRow : this.bigSquares) {
      HBox hbox = new HBox();
      for (BigSquare bigSquare : bigSquareRow) {
        if (!bigSquare.checkIfWon()) {
          bigSquare.draw();
          hbox.getChildren().add(bigSquare.getVbox());
        } else {
          VBox box = new VBox(new Label(bigSquare.getWinner().getSign()));
          box.setPrefWidth(129);
          box.setPrefHeight(129);
          box.setAlignment(Pos.CENTER);
          hbox.getChildren().add(box);
        }
        hbox.setSpacing(10);
      }
      this.vbox.getChildren().add(hbox);
    }
    this.vbox.setSpacing(10);
  }

  public boolean checkBigSquareWin(int y, int x) {
    return this.bigSquares[y][x].checkIfWon();
  }

  public boolean checkWin(int i, int j, Player winner) {
    return super.checkWin(i,j,winner,this.bigSquares);
  }
}