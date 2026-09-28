package lab05_danielsavulescu.lab05_danielsavulescu;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        var root = new BorderPane();
        var gridPane = new GridPane();
        root.setCenter(gridPane);
        
        ListView<String> bagsListView = new ListView<>();
        String[] bagItems = {"Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain"};
        bagsListView.setItems(FXCollections.observableArrayList(bagItems));
        gridPane.add(bagsListView, 0, 0);
        
        ComboBox<String> cbBags = new ComboBox<>();
        cbBags.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        gridPane.add(cbBags, 1, 1);
        
        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton small = new RadioButton("Small");
        RadioButton medium = new RadioButton("Medium");
        RadioButton large = new RadioButton("Large");
        small.setToggleGroup(sizeGroup);
        medium.setToggleGroup(sizeGroup);
        large.setToggleGroup(sizeGroup);
        VBox vb = new VBox();
        vb.getChildren().add(small);
        vb.getChildren().add(medium);
        vb.getChildren().add(large);
        gridPane.add(vb, 1, 0);
        
        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.setTitle("Main Window");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
