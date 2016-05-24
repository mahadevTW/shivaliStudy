import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

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

Stack<Integer> stack1 ;
Stack<Integer> stack2 ;

    public QueueByStackScratch(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void enQueue(int data){
        if(stack1.isEmpty()){
            stack1.push(data);
            return;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    public int deQueue(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int data = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return data;
    }

    public void display()
    {
    Iterator i = stack1.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    public static void main(String[] args)
    {
        QueueByStackScratch queueByStackScratch=new QueueByStackScratch();
        queueByStackScratch.enQueue(10);
        queueByStackScratch.enQueue(20);
        queueByStackScratch.enQueue(30);
        queueByStackScratch.enQueue(40);
        queueByStackScratch.display();
        System.out.println("Element dequed.."+queueByStackScratch.deQueue());
        queueByStackScratch.display();


    }


}
