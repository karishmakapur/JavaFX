/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 3/30/19
    Project: Assignment 4
    Description: JavaFX events
*/
package java2assignment4;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javax.swing.*;

public class Lab4 extends Application 
{
    Button btnReset = new Button("Reset");
    Label lblScore = new Label("Score:");
    TextField tfLeft = new TextField();
    TextField tfRight = new TextField();
    Label lblCardLeft = new Label();
    Label lblCardRight = new Label();
    Label lblCardDeck = new Label();
    int rightVal = 0;
    int leftVal = 0;
    int score = 0;
    boolean rightsTurn = true;

    @Override
    public void start(Stage primaryStage)    
    {
        btnReset.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                rightVal = 0;
                leftVal = 0;
                score = 0;
                tfRight.setText("0");
                tfLeft.setText("0");
                rightsTurn = true;
                resetCardImages();
                
            }
        });
        
        lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
          @Override
          public void handle(MouseEvent event) 
          {
              int min = 101;
              int max = 152;
              int range = max - min + 1;
              Random rnd = new Random();
              int randNum = rnd.nextInt(range) + min;
              
              String pathToImage = "file:img\\" + randNum + ".gif";
              
              if(rightsTurn == true)
              {
                  //if rights turn
                  rightVal = randNum;
                  Image imgCard = new Image(pathToImage);
                  lblCardRight.setGraphic(new ImageView(imgCard));
              }
              else
              {
                  //if lefts turn
                  leftVal = randNum;
                  Image imgCard = new Image(pathToImage);
                  lblCardLeft.setGraphic(new ImageView(imgCard));
                  
                  if(rightVal > leftVal)
                  {
                      //setting score for right
                      score =  Integer.parseInt(tfRight.getText());
                      score++;
                      tfRight.setText("" + score);
                  }
                  else if (leftVal > rightVal)
                  {
                      //setting score for left
                      score =  Integer.parseInt(tfLeft.getText());
                      score++;
                      tfLeft.setText("" + score);
                  }
              }
              
              //flipping turn
              rightsTurn = !rightsTurn; 
          }
        });
        
        
        //layouts
        BorderPane root = new BorderPane(); //to place other panes
        GridPane topPane = new GridPane(); //for labels and textfields
        GridPane cardPane = new GridPane(); //for the card images
        
        //setting HGap and VGap for topPane
        topPane.setHgap(20);
        topPane.setVgap(10);
        
        //setting HGap of cardPane
        cardPane.setHgap(20.0);
        
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Assignment 4");
        primaryStage.show();
        primaryStage.setScene(scene);
        
        //setting fonts and colors for lblScore
        lblScore.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        Color clr1 = Color.HOTPINK;
        lblScore.setTextFill(clr1);
        
        //setting the textfields
        tfLeft.setPrefWidth(50);
        tfRight.setPrefWidth(50);
        tfLeft.setDisable(true);
        tfRight.setDisable(true);
        tfLeft.setText("0");
        tfRight.setText("0");
        
        //adding labels to topPane
        topPane.add(lblScore, 0, 0);
        topPane.add(new Label("Left"), 0, 1);
        topPane.add(new Label("Right"), 2, 1);
        
        //adding textfields to topPane
        topPane.add(tfLeft, 1, 1);
        topPane.add(tfRight, 3, 1);
        
        //adding Labels to cardPane
        cardPane.add(lblCardLeft, 0, 0);
        cardPane.add(lblCardDeck, 1, 0);
        cardPane.add(lblCardRight, 2, 0);
        
        //setting alignment of cardPane
        cardPane.setAlignment(Pos.CENTER);
        
        //calling helper function to reset the card images
        this.resetCardImages();
        
        //adding topPane to top of rootPane
        root.setTop(topPane);
        
        //adding cardPane to center of rootPane
        root.setCenter(cardPane);
        
        //adding button to bottom of rootpane
        root.setBottom(btnReset);
    }
    public void resetCardImages()
    {
        //creating 3 images, and loading image 155.gif to each
        Image imgCardLeft = new Image("file:img\\155.gif");
        Image imgCardRight = new Image("file:img\\155.gif");
        Image imgCardDeck = new Image("file:img\\155.gif");
        
        //setGraphic method
        lblCardLeft.setGraphic(new ImageView(imgCardLeft));
        lblCardRight.setGraphic(new ImageView(imgCardRight));
        lblCardDeck.setGraphic(new ImageView(imgCardDeck));

    }
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
