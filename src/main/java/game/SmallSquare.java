package game;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SmallSquare {
  private VBox vbox;
  private int y;
  private int x;
  private int i;
  private int j;

  public SmallSquare(int y, int x, int i, int j){
    this.y=y;
    this.x=x;
    this.i=i;
    this.j=j;
    this.vbox = new VBox();
    Label label = new Label("X");
    this.vbox.getChildren().add(label);
    this.vbox.setPrefWidth(40);
    this.vbox.setPrefHeight(40);
    this.vbox.setAlignment(Pos.CENTER);
    this.vbox.setStyle("-fx-background-color: #818582;");
    this.vbox.setOnMouseClicked((e)->{
      System.out.println(y+" "+x+" "+i+" "+j);
    });
  }

  public VBox getVbox(){
    return this.vbox;
  }
}
