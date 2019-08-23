/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/19/19
    Project: Midterm
    Description: Battleship
*/
package java2midtermproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MidtermProject extends Application {

    private static final int MAXSHIPS = 14;
    private static final int GRIDSIZE = 16;
    private GridPane pnlPlayer = new GridPane();
    private Label[][] lblPlayer = new Label[GRIDSIZE][GRIDSIZE];
    private Image[] imgShips = new Image[10];
    private Ship[] shipInfo = new Ship[8];
    private char[][] ocean = new char[16][16];
    private Button resetButton = new Button("Reset");
    private Button showShipsButton = new Button("Show Ships");
    private HBox buttonPane = new HBox();
    private int missNum = 0;
    private Image[][] imageShips = new Image[GRIDSIZE][GRIDSIZE];
    private char[][] hitMissShips = new char[16][16];
    private String[] indexesOfShips = new String[14];
    private int indexString = 0;
    private String imgPath[] = new String[10];

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 290, 315);

        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //resetting the board game
                indexString = 0;
                initOcean();
                createPlayerPanel();
                createShips();
                placeShips();

            }
        });
        showShipsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //showing the ships
                //i didn't show hit's or misses because it the wording made it seem like
                //the player doesn't care to see his/her results. He/She just wants 
                //to give up

                for(int shipNum = 0; shipNum < 8; shipNum++)
                {
                    Ship si = shipInfo[shipNum];

                    for (int row = 0; row < GRIDSIZE; row++) 
                    {
                        for (int col = 0; col < GRIDSIZE; col++) 
                        {
                            Label[][] lblimages = si.getLabel();
                            if (ocean[row][col] != 'O' && lblimages[row][col].getText().startsWith("file:")) 
                            {
                                lblPlayer[row][col].setGraphic(new ImageView(new Image(lblimages[row][col].getText())));
                            }
                        }
                    }
                }
               
            }
        });
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //show hit or miss image
                Label referenceLabel = (Label) event.getTarget();

                for (int row = 0; row < GRIDSIZE; row++) {
                    for (int col = 0; col < GRIDSIZE; col++) {
                        if (lblPlayer[row][col] == referenceLabel) {
                            if (ocean[row][col] == 'O') {
                                missNum++;
                                hitMissShips[row][col] = 'M';
                                lblPlayer[row][col].setGraphic(new ImageView(new Image("file:Images\\batt102.gif")));

                            } else {
                                hitMissShips[row][col] = 'H';
                                lblPlayer[row][col].setGraphic(new ImageView(new Image("file:Images\\batt103.gif")));
                                checkSink(row, col);
                            }

                        }
                    }
                }

            }
        });
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();
        this.initOcean();
        this.createPlayerPanel();
        createShips();
        root.setCenter(pnlPlayer);
        buttonPane.getChildren().addAll(resetButton, showShipsButton);
        root.setBottom(buttonPane);
        placeShips();
    }

    private void checkSink(int row, int col) {

        for (int i = 0; i < indexesOfShips.length; i++) {
            String currentString = indexesOfShips[i];
            String direction = currentString.substring(0, currentString.indexOf(' '));
            String r = indexesOfShips[i].substring(currentString.indexOf(' ') + 1, currentString.indexOf(','));
            int firstIndexOfComma = currentString.indexOf(',');
            String c = indexesOfShips[i].substring(firstIndexOfComma + 1, currentString.indexOf(',', firstIndexOfComma + 1));
            String len = indexesOfShips[i].substring(currentString.indexOf(',', firstIndexOfComma + 1) + 1);

            int begRow = Integer.parseInt(r);
            int begCol = Integer.parseInt(c);
            int lengthOfShip = Integer.parseInt(len);
            int endRow = begRow + lengthOfShip - 1; //end position of ship row
            int endCol = begCol + lengthOfShip - 1;
            int hit = 0;

            if ("V".equals(direction)) //up and down
            {
                if (col == begCol) {
                    if (row >= begRow && row <= endRow) {
                        for (int j = begRow; j <= endRow; j++) //looping from the start of the ship to the end of the ship
                        {
                            //checking to see if user hit every part of the ship
                            if (hitMissShips[j][col] == 'H') {
                                hit++;
                            }

                        }

                        if (hit == lengthOfShip) {
                            lblPlayer[begRow][col].setGraphic(new ImageView(new Image("file:Images\\batt204.gif"))); //back end of ship
                            for (int l = begRow + 1; l < endRow; l++) {
                                lblPlayer[l][col].setGraphic(new ImageView(new Image("file:Images\\batt205.gif")));
                            }
                            lblPlayer[endRow][col].setGraphic(new ImageView(new Image("file:Images\\batt206.gif"))); //front of ship
                        }

                    }
                }
            }
            else if ("H".equals(direction)) //left to right
            {
                if (row == begRow) {
                    if (col >= begCol && col <= endCol) {
                        for (int j = begCol; j <= endCol; j++) //looping from the start of the ship to the end of the ship
                        {
                            //checking to see if user hit every part of the ship
                            if (hitMissShips[row][j] == 'H') {
                                hit++;
                            }

                        }

                        if (hit == lengthOfShip) {
                            lblPlayer[row][begCol].setGraphic(new ImageView(new Image("file:Images\\batt201.gif"))); //back end of ship
                            for (int x = begCol + 1; x < endCol; x++) {
                                lblPlayer[row][x].setGraphic(new ImageView(new Image("file:Images\\batt202.gif")));
                            }
                            lblPlayer[row][endCol].setGraphic(new ImageView(new Image("file:Images\\batt203.gif"))); //front of ship
                        }
                    }
                }
            }
        } //end of outmost for loop
    } //end of checkSink function

    private void createPlayerPanel() {
        pnlPlayer.setStyle("-fx-background-color:#0000FF;");
        for (int row = 0; row < GRIDSIZE; row++) {
            for (int col = 0; col < GRIDSIZE; col++) {
                lblPlayer[row][col] = new Label();
                Image imgShip = new Image("file:Images\\batt100.gif");
                lblPlayer[row][col].setGraphic(new ImageView(imgShip));
                lblPlayer[row][col].setMaxSize(16.0, 16.0);
                lblPlayer[row][col].setStyle("-fx-border-width:1;-fx-border-color:black;");
                pnlPlayer.add(lblPlayer[row][col], col, row);

            }
        }

    }

    private void createShips() {
        this.loadShipImages();
        this.createShipInfo();
    }

    private void loadShipImages() {
        for (int i = 0; i < 10; i++) {
            imgShips[i] = new Image("file:Images\\batt" + (i + 1) + ".gif");
            imgPath[i] = "file:Images\\batt" + (i + 1) + ".gif";
        }
    }

    private void createShipInfo() {
        //Start with the frigate, we create 2 of them here but will place 3 total randomly it as two images
        int[] frigateH = {0, 4};
        shipInfo[0] = new Frigate(frigateH, 'H');

        int[] frigateV = {5, 9};
        shipInfo[1] = new Frigate(frigateV, 'V');

        // Create the mine Sweep it has 3 pieces
        int[] mineSweepH = {0, 1, 4};
        shipInfo[2] = new MineSweep(mineSweepH, 'H');
        int[] mineSweepV = {5, 6, 9};
        shipInfo[3] = new MineSweep(mineSweepV, 'V');

        int[] cruiserH = {0, 1, 2, 4};
        shipInfo[4] = new Cruiser(cruiserH, 'H');
        int[] cruiserV = {5, 6, 7, 9};
        shipInfo[5] = new Cruiser(cruiserV, 'V');

        int[] battleShipH = {0, 1, 2, 3, 4};
        shipInfo[6] = new BattleShip(battleShipH, 'H');
        int[] battleShipV = {5, 6, 7, 8, 9};
        shipInfo[7] = new BattleShip(battleShipV, 'V');
    }

    private void initOcean() {
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 16; col++) {
                ocean[row][col] = 'O';
                hitMissShips[row][col] = 'O';
            }
        }
    }

    private void placeShips() {
        // Create a Random object to select ships
        Random r = new Random();

        // Create random objects to place the ship at a row and a column
        Random randCol = new Random();
        Random randRow = new Random();

        //Place the ships, typically there are 14
        for (int ships = 0; ships < MAXSHIPS; ships++) {

            //Get a random ship
            Ship si = shipInfo[r.nextInt(8)];

            int row = randRow.nextInt(16);
            int col = randCol.nextInt(16);
            int direction = checkDirection(si, row, col);
            while (direction == 0) // 0 direction says that we can not place the ship
            {
                row = randRow.nextInt(16);
                col = randCol.nextInt(16);
                direction = checkDirection(si, row, col);
            }
            // got a clear path, let put the ship on the ocean
            int shipPieces[] = si.getShipPieces();
            if (si.Direction == 'H') // place horizontal
            {
                if (direction == 1) {
                    for (int i = col, j = 0; i < col + si.length(); i++, j++) {
                        imageShips[row][i] = imgShips[shipPieces[j]];
                        si.storeImage(imgPath[shipPieces[j]], row, i);
                        if (j == 0) {
                            this.indexesOfShips[indexString] = si.Direction + " " + row + "," + i + "," + si.length();
                            indexString++;
                        }
                        //lblPlayer[row][i].setGraphic(new ImageView(imgShips[shipPieces[j]]));
                        lblPlayer[row][i].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                        String name = si.getName();
                        ocean[row][i] = name.charAt(0);
                    }
                } else {
                    for (int i = col + si.length(), j = 0; i > col; i--, j++) {
                        imageShips[row][i] = imgShips[shipPieces[j]];
                        si.storeImage(imgPath[shipPieces[j]], row, i);
                        if (j == 0) {
                            this.indexesOfShips[indexString] = si.Direction + " " + row + "," + i + "," + si.length();
                            indexString++;
                        }
                        lblPlayer[row][i].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                        String name = si.getName();
                        ocean[row][i] = name.charAt(0);
                    }
                }
            } else // Must be vertical direction
            {
                if (direction == 1) // place pieces in positive direction
                {
                    for (int i = row, j = 0; i < row + si.length(); i++, j++) {
                        imageShips[i][col] = imgShips[shipPieces[j]];
                        si.storeImage(imgPath[shipPieces[j]], i, col);
                        if (j == 0) {
                            this.indexesOfShips[indexString] = si.Direction + " " + i + "," + col + "," + si.length();
                            indexString++;
                        }
                        //lblPlayer[i][col].setGraphic(new ImageView(imgShips[shipPieces[j]]));	
                        lblPlayer[i][col].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                        String name = si.getName();
                        ocean[i][col] = name.charAt(0);
                    }
                } else {
                    for (int i = row + si.length(), j = 0; i > row; i--, j++) {
                        imageShips[i][col] = imgShips[shipPieces[j]];
                        si.storeImage(imgPath[shipPieces[j]], i, col);
                        if (j == 0) {
                            this.indexesOfShips[indexString] = si.Direction + " " + i + "," + col + "," + si.length();
                            indexString++;
                        }
                        //lblPlayer[i][col].setGraphic(new ImageView(imgShips[shipPieces[j]]));
                        lblPlayer[i][col].setGraphic(new ImageView(new Image("file:Images\\batt100.gif")));
                        String name = si.getName();
                        ocean[i][col] = name.charAt(0);
                    }
                }
            }
        }
    }

    private int checkDirection(Ship si, int row, int col) {
        if (si.Direction == 'H') {
            return checkHorizontal(si, row, col);
        } else {
            return checkVertical(si, row, col);
        }
    }

    int checkHorizontal(Ship si, int row, int col) {
        boolean clearPath = true;

        int len = si.length();
        System.out.println(len);
        for (int i = col; i < (col + si.length()); i++) {
            if (i >= GRIDSIZE) //This would put us outside the ocean
            {
                clearPath = false;
                break;
            }
            if (ocean[row][i] != 'O') // Ship already exists in this spot
            {
                clearPath = false;
                break;
            }
        }
        if (clearPath == true) // ok to move in the positive direction
        {
            return 1;
        }

        //Next Chec the negative direction
        for (int i = col; i > (col - si.length()); i--) {
            if (i < 0) //This would put us outside the ocean
            {
                clearPath = false;
                break;
            }
            if (ocean[row][i] != 'O') // Ship already exists in this spot
            {
                clearPath = false;
                break;
            }

        }
        if (clearPath == true) //Ok to move in negative direction
        {
            return -1;
        } else {
            return 0;   // No place to move			
        }
    }

    int checkVertical(Ship si, int row, int col) {
        boolean clearPath = true;
        int len = si.length();
        System.out.println(len);

        for (int i = row; i < (row + si.length()); i++) {
            if (i >= GRIDSIZE) //This would put us outside the ocean
            {
                clearPath = false;
                break;
            }
            if (ocean[i][col] != 'O') // Ship already exists in this spot
            {
                clearPath = false;
                break;
            }
        }
        if (clearPath == true) // ok to move in the positive direction
        {
            return 1;
        }

        //Next Check the negative direction
        for (int i = row; i > (row - si.length()); i--) {
            if (i < 0) //This would put us outside the ocean
            {
                clearPath = false;
                break;
            }
            if (ocean[i][col] != 'O') // Ship already exists in this spot
            {
                clearPath = false;
                break;
            }

        }
        if (clearPath == true) //Ok to move in negative direction
        {
            return -1;
        } else {
            return 0;   // No place to move			
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
