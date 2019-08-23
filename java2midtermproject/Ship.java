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

public abstract class Ship
{
	private String shipName;
	private int[] shipPieces; 
        protected Image[][] images = new Image[16][16];
        protected Label[][] lblShip = new Label[16][16];
	char Direction;
		
	Ship(String name, int[] pieces,char Direction)
	{
		this.Direction = Direction;
		this.shipName = name;
		shipPieces = new int[pieces.length];
		for(int i = 0; i < pieces.length; i++)
                {
			shipPieces[i] = pieces[i];
                }
                for(int i = 0; i < 16; i++)
                {
                    for(int j = 0; j < 16; j++)
                    {
                        lblShip[i][j] = new Label();
                    }
                }
		
	}
	public String getName()
	{
		return this.shipName;
	}
	public int[] getShipPieces()
	{
		return shipPieces;
	}
	public int getDirection()
	{
		return this.Direction;
	}
	public int length()
	{
		return shipPieces.length;
	}
        
        abstract public void storeImage(String imgPath, int row, int col);
        
        public Label[][] getLabel()
        {
             return lblShip;
        }
}