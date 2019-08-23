/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/4/19
    Project: Assignment 12
    Description: Recursion
*/
package java2assignment12;

import java.util.Scanner;

public class Lab12 {

    public int Ones(int num)
    {
        //find the binary rep
        int binary;
        int count = 0;
        
        //if the number is > 0,then you 
        //have not gotten the binary representation
        //of the original number send to this function.
        while(num > 0)
        {
            //gives you the remainder, which gives you
            //the first number in the binary representation
            binary = num % 2;
            
            //if this bit = 1, then increase the count for ones
            if(binary == 1)
            {
                count++;
            }
            
            //divide the current number by 2,
            //so you can repeat the same steps on the new
            //number, until the number is <= 0,
            //meaning you have gotten the binary representation
            //of the original number
            num = num / 2;
            
            //recursively call this function to find the left most bit
            //of the binary representation of the number sent.
            Ones(num);
        }
        
        //return the count  
        return count;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        Lab12 l = new Lab12();
        
        System.out.println("Please enter a number:");
        int num = in.nextInt();
        
        int count = l.Ones(num);
        
        System.out.println("Count of ones in the binary rep is: " + count);
        
    }
    
}
