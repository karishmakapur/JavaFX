/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/11/19
    Project: Assignment 15
    Description: Generic Collections
 */
package java2assignment15;

import java.util.ArrayList;

public class PriQueue<T> extends ArrayList 
{
    //enqueue - Add an element to the queue
    public void enqueue(T elem, int pri)
    {
        if(pri > 10)
        {
            pri = 5;
        }
        QElem obj =  new QElem(elem, pri);
        super.add(0, obj);
        this.bubbleSort();
    }
    
    //dequeue - Remove element from the front of the queue
    public QElem dequeue()
    {
        QElem removeElem = (QElem) super.remove(0);
        return removeElem;
    }
    
    //peek - Return value at front of queue do not remove it
    public QElem peek()
    {
        QElem peekElem = (QElem) super.get(0);
        return peekElem;
    }
    
    //size - Returns the number of items in the queue.
    public int size()
    {
        return super.size();
    }
    
    private void bubbleSort()
    {
        int n = this.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
            {
                QElem leftElem = (QElem) this.get(j);
                QElem rightElem = (QElem) this.get(j + 1);
                if (leftElem.getPri() < rightElem.getPri())
                {
                    // swap temp and arrayList.get(j)
                    QElem temp = leftElem;
                    this.set(j, rightElem);
                    this.set(j + 1, leftElem);
                }
            }
    }
    public static void main(String[] args) 
    {
        //scope for Integer priqueue
        {
            System.out.println("==========INTEGER=========");
            PriQueue <Integer> pQ = new PriQueue<Integer>();
            pQ.enqueue(5, 1);
            pQ.enqueue(10, 3);
            pQ.enqueue(15, 2);
            pQ.enqueue(20, 6);
            pQ.enqueue(25, 9);
            pQ.enqueue(30, 8);
            pQ.enqueue(50, 11);
            System.out.println("Elements according to priority:");
            for(int i = 0; i < pQ.size(); i++)
            {
                QElem q = (QElem)pQ.get(i);
                System.out.println("'" +q.getElem() + "' , " + q.getPri());
            }
            
            System.out.println("Size: " + pQ.size());
            QElem dq1 = pQ.dequeue();
            System.out.println("Dequeued element '" + dq1.getElem() + "' with priority " + dq1.getPri());
            System.out.println("Size: " + pQ.size());
            QElem dq2 = pQ.dequeue();
            System.out.println("Dequeued element '" + dq2.getElem() + "' with priority " + dq2.getPri());
            System.out.println("Size: " + pQ.size());
            QElem peek = pQ.peek();
            System.out.println("Peeked: '" + peek.getElem() + "'");
            System.out.println("Size: " + pQ.size());
       }
        //scope for Double priqueue
        {
            System.out.println("==========DOUBLE=========");
            PriQueue <Double> pQ = new PriQueue<Double>();
            pQ.enqueue(5.123, 1);
            pQ.enqueue(10.543, 3);
            pQ.enqueue(15.243, 2);
            pQ.enqueue(20.903, 6);
            pQ.enqueue(25.783, 9);
            pQ.enqueue(30.546, 8);
            pQ.enqueue(50.098, 11);
            System.out.println("Elements according to priority:");
            for(int i = 0; i < pQ.size(); i++)
            {
                QElem q = (QElem)pQ.get(i);
                System.out.println("'" +q.getElem() + "' , " + q.getPri());
            }
            
            System.out.println("Size: " + pQ.size());
            QElem dq1 = pQ.dequeue();
            System.out.println("Dequeued element '" + dq1.getElem() + "' with priority " + dq1.getPri());
            System.out.println("Size: " + pQ.size());
            QElem dq2 = pQ.dequeue();
            System.out.println("Dequeued element '" + dq2.getElem() + "' with priority " + dq2.getPri());
            System.out.println("Size: " + pQ.size());
            QElem peek = pQ.peek();
            System.out.println("Peeked: '" + peek.getElem() + "'");
            System.out.println("Size: " + pQ.size());
       }
        //scope for String priqueue
        {
            System.out.println("==========STRING=========");
            PriQueue <String> pQ = new PriQueue<String>();
            pQ.enqueue("Okay, bye.", 1);
            pQ.enqueue("I find it very fun,", 3);
            pQ.enqueue("as well as challenging.", 2);
            pQ.enqueue("I am a computer science major.", 6);
            pQ.enqueue("My name is Karishma", 9);
            pQ.enqueue("and this is my priqueue implementation.", 8);
            pQ.enqueue("I love coding.", 11);
            System.out.println("Elements according to priority:");
            for(int i = 0; i < pQ.size(); i++)
            {
                QElem q = (QElem)pQ.get(i);
                System.out.println("'" +q.getElem() + "' , " + q.getPri());
            }
            
            System.out.println("Size: " + pQ.size());
            QElem dq1 = pQ.dequeue();
            System.out.println("Dequeued element '" + dq1.getElem() + "' with priority " + dq1.getPri());
            System.out.println("Size: " + pQ.size());
            QElem dq2 = pQ.dequeue();
            System.out.println("Dequeued element '" + dq2.getElem() + "' with priority " + dq2.getPri());
            System.out.println("Size: " + pQ.size());
            QElem peek = pQ.peek();
            System.out.println("Peeked: '" + peek.getElem() + "'");
            System.out.println("Size: " + pQ.size());
       }
    }
    
}
