import java.util.Scanner;

/**
 * Created by shivali on 20-May-16.
 */

class ListNode4
{
    private Object data;
    ListNode4 next;

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

    static ListNode4 start , start1;

    Scanner scanner=new Scanner(System.in);

    ListIntersection()
    {
        start=null;
        start1=null;
    }

    public void insertE(Object data)
    {

        ListNode4 temp,temp1,current;
        if(start==null || start1==null)
        {
            temp=new ListNode4(data);
            start=temp;
            System.out.println("Data in start node :"+ temp.getData());
            return;
        }

        else {

            temp1 = new ListNode4(data);
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

        ListNode4 temp,temp1,current;
        if( start1==null)
        {
            temp=new ListNode4(data);
            start1=temp;
            System.out.println("Data in start node :"+ temp.getData());
            return;
        }

        else {

            temp1 = new ListNode4(data);
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
        ListNode4 current;
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
        ListNode4 current;
        current=start;
        System.out.println("List is :");

        while(current!=null)
        {

            System.out.println(current.getData());
            current=current.next;                //just rearranged statments.
        }
    }

    int getIntersectionNode( ListNode4 start,ListNode4 start1)
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

    private int getCount(ListNode4 start) {

        ListNode4 curr=start;
        int count=0;
        while(curr !=null)
        {
            count++;
            curr=curr.next;
        }
        return count;
    }

    int getIntersectionNode(int d,ListNode4 start,ListNode4 start1)
    {

        int i,j;
        ListNode4 curr=start;
        ListNode4 curr1=start1;
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
        ListNode4 res = null;

        l.start=new ListNode4(10);
        l.start.next=new ListNode4(20);
        l.start.next.next=new ListNode4(30);
        l.start.next.next.next=new ListNode4(40);


        l.display();

        l.start1=new ListNode4(70);
        l.start1.next=new ListNode4(30);
        l.start1.next.next=new ListNode4(40);

        l.display1();


        res.setData(l.getIntersectionNode(start,start1));
        System.out.println("Intersection Node is : "+res.getData());


    }

}
