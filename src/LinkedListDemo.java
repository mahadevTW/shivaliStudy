import java.util.Scanner;

/**
 * Created by shivali on 18-May-16.
 */

class ListNode
{
    private Object data;
    ListNode next;

    ListNode(Object data)
    {
        this.setData(data);
        next=null;
    }

    ListNode()
    {
        setData(null);
        next=null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
public class LinkedListDemo {

    ListNode start;
    ListNode temp,temp1,temp2;
    ListNode current;
    Scanner scanner=new Scanner(System.in);

    LinkedListDemo()
    {
        start=null;
    }

    public void insertE(Object data)
    {

        if(start==null)
        {
            temp=new ListNode(data);
            start=temp;
            System.out.println("Data in start node :"+ temp.getData());
        }

        else {

            temp1 = new ListNode(data);
            current = start;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp1;
            System.out.println("Data is: " + temp1.getData());
        }

       // return start;
    }

    public void insertS(Object data)
    {
        temp=new ListNode(data);
        temp.next=start;
        start=temp;
        System.out.println("Element inserted at start is: "+ temp.getData());
    }

    public  void  insertM(Object data)
    {
        int count=0;
        System.out.println("Enter node after which you want to insert data");
        int index=scanner.nextInt();
        temp=start;
        temp1=temp;
        while (count!=index);
        {
            temp=temp.next;
            temp1=temp.next.next;
            count++;
        }

        temp2.next=new ListNode(data);
        temp.next=temp2;
        temp2.next=temp1;
        System.out.println("Data in middle is :"+temp.getData());
    }

    public void display()
    {
        current=start;
        System.out.println("List is :");
        while(current.next!=null)
        {
            current=current.next;
            System.out.println(current.getData());
        }
    }


    public  Object  deleteE(int index)
    {
        int count = 0;
        if (start == null) {
            return null;
        } else
        {

            temp = start;
            while (temp.next != null) {
                if (count == index)
                    break;
                count++;
                System.out.println("Count: "+count+"Index: "+index);
                temp = temp.next;
            };
            System.out.println("Data to be deleted is:" + temp.getData());
            temp.setData(null);
            System.out.println("Data to be deleted is:" + temp.getData());

            return temp;
        }


    }

    public static void main(String[] args) {

        LinkedListDemo l=new LinkedListDemo();

        System.out.println("We'r going to insert a new node in our list");
        l.insertE(10);
        l.insertE(20);
        l.insertS(30);
        l.insertE(40);
        l.insertS(50);
        l.display();
        l.insertM(60);

        l.display();

        System.out.println("Enter the index at which you want to delete the node:");

      //  int index=scanner.nextInt();
       // l.deleteE(index);

    }
}
