/*
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/11/19
    Project: Final Project
    Description: Highest and Lowest Batting Averages
 */
package java2finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FinalProject extends Application {

    Stack<String> highest = new Stack();
    Stack<String> lowest = new Stack();
    double highestBattingAverage = 0;
    double lowestBattingAverage = 1;
    Button fileButton = new Button("Choose File");
    TextArea highestTa = new TextArea();
    TextArea lowestTa = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser.setTitle("Averages");
                fileChooser.setInitialDirectory(new File("."));
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("textfile", "*.txt"));
                fileChooser.setInitialFileName("avg.txt");
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    readFile(file);
                }
            }
        });

        BorderPane root = new BorderPane();
        root.setTop(fileButton);
        root.setLeft(highestTa);
        root.setRight(lowestTa);

        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void readFile(File file) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                Pattern name = Pattern.compile("([A-Za-z])+([.])?([A-Z])?([.])?");
                Pattern avg = Pattern.compile("[.]\\d+");
                Matcher mName = name.matcher(line);
                Matcher mAvg = avg.matcher(line);

                while (mName.find() && mAvg.find()) {
                    System.out.println(mName.group());
                    System.out.println(mAvg.group());
                    if (highest.peek() == null && lowest.peek() == null) {

                        highestBattingAverage = Double.parseDouble(mAvg.group());
                        lowestBattingAverage = Double.parseDouble(mAvg.group());
                        highest.push(mName.group());
                        lowest.push(mName.group());
                    } else if (Double.parseDouble(mAvg.group()) > highestBattingAverage) {
                        highestBattingAverage = Double.parseDouble(mAvg.group());
                        while (highest.peek() != null) {
                            highest.pop();
                        }
                        highest.push(mName.group());
                    } else if (Double.parseDouble(mAvg.group()) < lowestBattingAverage) {
                        lowestBattingAverage = Double.parseDouble(mAvg.group());
                        while (lowest.peek() != null) {
                            lowest.pop();
                        }
                        lowest.push(mName.group());
                    } else if (Double.parseDouble(mAvg.group()) == highestBattingAverage) {
                        highest.push(mName.group());
                    } else if (Double.parseDouble(mAvg.group()) == lowestBattingAverage) {
                        lowest.push(mName.group());
                    }
                }
            }
            String highestNames = "The highest batting average is " + highestBattingAverage + ".";
            highestNames += " Here are the following names: \n";
            String lowestNames = "The lowest batting average is " + lowestBattingAverage + ".";
            lowestNames += " Here are the following names: \n";
            while (highest.peek() != null) {
                highestNames += highest.peek() + "\n";
                highest.pop();
            }
            highestTa.setText(highestNames);

            while (lowest.peek() != null) {
                lowestNames += lowest.peek() + "\n";
                lowest.pop();
            }
            lowestTa.setText(lowestNames);
        } catch (Exception e) {
            System.out.println("Error opening file");
        } finally {
            try {
                fr.close();
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
