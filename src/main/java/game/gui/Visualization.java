package game.gui;

import game.Board;
import javafx.scene.layout.VBox;

public class Visualization {
  private Board board;

  public Visualization(Board board) {
    this.board = board;
  }

  public VBox draw() {
    this.board.draw();
    return this.board.getVbox();
  }
}
