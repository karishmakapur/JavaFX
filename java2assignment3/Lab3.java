/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 3/25/19
    Project: Assignment 2
    Description: swing applications
*/
package java2assignment3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.util.Random;

public class Lab3 extends Application 
{
    
    @Override
    public void start(Stage primaryStage)    
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Assignment 3");
        primaryStage.show();
        primaryStage.setScene(scene);
        
        StackPane middle = new StackPane();
        
        //label for random card
        Label randomCardlbl = new Label("Random Card");
        randomCardlbl.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        Color clr1 = Color.HOTPINK;
        randomCardlbl.setTextFill(clr1);
        
        //label for the image
        Label lblCard = new Label();
        
        //label for nothing up my sleeve
        Label nothingUpMySleevelbl = new Label("Nothing up my sleeve");
        nothingUpMySleevelbl.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Color clr2 = Color.LIGHTSKYBLUE;
        nothingUpMySleevelbl.setTextFill(clr2);
        
        //setting locations for the labels
        root.setTop(randomCardlbl);
        root.setBottom(nothingUpMySleevelbl);
        middle.getChildren().add(lblCard);
        
        //setting the StackPane to the middle of the BorderPane
        root.setCenter(middle);
        
        //following section is loading the image:
        final int MAX = 155;
        final int MIN = 101;
        
        int range = MAX - MIN + 1;
        
        Random rnd = new Random();
        
        int randomImageNum = rnd.nextInt(range) + 101;
        
        String pathToImage = "file:img\\" + randomImageNum + ".gif";
        
        Image imgCard = new Image(pathToImage);
        lblCard.setGraphic(new ImageView(imgCard));
        
      
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
