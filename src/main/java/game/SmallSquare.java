package game;

import game.gui.App;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class SmallSquare extends Square {
  private Label label = new Label();
  private int i;
  private int j;
  private Information information;
  private BigSquare bigSquare;
  private Board board;
  private final List<App> observers = new ArrayList<>();

  public SmallSquare(int y, int x, int i, int j, Information information, Board board, BigSquare bigSquare) {
    this.y = y;
    this.x = x;
    this.i = i;
    this.j = j;
    this.information = information;
    this.board = board;
    this.bigSquare = bigSquare;
  }

  public void draw() {
    this.vbox = new VBox();
    this.vbox.setPrefWidth(40);
    this.vbox.setPrefHeight(40);
    this.vbox.setAlignment(Pos.CENTER);
    this.vbox.setStyle("-fx-background-color: #818582;");
    String str = "";
    if (this.winner != null)
      str = this.winner.getSign();
    Label label = new Label(str);
    this.vbox.getChildren().add(label);
    this.vbox.setOnMouseClicked((e) -> {
//      System.out.println(y + " " + x + " " + i + " " + j + " " + this.canBeTouched());
      if (this.canBeTouched()) {
        for (App gui : this.observers) {
          gui.refreshBoard();
        }
        this.winner = this.information.getCurrentPlayer();
        this.information.changePlayer();
        if (this.bigSquare.checkWin(this.i, this.j, this.winner)) {
          if (!this.board.checkWin(this.y, this.x, this.winner)) {
            this.chooseNewXY(-1, -1);
//          System.out.println(this.winner.getName() + " " + this.y + " " + this.x);
          } else {
            System.out.println("WINNER IS " + this.winner.getName());
          }
        } else {
          if (!this.board.checkBigSquareWin(this.i, this.j))
            this.chooseNewXY(this.i, this.j);
          else {
            this.chooseNewXY(-1, -1);
          }
        }
      }
    });
  }

  private void chooseNewXY(int y, int x) {
    this.information.setCurrentY(y);
    this.information.setCurrentX(x);
  }


  public void addObserver(App gui) {
    this.observers.add(gui);
  }

  public boolean canBeTouched() {
    if (this.board.checkBigSquareWin(this.y, this.x))
      return false;
    if (this.winner != null)
      return false;
    if (this.information.getCurrentY() == this.y && this.information.getCurrentX() == this.x)
      return true;
    if (this.information.getCurrentY() == -1 && this.information.getCurrentX() == -1)
      return true;
    return false;
  }
}
