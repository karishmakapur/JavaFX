/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/27/19
    Project: Assignment 11
    Description: Streams
 */
package java2assignment11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class JPad extends Application {

    private Stage stage;
    private TextArea ta = new TextArea();
    private String fname;
    private Label status = new Label("Ready");

    @Override
    public void start(Stage primaryStage) {
        fname = "Untitled";
        stage = primaryStage;
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 300);
        root.setCenter(ta);
        GridPane menuPane = new GridPane();
        menuPane.add(menuBar(), 0, 0);
        menuPane.add(toolBar(), 0, 1);
        root.setTop(menuPane);
        root.setBottom(status);
        
        stage.setTitle(fname);
        stage.setScene(scene);
        stage.show();

    }

    private HBox toolBar() {
        HBox box = new HBox();
        String btns[] = {"New", "Open", "Save", "Save As"};

        for (int i = 0; i < btns.length; i++) {
            //initialize the text with an element of the array
            Button b = new Button(btns[i]);

            EventHandler<ActionEvent> toolBarHandler = (ActionEvent event) -> {
                Button b1 = (Button) event.getSource();
                handleEvent(b1.getText());
            };
            //Call the setOnAction method for the Button called 
            //b and pass it a value called toolBarHandler.
            b.setOnAction(toolBarHandler);

            //add the Button b to box 
            box.getChildren().add(b);
        }

        box.setSpacing(5.0);
        box.setStyle("-fx-background-color:#D3D3D3");
        return box;
    }

    private MenuBar menuBar() {
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem saveAsMenuItem = new MenuItem("Save As");
        MenuItem exitMenuItem = new MenuItem("Exit");

        EventHandler<ActionEvent> menuHandler = (ActionEvent event) -> {
            MenuItem mi = (MenuItem) event.getSource();
            handleEvent(mi.getText());
        };
        newMenuItem.setOnAction(menuHandler);
        openMenuItem.setOnAction(menuHandler);
        saveMenuItem.setOnAction(menuHandler);
        saveAsMenuItem.setOnAction(menuHandler);

        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        MenuBar bar = new MenuBar();
        bar.getMenus().add(fileMenu);

        return bar;
    }

    private void handleEvent(String event) {
        switch (event) {
            case "New":
                newFile();
                break;
            case "Open":
                openFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Save As":
                saveFileAs();
                break;
        }
    }
    private void newFile()
    {
        fname = "Untitled";
        ta.clear();
        ta.requestFocus();
    }
    private void saveFile()
    {
        if("Untitled".equals(fname))
        {
            saveFileAs();
        }
        else
        {
            writeFile();
        }
    }
    private void openFile()
    {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("JPad files (*.jpad)", "*.jpad");
        fc.getExtensionFilters().add(filter);
        
        File file = fc.showOpenDialog(stage);
        
        if(file == null)
        {
            status.setText("User canceled the FileChooser");
            ta.requestFocus();
        }
        else
        {
            fname = file.getPath();
            readFile();
        }
    }
    private void saveFileAs()
    {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("JPad files (*.jpad)", "*.jpad");
        fc.getExtensionFilters().add(filter);
        
        File file = fc.showSaveDialog(stage);
        
        if(file == null)
        {
            status.setText("User canceled the FileChooser");
            ta.requestFocus();
        }
        else
        {
            fname = file.getPath();
            writeFile();
        }
    }
    private void readFile()
    {
        if("Untitled".equals(fname))
        {
            ta.clear();
            ta.requestFocus();
            return;
        }
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fname);
            String s = "";
            int ch;
            while((ch = fis.read()) != -1)
            {
               
               s += (char)((ch - 128) % 256);
            }
            ta.setText(s);
            status.setText("File read successfully");
            stage.setTitle("Jpad - " + fname);
            
        }
        catch(IOException e)
        {
            status.setText("File not read successfully");
        }
        finally
        {
            try
            {
                if(fis != null)
                {
                    fis.close();
                }
            }
            catch(IOException ie) {     
               System.out.println(ie.getMessage());
            }
            
        }
    }
    private void writeFile()
    {
        FileOutputStream fout = null;
        try
        {
            fout = new FileOutputStream(fname);
            String s = ta.getText();
            int ch;
            for(int i = 0; i < s.length(); i++)
            {
                ch = s.charAt(i);
                fout.write(ch + 128);
            }
            
            status.setText("File written successfully");
            stage.setTitle("Jpad - " + fname);
            
        }
        catch(IOException e)
        {
            status.setText("File not written successfully");
        }
        finally
        {
            try
            {
                if(fout != null)
                {
                    fout.close();
                }
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
