package game;

import game.gui.App;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BigSquare extends Square {
  private Information information;
  private Board board;
  private SmallSquare[][] smallSquares = new SmallSquare[3][3];

  public BigSquare(int y, int x, Information information, Board board, App app) {
    this.information = information;
    this.y = y;
    this.x = x;
    this.board = board;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.smallSquares[i][j] = new SmallSquare(y, x, i, j, information, board, this);
        this.smallSquares[i][j].addObserver(app);
      }
    }
  }

  public void draw() {
    this.vbox = new VBox();
    for (SmallSquare[] smallSquareRow : this.smallSquares) {
      HBox hbox = new HBox();
      for (SmallSquare smallSquare : smallSquareRow) {
        smallSquare.draw();
        hbox.getChildren().add(smallSquare.getVbox());
      }
      hbox.setSpacing(5);
      this.vbox.getChildren().add(hbox);
    }
    this.vbox.setPadding(new Insets(5,5,5,5));
    this.vbox.setSpacing(5);
    if (this.y == this.information.getCurrentY() && this.x == this.information.getCurrentX()) {
      this.vbox.setStyle("-fx-background-color: #5aed58;");
    }
  }

  public boolean checkWin(int i, int j, Player winner) {
    return super.checkWin(i,j,winner,this.smallSquares);
  }

  public boolean checkIfWon() {
    if (this.winner != null)
      return true;
    return false;
  }
}
