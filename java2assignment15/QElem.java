/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/11/19
    Project: Assignment 15
    Description: Generic Collections
 */
package java2assignment15;


public class QElem<T>
{
    int priority;
    T elem;
    public QElem(T Elem, int pri)
    {
        this.elem = Elem;
        this.priority = pri;
    }
    public int getPri()
    {
        return this.priority;
    }
    public T getElem()
    {
        return this.elem;
    }
}
