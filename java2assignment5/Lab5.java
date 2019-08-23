/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 3/30/19
    Project: Assignment 5
    Description: Creating Classes
*/
package java2assignment5;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;

public class Lab5 extends Application 
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
    Card leftCard = new Card();
    Card rightCard = new Card();
    Card deckCard = new Card();

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
              Card imgCard = new Card();
              
              int min = 101;
              int max = 152;
              int range = max - min + 1;
              Random rnd = new Random();
              int randNum = rnd.nextInt(range) + min;
              
              String pathToImage = "file:img\\" + randNum + ".gif";
              
              if(rightsTurn == true)
              {
                  //if rights turn
                  imgCard.setImage(pathToImage);
                  lblCardRight.setGraphic(imgCard.getCard());
                  rightVal = imgCard.getValue();
              }
              else
              {
                  //if lefts turn
                  imgCard.setImage(pathToImage);
                  lblCardLeft.setGraphic(imgCard.getCard());
                  leftVal = imgCard.getValue();
                  
                  if(rightVal > leftVal)
                  {
                      //setting score for right
                      score =  Integer.parseInt(tfRight.getText());
                      score += rightVal;
                      tfRight.setText("" + score);
                  }
                  else if (leftVal > rightVal)
                  {
                      //setting score for left
                      score =  Integer.parseInt(tfLeft.getText());
                      score += leftVal;
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
        //creating a new card and setting the image
        leftCard.setImage("file:img\\155.gif");
        
        //creating a new card and setting the image
        rightCard.setImage("file:img\\155.gif");
        
        //creating a new card and setting the image
        deckCard.setImage("file:img\\155.gif");
        
        //calling setGraphic method on all 3 labels.
        lblCardLeft.setGraphic(leftCard.getCard());
        lblCardRight.setGraphic(rightCard.getCard());
        lblCardDeck.setGraphic(deckCard.getCard());
        
       

    }
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
