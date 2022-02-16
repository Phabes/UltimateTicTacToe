package game;

import game.gui.App;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class SmallSquare {
  private VBox vbox = new VBox();
  private Label label = new Label();
  private int y;
  private int x;
  private int i;
  private int j;
  private Information information;
  private Player winner = null;
  private BigSquare bigSquare;
  private final List<App> observers = new ArrayList<>();

  public SmallSquare(int y, int x, int i, int j, Information information, BigSquare bigSquare) {
    this.y = y;
    this.x = x;
    this.i = i;
    this.j = j;
    this.information = information;
    this.bigSquare = bigSquare;
  }

  public VBox getVbox() {
    return this.vbox;
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
      System.out.println(y + " " + x + " " + i + " " + j + " " + this.canBeTouched());
      if (this.canBeTouched()) {
        for (App gui : this.observers) {
          gui.refreshBoard();
        }
        this.winner = this.information.getCurrentPlayer();
        this.information.changePlayer();
        this.bigSquare.checkWin(i,j, this.winner);
        this.chooseNewXY(i,j);
      }
    });
  }

  private void chooseNewXY(int i, int j){
    //TUTAJ TRZEBA WYBRA NOWA POZYCJE W KTOREJ DRUGI GRACZ MA RUCH, TAKZE CALE BOARD TRZEBA TU PRZEKAZAC
  }


  public void addObserver(App gui) {
    this.observers.add(gui);
  }

  public Player getWinner() {
    return winner;
  }

  public boolean canBeTouched() {
    if (this.winner != null)
      return false;
    if (this.information.getCurrentY() == this.y && this.information.getCurrentX() == this.x)
      return true;
    if (this.information.getCurrentY() == -1 && this.information.getCurrentX() == -1)
      return true;
    return false;
  }
}
