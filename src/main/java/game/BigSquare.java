package game;

import game.gui.App;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BigSquare {
  private int whoWon = -1;
  private VBox vbox = new VBox();
  private int y;
  private int x;
  private Information information;
  private Player winner = null;
  private SmallSquare[][] smallSquares = new SmallSquare[3][3];

  public BigSquare(int y, int x, Information information, App app) {
    this.information = information;
    this.y = y;
    this.x = x;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.smallSquares[i][j] = new SmallSquare(y, x, i, j, information, this);
        this.smallSquares[i][j].addObserver(app);
      }
    }
  }

  public VBox getVbox() {
    return this.vbox;
  }

  public void draw() {
    this.vbox = new VBox();
    for (SmallSquare[] smallSquareRow : this.smallSquares) {
      HBox hbox = new HBox();
      for (SmallSquare smallSquare : smallSquareRow) {
        smallSquare.draw();
        hbox.getChildren().add(smallSquare.getVbox());
        hbox.setSpacing(5);
      }
      this.vbox.getChildren().add(hbox);
    }
    this.vbox.setSpacing(5);
  }

  public void checkWin(int i, int j, Player winner){
    boolean win = true;
    if(i==j){
      for(int k=0;k<3;k++){
        if(!smallSquares[k][k].getWinner().equals(winner))
          win=false;
      }
    }
    for(int k=0;k<3;k++){
      if(!smallSquares[i][k].getWinner().equals(winner))
        win=false;
    }
    for(int k=0;k<3;k++){
      if(!smallSquares[k][j].getWinner().equals(winner))
        win=false;
    }
    if (win) {
      this.winner = winner;
    }
  }
}
