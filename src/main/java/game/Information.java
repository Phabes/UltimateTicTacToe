package game;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Information {
  private VBox vbox;
  private String player= "1";

  public Information(){
    Label label = new Label(player);
    this.vbox = new VBox(label);
  }

  public VBox getInfo(){
    return this.vbox;
  }
}
