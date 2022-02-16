package game;

import game.gui.App;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board {
  private VBox vbox = new VBox();
  private Information information;
  private BigSquare[][] bigSquares = new BigSquare[3][3];

  public Board(App app, Information information) {
    this.information = information;
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        this.bigSquares[y][x] = new BigSquare(y, x, information, app);
      }
    }
  }

  public VBox getVbox() {
    return this.vbox;
  }

  public void draw() {
    this.vbox = new VBox();
    for (BigSquare[] bigSquareRow : this.bigSquares) {
      HBox hbox = new HBox();
      for (BigSquare bigSquare : bigSquareRow) {
        bigSquare.draw();
        hbox.getChildren().add(bigSquare.getVbox());
        hbox.setSpacing(10);
      }
      this.vbox.getChildren().add(hbox);
    }
    this.vbox.setSpacing(10);
  }
}