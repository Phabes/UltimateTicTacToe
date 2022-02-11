package game;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BigSquare {
  private int whoWon = -1;
  private VBox vbox;
  private int y;
  private int x;

  public BigSquare(int y, int x){
    this.y=y;
    this.x=x;
    this.vbox = new VBox();
    for(int i=0;i<3;i++){
      HBox hbox = new HBox();
      for(int j=0;j<3;j++){
        SmallSquare smallSquare = new SmallSquare(y,x,i,j);
        hbox.getChildren().add(smallSquare.getVbox());
        hbox.setSpacing(5);
      }
      vbox.getChildren().add(hbox);
      vbox.setSpacing(5);
    }
  }

  public VBox getVbox(){
    return this.vbox;
  }
}
