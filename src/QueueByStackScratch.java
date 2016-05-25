import java.util.Iterator;
import java.util.NoSuchElementException;

//I'm facing problem to create two stacks and implement for by stack create queue.

/**
 * Created by shivali on 24-May-16.
 */
class  StackNode2
{
    private Object data;
    StackNode2 next;

    StackNode2()
    {
        this.setData(data);
        next=null;
    }

    StackNode2(Object data, StackNode2 n)
    {
        this.setData(data);
        next=n;
    }

    public Object getData()
    {
        return  data;
    }
    public void setData(Object data)
    {
        this.data=data;
    }
    public StackNode2 getLink()
    {
        return next;
    }
}

public class QueueByStackScratch {

    StackNode2 top;
   /* QueueByStackScratch s1=new QueueByStackScratch();
    QueueByStackScratch s2=new QueueByStackScratch();
*/
    //StackNode2 s1=new StackNode2();
    //StackNode2 s2=new StackNode2();

    int size=0;

    public int getSize() {
        return size;
    }

    private boolean isEmpty()
    {
        return  top==null;
    }

    public  void  push(Object data)
    {
        StackNode2 newNode=new StackNode2(data,null);
        if (top==null)
        {
            top=newNode;
        }
        else
        {
            newNode.next=top;
            top=newNode;
        }
        size++;
    }


    public Object pop()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Underflow Exception");
        }
        StackNode2 temp=top;
        top=temp.getLink();
        size--;
        return  temp.getData();

    }

 /*   public  void enqueue(Object data)
    {
        if(s1.size==0) {
            s1.push(data);
            System.out.println("S1.data" + top.getData());
        }
        else
        {
            int l=s1.size;
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
        if(s1.size==0)
            throw new NoSuchElementException("Underflow Exception");
        else
            return s1.pop();
    }
    */

    public void display()
    {
        System.out.println("Displaying Stack: ");
        if(top==null) {
            System.out.println("Queue is empty");
            return;
        }

        StackNode2 temp=top;
        while (temp!=null)
        {
            System.out.println(temp.getData()+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args)
    {
        QueueByStackScratch q=new QueueByStackScratch();

       /* q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
*/      q.push(10);
        q.push(20);
        q.push(30);
        q.display();

        q.pop();
       // q.dequeue();
        q.display();




    }


}
