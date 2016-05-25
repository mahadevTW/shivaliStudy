import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by shivali on 24-May-16.
 */
public class QueueUsingStack {

    Stack <Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack()
    {
        s1=new Stack<Integer>();
        s2= new Stack<Integer>();

    }

    public  void enqueue(int data)
    {
        if(s1.size()==0)
            s1.push(data);
        else
        {
            int l=s1.size();
            for (int i=0;i<l;i++)
                s2.push(s1.pop());
            s1.push(data);

            for (int i=0;i<l;i++)
                s1.push(s2.pop());
        }
    }

    public Object dequeue()
    {
        System.out.println("Deleting a element");
        if(s1.size()==0)
            throw new NoSuchElementException("Underflow Exception");
        else
            return s1.pop();
    }

    public void display()
    {
        if(s1==null)
            System.out.println("Queue is empty");

        Iterator iterator=s1.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next()+" ");
        }
    }

    public static void main(String[] args)
    {
        QueueUsingStack queueUsingStack=new QueueUsingStack();
        queueUsingStack.enqueue(10);
        queueUsingStack.enqueue(55);
        queueUsingStack.enqueue(26);
        queueUsingStack.enqueue(91);

        queueUsingStack.display();

        queueUsingStack.dequeue();
        queueUsingStack.display();
    }

}
