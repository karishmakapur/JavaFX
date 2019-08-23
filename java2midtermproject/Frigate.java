/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/19/19
    Project: Midterm
    Description: Battleship
*/
package java2midtermproject;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class Frigate extends Ship
{
    
    public Frigate(int[] pieces, char Direction) 
    {
        super("Frigate", pieces, Direction);
    }
    @Override
    public void storeImage(String imgPath, int row, int col)
    {
        images[row][col] = new Image(imgPath);
        lblShip[row][col].setText(imgPath);
    }
    
    
}
