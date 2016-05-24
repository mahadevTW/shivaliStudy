import java.util.Scanner;

/**
 * Created by shivali on 23-May-16.
 */
class  QueueNode
{
    private  Object data;
    QueueNode next;

    QueueNode(Object data)
    {
        this.setData(data);
        next=null;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

public class QueueDemo
{
    QueueNode front,rear;

    void enqueue(Object data)
    {
        QueueNode newnode=new QueueNode(data);
        if(front==null && rear==null)
        {
            front=rear=newnode;
        }
        rear.next=newnode;
        rear=rear.next;

    }
    public Object dequeue()
    {
        if (front==null)
            return null;

        if(front==rear)
        {
            QueueNode temp=front;
            front=front.next;
            rear=rear.next;
            return temp.getData();
        }

        QueueNode temp=front;
        front=front.next;
        return temp.getData();
    }

    public void display()
    {
        System.out.println("Queue is: ");
        QueueNode temp=front;
        if(temp==null)
        {
            System.out.println("Empty Queue");
        }
        while (temp!= null)
        {
            System.out.println(temp.getData());
            temp=temp.next;
        }
    }

    public static void main(String[] args)
    {
        QueueDemo queueDemo=new QueueDemo();
        Scanner sc=new Scanner(System.in);
        char ch;
        do
        {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter the data you want");
                    queueDemo.enqueue(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Deleted node is : "+queueDemo.dequeue());
                    break;

                case  3:
                    System.out.println("Displaying Queue: ");
                    queueDemo.display();
                    break;

                default:
                    break;
            }
            System.out.println("Do you want to continue");
            ch=sc.next().charAt(0);
        }while(ch=='y'|| ch=='Y');


    }
}
