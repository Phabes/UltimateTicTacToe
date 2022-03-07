package game;

import game.gui.App;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class SmallSquare extends Square {
  private final int i;
  private final int j;
  private final Information information;
  private final BigSquare bigSquare;
  private final Board board;
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

  private void chooseNewXY(int y, int x) {
    this.information.setCurrentY(y);
    this.information.setCurrentX(x);
  }

  public void addObserver(App gui) {
    this.observers.add(gui);
  }

  public boolean canBeTouched() {
    if (this.board.checkIfWon())
      return false;
    if (this.bigSquare.checkIfWon())
      return false;
    if (this.checkIfWon())
      return false;
    if (this.information.getCurrentY() == this.y && this.information.getCurrentX() == this.x)
      return true;
    return this.information.getCurrentY() == -1 && this.information.getCurrentX() == -1;
  }

  public void draw() {
    this.vbox = new VBox();
    this.setVBoxSize();
    this.vbox.setAlignment(Pos.CENTER);
    this.vbox.setStyle("-fx-background-color: #818582;");
    String sign = "";
    if (this.checkIfWon())
      sign = this.winner.getSign();
    Label signLabel = new Label(sign);
    signLabel.setStyle("-fx-font: 40 arial;");
    this.vbox.getChildren().add(signLabel);
    this.vbox.setOnMouseClicked((e) -> {
      if (this.canBeTouched()) {
        this.winner = this.information.getCurrentPlayer();
        this.information.changePlayer();
        if (this.bigSquare.checkWin(this.i, this.j, this.winner)) {
          this.bigSquare.setWinner(this.winner);
          if (this.board.checkWin(this.y, this.x, this.winner))
            this.board.setWinner(this.winner);
        }
        if (!this.board.checkIfWon() && !this.board.checkNextBigSquare(this.i, this.j))
          this.chooseNewXY(this.i, this.j);
        else
          this.chooseNewXY(-1, -1);
        if (this.board.checkIfWon())
          this.chooseNewXY(-1, -1);
        for (App gui : this.observers) {
          gui.refreshBoard();
        }
      }
    });
  }

  private void setVBoxSize() {
    this.vbox.setPrefWidth(40);
    this.vbox.setPrefHeight(40);
    this.vbox.setMinWidth(40);
    this.vbox.setMinHeight(40);
    this.vbox.setMaxWidth(40);
    this.vbox.setMaxHeight(40);
  }
}
