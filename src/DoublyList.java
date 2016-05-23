import java.util.Scanner;

/**
 * Created by shivali on 22-May-16.
 */

class DouNode {
    private Object data;
    DouNode next, prev;

    DouNode(Object data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

public class DoublyList {

    DouNode start;
    Scanner scanner=new Scanner(System.in);

    void insertE(Object data) {
        DouNode newNode = new DouNode(data);
        DouNode curr;
        if (start == null) {
            start = newNode;
        } else {
            curr = start;
            while (curr.next != null && curr != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }
    }

    void insertS(Object data)
    {
        DouNode newnode = new DouNode(data);
        if(start==null)
        {
            start=newnode;
        }
        else
        {
            newnode.next=start;
            start.prev=newnode;
            start=newnode;
        }

    }

    void  insertM(Object data)
    {
        System.out.println("Enter the index where you want to insert new node");
        int index=scanner.nextInt();
        DouNode newNode=new DouNode(data);
        DouNode curr=start;

        if(index<=1)
        {
            insertS(data);
            return;
        }

        while (index >1 && curr!=null)
        {
            curr=curr.next;
            index--;
        }

        if(curr==null) {
            System.out.println("Index is bigger than list");
            return;
        }

        newNode.next=curr;
        newNode.prev=curr.prev;
        curr.prev.next=newNode;
        curr.prev=newNode;
        System.out.println("curr data"+curr.getData());
        System.out.println("newNode data"+newNode.getData());

    }

    void  delNode()
    {
        if (start==null)
            System.out.println("List is empty");
        else
        {
            System.out.println("Enter the data u want to delete");
            int data=scanner.nextInt();
            DouNode curr,temp;
            curr=temp=start;
            int curr_data=(Integer) curr.getData();
            while (curr.next!=null && curr_data !=data )
            {
                temp=curr;
                curr=curr.next;
                curr_data=(Integer) curr.getData();
            }

            if(curr==null)
                System.out.println("Data not found");

            System.out.println("Curr data"+curr.getData());
            System.out.println("temp data:"+temp.getData());

            curr.next.prev=curr.prev;
            temp.next=curr.next;


        }
    }

    void reverse()
    {
        DouNode curr=start;
        DouNode temp=null;

        while (curr!=null)
        {
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }

        if(temp!=null)
        {
            start=temp.prev;
        }
    }


    void display() {
        DouNode curr = start;
        System.out.println("List is: ");
        while (curr != null) {
            System.out.println(curr.getData());
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        DoublyList doublyList = new DoublyList();
        doublyList.insertE(10);
        doublyList.insertE(20);
        doublyList.insertE(30);
        doublyList.insertS(5);
        doublyList.insertS(7);
        doublyList.display();
        //doublyList.insertM(15);
       // doublyList.display();
      //  doublyList.delNode();
        doublyList.reverse();
        doublyList.display();
    }
}
