import java.util.Scanner;

/**
 * Created by shivali on 20-May-16.
 */

class ListNode4
{
    private Object data;
    ListNode5 next;

    ListNode4(Object data)
    {
        this.setData(data);
        next=null;
    }

    ListNode4()
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
public class ListIntersection {

    static ListNode5 start , start1;

    Scanner scanner=new Scanner(System.in);

    ListIntersection()
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

    int getIntersectionNode(ListNode5 start, ListNode5 start1)
    {

        int c1=getCount(start);
      //  System.out.println(c1);
        int c2=getCount(start1);
      //  System.out.println(c2);
        int d;

        if(c1>c2)
        {
            d=c1-c2;
            return getIntersectionNode(d,start,start1);
        }
        else
        {
            d=c2-c1;
            return  getIntersectionNode(d,start1,start);
        }

    }

    private int getCount(ListNode5 start) {

        ListNode5 curr=start;
        int count=0;
        while(curr !=null)
        {
            count++;
            curr=curr.next;
        }
        return count;
    }

    int getIntersectionNode(int d, ListNode5 start, ListNode5 start1)
    {

        int i,j;
        ListNode5 curr=start;
        ListNode5 curr1=start1;
        for(i=0;i<4;i++)
        {
            for(j=0;j<3;i++)
            {
                System.out.println("hi");
                System.out.println(curr.getData());
                System.out.println(curr1.getData());
                if (curr.getData() == curr1.getData()) {
                    System.out.println("Same data : " + curr.getData());
                    return (Integer) curr.getData();

                }
                curr = curr.next;
                curr1 = curr1.next;
            }
            curr=curr.next;
           /* System.out.println(curr.getData());
            System.out.println(curr1.getData());*/
        }
        return -1;

    }

    public static void main(String[] args) {

        ListIntersection l=new ListIntersection();
        ListNode5 res = null;

        l.start=new ListNode5(10);
        l.start.next=new ListNode5(20);
        l.start.next.next=new ListNode5(30);
        l.start.next.next.next=new ListNode5(40);


        l.display();

        l.start1=new ListNode5(70);
        l.start1.next=new ListNode5(30);
        l.start1.next.next=new ListNode5(40);

        l.display1();


        res.setData(l.getIntersectionNode(start,start1));
        System.out.println("Intersection Node is : "+res.getData());


    }

}
