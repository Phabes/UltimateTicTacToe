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
    Label p1NameLabel = new Label("First Player Name (O): ");
    p1NameLabel.setPrefWidth(150);
    TextField p1Name = new TextField();
    HBox p1HBox = new HBox(p1NameLabel, p1Name);
    p1HBox.setAlignment(Pos.CENTER);
    Label p2NameLabel = new Label("Second Player Name (X): ");
    p2NameLabel.setPrefWidth(150);
    TextField p2Name = new TextField();
    HBox p2HBox = new HBox(p2NameLabel, p2Name);
    p2HBox.setAlignment(Pos.CENTER);
    Button startButton = new Button("START");
    startButton.setOnMouseClicked((e) -> {
      if (!Objects.equals(p1Name.getText(), p2Name.getText()) && !Objects.equals(p1Name.getText(), "") && !Objects.equals(p2Name.getText(), ""))
        app.loadGame(p1Name.getText(), p2Name.getText());
    });
    this.vbox.getChildren().addAll(p1HBox, p2HBox, startButton);
    this.vbox.setAlignment(Pos.CENTER);
    this.vbox.setSpacing(10);
  }

  public VBox getVbox() {
    return this.vbox;
  }
}
