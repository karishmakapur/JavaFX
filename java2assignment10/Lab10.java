/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/27/19
    Project: Assignment 10
    Description: Exceptions
 */
package java2assignment10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class Lab10 extends Application {

    private Button btnReset = new Button("Reset");
    private Label lblScore = new Label("Score:");
    private TextField tfLeft = new TextField();
    private TextField tfRight = new TextField();
    private Label lblCardLeft = new Label();
    private Label lblCardRight = new Label();
    private Label lblCardDeck = new Label();
    private boolean rightsTurn = true;
    private Card leftCard;
    private Card rightCard;
    private Card deckCard;
    private Deck deck;
    private int rightVal = 0;
    private int leftVal = 0;

    @Override
    public void start(Stage primaryStage) {
        try {
            deck = new Deck();
        } catch (Exception e) {
            alert(e.getMessage());
        }

        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Score.resetScore();
                tfRight.setText("0");
                tfLeft.setText("0");
                rightsTurn = true;
                resetCardImages();

            }
        });

        lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayingCard imgCard = deck.deal();

                if (rightsTurn == true) {
                    //if rights turn
                    lblCardRight.setGraphic(imgCard);
                    rightVal = imgCard.getValue();
                } else {
                    //if lefts turn
                    lblCardLeft.setGraphic(imgCard);
                    leftVal = imgCard.getValue();

                    if (rightVal > leftVal) {
                        //setting score for right
                        //Score.setRightScore(tfRight.getText());
                        Score.setRightScore(rightVal);
                        int score = Score.getRightScore();
                        tfRight.setText("" + score);
                    } else if (leftVal > rightVal) {
                        //setting score for left
                        //Score.setLeftScore(tfLeft.getText());
                        Score.setLeftScore(leftVal);
                        int score = Score.getLeftScore();
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
        primaryStage.setTitle("Java Game");
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

    public void resetCardImages() {
        try {
            //creating a new card and setting the image
            leftCard = new TarotCard();

            //creating a new card and setting the image
            rightCard = new TarotCard();

            //creating a new card and setting the image
            deckCard = new TarotCard();

            //calling setGraphic method on all 3 labels.
            lblCardLeft.setGraphic(leftCard);
            lblCardRight.setGraphic(rightCard);
            lblCardDeck.setGraphic(deckCard);
        } catch (Exception e) {
            alert(e.getMessage());
        }

    }

    private void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("CardException Error");
        alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(message)));
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
