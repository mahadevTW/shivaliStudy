import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by shivali on 23-May-16.
 */

class  StackNode
{
    private Object data;
    StackNode next;

    StackNode()
    {
        this.setData(data);
        next=null;
    }

    StackNode(Object data, StackNode n)
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
    public StackNode getLink()
    {
        return next;
    }
}

public class StackUsingLL {

    StackNode top;

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
        StackNode newNode=new StackNode(data,null);
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
        StackNode temp=top;
        top=temp.getLink();
        size--;
        return  temp.getData();

    }

    public void  display()
    {
        System.out.println("Stack :");

        if (size==0)
        {
            System.out.println("Empty Stack");
            return;
        }
        StackNode temp=top;
        while (temp!=null)
        {
            System.out.println(temp.getData());
            temp=temp.next;
        }
    }


    public static void main(String[] args)
    {
        StackUsingLL stackUsingLL=new StackUsingLL();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Testing Stack");
        char ch;
        do
        {
            System.out.println("Linked Stack Operations:");
            System.out.println("1 Push");
            System.out.println("2 Pop");
            System.out.println("3 Check Empty");
            System.out.println("4 Size");
            System.out.println("5 Display");

            int choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the element you want to push");
                    stackUsingLL.push(scanner.nextInt());
                    break;
                case 2:
                    try {
                        System.out.println("Deleted Element is : "+stackUsingLL.pop());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error message");
                    }
                    break;
                case 3:
                    System.out.println("Empty Status : "+stackUsingLL.isEmpty());
                    break;
                case 4:
                    System.out.println("Size of Stack : "+stackUsingLL.getSize());
                    break;
                case  5:
                    System.out.println("Displaying Stack");
                    stackUsingLL.display();
                    break;
                default:
                    System.out.println("Wrong Entry");
                    break;

            }
            System.out.println("Do you want to continue");
            ch=scanner.next().charAt(0);
        }while (ch=='Y' || ch=='y');
    }
}
