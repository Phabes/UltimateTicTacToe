package game;

import javafx.scene.layout.VBox;

public interface ISquare {
  VBox getVbox();

  void draw();

  boolean checkWin(int i, int j, Player winner, Square[][] squares);

  Player getWinner();
}
