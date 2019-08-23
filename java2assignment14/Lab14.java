/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/11/19
    Project: Assignment 14
    Description: Generics
 */
package java2assignment14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Lab14 extends Application {
    
    Label Type1Label = new Label();
    Label Value1Label = new Label();
    Label Type2Label= new Label();
    Label Value2Label = new Label();
    Label Type3Label = new Label();
    Label Value3Label = new Label();
    Label displayLabel = new Label("Hello\nThis is Label");
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        
        //Integer type
        setPairInteger(4,5);
        Type1Label.setTextFill(Color.RED);
        Value1Label.setTextFill(Color.RED);
        pane.add(Type1Label, 0, 0);
        pane.add(Value1Label, 0, 1);
        pane.addRow(2, new Label());
        
        //Double type
        setPairDouble(4.567, 3.234);
        Type2Label.setTextFill(Color.BLUE);
        Value2Label.setTextFill(Color.BLUE);
        pane.add(Type2Label, 0, 3);
        pane.add(Value2Label, 0, 4);
        pane.addRow(5, new Label());
        
        //String type
        setPairString("ABC", "DEF");
        Type3Label.setTextFill(Color.BLUEVIOLET);
        Value3Label.setTextFill(Color.BLUEVIOLET);
        pane.add(Type3Label, 0, 6);
        pane.add(Value3Label, 0, 7);
        
        Scene scene = new Scene(pane, 250, 250);
        
        primaryStage.setTitle("Generics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void setPairInteger(Integer firstCoord, Integer secondCoord)
    {
        Pair <Integer, Integer> p = new Pair <Integer,Integer> (firstCoord, secondCoord);
        Type1Label.setText("Type: Integer");
        Value1Label.setText("Value: " + p.getFirst() + ", " + p.getSecond());
    }
    public void setPairDouble(Double firstCoord, Double secondCoord)
    {
        Pair <Double, Double> p = new Pair <Double,Double> (firstCoord, secondCoord);
        Type2Label.setText("Type: Double");
        Value2Label.setText("Value: " + p.getFirst() + ", " + p.getSecond());
    }
    public void setPairString(String firstCoord, String secondCoord)
    {
        Pair <String, String> p = new Pair <String,String> (firstCoord, secondCoord);
        Type3Label.setText("Type: String");
        Value3Label.setText("Value: " + p.getFirst() + ", " + p.getSecond());
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
