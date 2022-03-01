package game;

import javafx.scene.layout.VBox;

public abstract class Square implements ISquare {
  // TO BEDZIE KLASA NADRZEDNA DO BISQUARE I SMALLSQUARE (BIGSQUARE I SMALL SQUARE BEDA DZIEDZICZYC Z TEJ KLASY)
  // LUB INTERFEJS ALBO OBA
  // TRZEBA METODE CHECKWIN DAC DO KLASY NADRZEDNEJ A JAKIES INNE FUNCKJE DODAC DO INTERFEJSU
  protected VBox vbox = new VBox();
  protected int y;
  protected int x;
  protected Player winner = null;

  @Override
  public VBox getVbox() {
    return this.vbox;
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
        if (squares[k][k].getWinner().equals(winner)) {
          count++;
        }
      }
    }
    if (count == 3) {
      this.winner = winner;
      return true;
    }
    count = 0;
    for (int k = 0; k < 3; k++) {
      if (squares[k][2 - k].getWinner() != null) {
        if (squares[k][2 - k].getWinner().equals(winner)) {
          count++;
        }
      }
    }
    if (count == 3) {
      this.winner = winner;
      return true;
    }
    count = 0;
    for (int k = 0; k < 3; k++) {
      if (squares[i][k].getWinner() != null) {
        if (squares[i][k].getWinner().equals(winner)) {
          count++;
        }
      }
    }
    if (count == 3) {
      this.winner = winner;
      return true;
    }
    count = 0;
    for (int k = 0; k < 3; k++) {
      if (squares[k][j].getWinner() != null) {
        if (squares[k][j].getWinner().equals(winner)) {
          count++;
        }
      }
    }
    if (count == 3) {
      this.winner = winner;
      return true;
    }
    return false;
  }
}
