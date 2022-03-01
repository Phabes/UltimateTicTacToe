package game.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class SettingsPanel {
  private final VBox vbox = new VBox();

  public SettingsPanel(App app) {
    Label label1 = new Label("First Player Name (O): ");
    label1.setPrefWidth(150);
    TextField textField1 = new TextField();
    HBox hbox1 = new HBox(label1, textField1);
//    hbox1.setPrefWidth(300);
    hbox1.setAlignment(Pos.CENTER);
    Label label2 = new Label("Second Player Name (X): ");
    label2.setPrefWidth(150);
    TextField textField2 = new TextField();
    HBox hbox2 = new HBox(label2, textField2);
//    hbox2.setPrefWidth(300);
    hbox2.setAlignment(Pos.CENTER);
    Button start = new Button("START");
    start.setOnMouseClicked((e) -> {
      if (!Objects.equals(textField1.getText(), textField2.getText()) &&!Objects.equals(textField1.getText(), "") && !Objects.equals(textField2.getText(), ""))
        app.loadGame(textField1.getText(), textField2.getText());
    });
    this.vbox.getChildren().addAll(hbox1, hbox2, start);
    this.vbox.setAlignment(Pos.CENTER);
    this.vbox.setSpacing(10);
  }

  public VBox getVbox() {
    return this.vbox;
  }
}
