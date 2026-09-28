package lab05_danielsavulescu.lab05_danielsavulescu;

import java.util.Map;
import java.util.TreeMap;
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
import javafx.scene.control.Slider;
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
        cbBags.setPromptText("Number of items");
        
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
        
        Scene scene1 = new Scene(root, 600, 350);
        stage.setScene(scene1);
        
        //Task 02
        Button nextTask = new Button("Next Task ->");
        gridPane.add(nextTask, 2, 2);
        
        var root2 = new BorderPane();
        var gridPane2 = new GridPane();
        gridPane2.setGridLinesVisible(true);
        VBox choices = new VBox();
        gridPane2.add(choices, 1, 0);
        root2.setCenter(gridPane2);
        gridPane2.setAlignment(Pos.CENTER);
        VBox choicesStrsVb = new VBox();
        Label[] choicesStrs = {new Label("Beverages: "), new Label("Appetizers: "), new Label("Main Courses: "), new Label("Desserts: ")};
        choicesStrsVb.getChildren().addAll(choicesStrs);
        gridPane2.add(choicesStrsVb, 0, 0);
        choicesStrsVb.setSpacing(8);
        
        ComboBox<String> beverageCb = new ComboBox<String>();
        beverageCb.setPromptText("Beverages");
        Map<String, Double> beverages = new TreeMap<>();
        beverages.put("Juice", 2.50);
        beverages.put("Coffee", 2.50);
        beverages.put("Milk", 1.50);
        beverageCb.getItems().setAll(beverages.keySet());
        choices.getChildren().add(beverageCb);
        
        ComboBox<String> appetizerCb = new ComboBox<String>();
        appetizerCb.setPromptText("Appetizer");
        Map<String, Double> appetizers = new TreeMap<>();
        appetizers.put("Garlic Bread", 3.00);
        appetizers.put("Garlic Bread", 3.00);
        appetizers.put("Chips & Salsa", 6.95);
        appetizerCb.getItems().addAll(appetizers.keySet());
        choices.getChildren().add(appetizerCb);
        
        ComboBox<String> mainCourseCb = new ComboBox<String>();
        mainCourseCb.setPromptText("Main course");
        Map<String, Double> mainCourses = new TreeMap<>();
        mainCourses.put("Steak", 15.00);
        mainCourses.put("Grilled Chicken", 13.50);
        mainCourses.put("Pasta", 11.75);
        mainCourseCb.getItems().addAll(mainCourses.keySet());
        choices.getChildren().add(mainCourseCb);
        
        ComboBox<String> dessertCb = new ComboBox<String>();
        dessertCb.setPromptText("Dessert");
        Map<String, Double> desserts = new TreeMap<>();
        desserts.put("Mud Pie", 4.75);
        desserts.put("Carrot Cake", 4.50);
        desserts.put("Pudding", 3.25);
        dessertCb.getItems().addAll(desserts.keySet());
        choices.getChildren().add(dessertCb);
        
        Slider slider = new Slider(0.0, 20.0, 15.0);
        
        Scene scene2 = new Scene(root2, 600, 350);
        nextTask.setOnAction(event -> {
            stage.setScene(scene2);
        });
        
        stage.setTitle("Main Window");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
