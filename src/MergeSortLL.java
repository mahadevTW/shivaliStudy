/**
 * Created by shivali on 21-May-16.
 */

class ListNode5
{
    private Object data;
    ListNode5 next;

    ListNode5(Object data)
    {
        this.setData(data);
        next=null;
    }

    ListNode5()
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

public class MergeSortLL {

    static ListNode5 start;
    static ListNode5 start1;

    MergeSortLL()
    {
        start=null;
        start1=null;
    }

    public void insertE(Object data)
    {

        ListNode5 temp,temp1,current;
        if(start==null || start1==null)
        {
            temp=new ListNode5(data);
            start=temp;
            System.out.println("Data in start node :"+ temp.getData());
            return;
        }

        else {

            temp1 = new ListNode5(data);
            current = start;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp1;
            System.out.println("Data is: " + temp1.getData());
        }

        // return start;
    }

    public void insertE2(Object data)
    {

        ListNode5 temp,temp1,current;
        if( start1==null)
        {
            temp=new ListNode5(data);
            start1=temp;
            System.out.println("Data in start node :"+ temp.getData());
            return;
        }

        else {

            temp1 = new ListNode5(data);
            current = start1;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp1;
            System.out.println("Data is: " + temp1.getData());
        }

        // return start;
    }

    public void display1()
    {
        ListNode5 current;
        current=start1;
        System.out.println("List is :");

        while(current!=null)
        {

            System.out.println(current.getData());
            current=current.next;                //just rearranged statments.
        }
    }


    public void display()
    {
        ListNode5 current;
        current=start;
        System.out.println("List is :");

        while(current!=null)
        {

            System.out.println(current.getData());
            current=current.next;                //just rearranged statments.
        }
    }

    private static ListNode5 SortedMerge(ListNode5 start, ListNode5 start1)
    {
        ListNode5 dummy=new ListNode5(0),tail;
        tail=dummy;
        dummy.next=null;

        while(true)
        {
            if(start==null)
            {
                tail.next =start1;
                break;
            }
            else if(start1== null)
            {
                tail.next=start;
                break;
            }
            if(start.getData()==start1.getData())
            {
                MoveNode(tail.next,start);
            }
            else
            {
                MoveNode(tail.next, start1);
                if(tail.next==null)
                    break;
            }
            tail=tail.next;
        }
        return (dummy.next);


    }

    private static void MoveNode(ListNode5 dest, ListNode5 source) {

        ListNode5 newnode= source;
        assert (newnode!=null);

        source=newnode.next;

        newnode.next=dest;
        dest=newnode;
    }


    public static void main(String[] args)
    {
        MergeSortLL mergeSortLL=new MergeSortLL();
        ListNode5 res;

        mergeSortLL.start=new ListNode5(10);
        mergeSortLL.start.next=new ListNode5(30);
        mergeSortLL.start.next.next=new ListNode5(50);

        mergeSortLL.display();

        mergeSortLL.start1=new ListNode5(20);
        mergeSortLL.start1.next=new ListNode5(40);
        mergeSortLL.start1.next.next=new ListNode5(60);

        mergeSortLL.display1();

        res=SortedMerge(start,start1);
        System.out.println("Merged List is "+res.getData());
    }


}
