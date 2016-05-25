import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by shivali on 24-May-16.
 */

public class StackUsingQueue
{
    Queue <Integer> que1;
    Queue <Integer> que2;

    public StackUsingQueue()
    {
        que1=new LinkedList<Integer>();
        que2=new LinkedList<Integer>();
    }

    public void push(int data)
    {
        if(que1.size()==0)
            que1.add(data);
        else
        {
            int l=que1.size();
            for (int i=0;i<l;i++)
            {
                que2.add(que1.remove());
            }
            que1.add(data);
            for (int i=0;i<l;i++)
            {
                que1.add(que2.remove());
            }
        }
    }

    public  int pop()
    {
        if (que1.size()==0)
            throw new NoSuchElementException("Underflow Exception");
        return  que1.remove();
    }

    int getSize()
    {
        return que1.size();
    }
    public  void  display()
    {
        System.out.println("Stack is : ");
        int l=getSize();
        if(l==0)
            System.out.println("Empty Stack");

        Iterator iterator=que1.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next()+" ");
        }
    }

    public static void main(String[] args)
    {
        StackUsingQueue stackUsingQueue=new StackUsingQueue();

        stackUsingQueue.push(10);
        stackUsingQueue.push(20);
        stackUsingQueue.push(30);
        stackUsingQueue.display();
        stackUsingQueue.pop();
        stackUsingQueue.display();
    }
}
