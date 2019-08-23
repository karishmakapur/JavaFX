/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/11/19
    Project: Final Project
    Description: Highest and Lowest Batting Averages
 */
package java2finalproject;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> al = new ArrayList<T>();
    
    public Stack(){}
    
    private T getElement(boolean erase)
    {
        T data = null;
        if(!this.al.isEmpty())
        {
            data = this.al.get(0);
            if(erase == true)
            {
                this.al.remove(0);
            }
        }
        return data;
    }
    
    public void push(T elem) {
        this.al.add(0, elem);
    }

    public T pop() {
        return this.getElement(true);
    }

    public T peek() {
        return this.getElement(false);
    }
}
