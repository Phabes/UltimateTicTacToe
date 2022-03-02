package game;

import javafx.scene.layout.VBox;

public interface ISquare {
  VBox getVbox();

  Player getWinner();

  void setWinner(Player winner);

  boolean checkWin(int i, int j, Player winner, Square[][] squares);

  boolean checkIfWon();

  void draw();
}
