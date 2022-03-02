package game;

import javafx.scene.layout.VBox;

public abstract class Square implements ISquare {
  protected VBox vbox = new VBox();
  protected Player winner = null;
  protected int y;
  protected int x;

  @Override
  public VBox getVbox() {
    return this.vbox;
  }

  @Override
  public void setWinner(Player winner) {
    this.winner = winner;
  }

  @Override
  public Player getWinner() {
    return this.winner;
  }

  @Override
  public boolean checkWin(int i, int j, Player winner, Square[][] squares) {
    int count = 0;
    for (int k = 0; k < 3; k++) {
      if (squares[k][k].getWinner() != null) {
        if (squares[k][k].getWinner().equals(winner))
          count++;
      }
    }
    if (count == 3)
      return true;
    count = 0;
    for (int k = 0; k < 3; k++) {
      if (squares[k][2 - k].getWinner() != null) {
        if (squares[k][2 - k].getWinner().equals(winner))
          count++;
      }
    }
    if (count == 3)
      return true;
    count = 0;
    for (int k = 0; k < 3; k++) {
      if (squares[i][k].getWinner() != null) {
        if (squares[i][k].getWinner().equals(winner))
          count++;
      }
    }
    if (count == 3)
      return true;
    count = 0;
    for (int k = 0; k < 3; k++) {
      if (squares[k][j].getWinner() != null) {
        if (squares[k][j].getWinner().equals(winner))
          count++;
      }
    }
    return count == 3;
  }

  @Override
  public boolean checkIfWon() {
    return this.winner != null;
  }
}
