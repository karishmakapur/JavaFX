/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/4/19
    Project: Assignment 13
    Description: Regular Expressions
 */
package java2assignment13;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Lab13 extends Application {

    Button fileButton = new Button("Choose File");
    TextArea words = new TextArea();
    TextArea palindrome = new TextArea();
    Label wordLabel = new Label("All the words from dictionary");
    Label palindromeLabel = new Label("Palindrome words");
    
    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        BorderPane pane = new BorderPane();
        fileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser.setTitle("Dictionary");
                fileChooser.setInitialDirectory(new File("./v003"));
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("webpages", "*.html"));
                fileChooser.setInitialFileName("Dictionary.html");
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    readFile(file);
                }
            }
        }
        );
        
        
        words.setPromptText("All the words from the dictionary will appear here.");
        palindrome.setPromptText("All the Palindromes from the dictionary will appear here");
        pane.setTop(fileButton);
        pane.setLeft(words);
        pane.setRight(palindrome);
        Scene scene = new Scene(pane, 900, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   private void readFile(File file)
   {
        String dicWord = "";
        String palWord = "";
        
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
           fr  = new FileReader(file);
           br = new BufferedReader(fr);
           String line;
           
           while((line = br.readLine()) != null)
           {
               Pattern p = Pattern.compile("\\b^[A-Za-z]+[-,']?[A-Za-z, , \\d]*\\b");
               line = line.replaceAll("\\<.*?\\>", "");
               
               Matcher m = p.matcher(line);
               
               String word = "";
               String backwardsWord = "";
               
               while(m.find())
               {
                   
                    dicWord += m.group() + "\n";
                    word = m.group();
                    if (word.length() == 5)
                    {
                        for (int i = word.length() - 1; i >= 0; i--)
                        {
                            backwardsWord += word.charAt(i); 
                            
                        }
                        if (word.equalsIgnoreCase(backwardsWord))
                        {
                            palWord += word + "\n";
                        }
                    }
                    
                    
                   
               }
                    
           }
           words.setText(dicWord);
           palindrome.setText(palWord);
        }
        catch(Exception e){
           System.out.println("Error opening file");
        }
        finally{
           try{
              fr.close();
              br.close();
           }
           catch(Exception e){
              System.out.println(e.getMessage());
           }
        }
        
}

    public static void main(String[] args) {

        launch(args);
    }

}
