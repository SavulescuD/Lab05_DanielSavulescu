package lab05_danielsavulescu.lab05_danielsavulescu;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
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
 * 
 * @author - Daniel Savulescu - 2540408
 * 
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        //Task 01
        var root = new BorderPane();
        var gridPane = new GridPane();
        root.setCenter(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        
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
        small.setUserData("Small");
        medium.setUserData("Medium");
        large.setUserData("Large");
        
        small.setToggleGroup(sizeGroup);
        medium.setToggleGroup(sizeGroup);
        large.setToggleGroup(sizeGroup);
        VBox vb = new VBox();
        vb.getChildren().add(small);
        vb.getChildren().add(medium);
        vb.getChildren().add(large);
        gridPane.add(vb, 1, 0);
        
        Label orderLbl = new Label();
        gridPane.add(orderLbl, 1, 2);
        
        Button orderBtn = new Button("Order");
        gridPane.add(orderBtn, 2, 0);
        
        orderBtn.setOnAction(event -> {
            if (bagsListView.getSelectionModel().getSelectedItem() == null || cbBags.getSelectionModel().getSelectedItem() == null || sizeGroup.getSelectedToggle().getUserData().toString() == null) {
                orderLbl.setText("Please select an item");
            }
            
            String listViewChoice = bagsListView.getSelectionModel().getSelectedItem();
            String cbBagsChoice = cbBags.getSelectionModel().getSelectedItem();
            String sizeGroupChoice = sizeGroup.getSelectedToggle().getUserData().toString();
                    
            String finalOrder = String.format("You ordered %s %s %s", sizeGroupChoice, cbBagsChoice, listViewChoice);
            orderLbl.setText(finalOrder);
        });
        
        Button clearBtn = new Button("Reset");
        gridPane.add(clearBtn, 2, 1);
        
        clearBtn.setOnAction(event -> {
            orderLbl.setText("");
            bagsListView.getSelectionModel().clearSelection();
            cbBags.getSelectionModel().clearSelection();
            sizeGroup.selectToggle(null);
        });
        
        Scene scene = new Scene(root, 600, 350);
        stage.setScene(scene);
        stage.setTitle("Main Window");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
