package game;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board {
  private VBox vbox;

  public Board(){
    this.vbox = new VBox();
    for(int y=0;y<3;y++){
      HBox hbox = new HBox();
      for(int x=0;x<3;x++){
        BigSquare bigSquare = new BigSquare(y,x);
        hbox.getChildren().add(bigSquare.getVbox());
        hbox.setSpacing(10);
      }
      vbox.getChildren().add(hbox);
    }
    vbox.setSpacing(10);
  }

  public VBox getVbox(){
    return this.vbox;
  }
}