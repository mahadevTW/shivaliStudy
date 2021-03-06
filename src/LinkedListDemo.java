
        import java.util.Scanner;

        /**
 - * Created by shivali on 18-May-16.
 - */

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

    static ListNode start;

    Scanner scanner=new Scanner(System.in);

    LinkedListDemo()
    {
        start=null;
    }

    public void insertE(Object data)
    {

        ListNode temp,temp1,current;
        if(start==null)
        {
            temp=new ListNode(data);
            start=temp;
            System.out.println("Data in start node :"+ temp.getData());
                        return;
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
        ListNode temp;
        temp=new ListNode(data);
        temp.next=start;
        start=temp;
        System.out.println("Element inserted at start is: "+ temp.getData());
    }

    public  void  insertM(Object data)
    {

                System.out.println("Enter Index at which you want to insert data");
        int index=scanner.nextInt();

                if(index <1){
                    insertS(data);
                    return;
                }

                ListNode temp = start;
                while (index >1 &&temp !=null){
                    temp = temp.next;
                    index --;
                }
                if(temp ==null){
                    System.out.println("Index is Bigger than the List..");
                    return;
                }
                ListNode temp1 =new ListNode(data);
                temp1.next = temp.next;
                temp.next = temp1;
    }

    public void display()
    {
        ListNode current;
        current=start;
        System.out.println("List is :");

                while(current!=null)
    {

        System.out.println(current.getData());
                    current=current.next;                //just rearranged statments.

    }
    }



       public  void deleteNode()
    {

        if (start == null)
        {

                    System.out.println("List Is empty");
                      return;
        } else
        {

                        System.out.println("Enter data you want to delete");
                        int dataToDelete = scanner.nextInt();
                        ListNode temp,temp1;
                        int count = 0;
                        temp = temp1=start;

                                while ((temp != null) && (dataToDelete !=(Integer)(temp.getData()))) {
                            temp1 = temp;
                            temp =temp.next;
                        }
                        if(temp ==null){
                            System.out.println("Data not found");
                            return;
                        }
                        //data found delete the data..
                               temp1.next = temp.next;  //delete the data at temp location..
        }


    }

    void removeDuplicates()
    {
        ListNode curr=start;
        ListNode curr_next,curr1;

        while(curr!=null)
        {
            if(curr.getData()==curr.next.getData() && curr.next!=null)
            {
                curr_next=curr.next.next;
                curr.next=curr_next;
            }
            else
            {
                curr=curr.next;
            }
        }
    }

    void addLastNodeToFirst()
    {
        ListNode last,secLast;
        last=start;
        secLast=null;
        while (last.next!=null)
        {
           secLast=last;
            last=last.next;
        }
        secLast.next=null;
        last.next=start;

        start=last;
    }

    void delAlternateNodes()
    {
        ListNode curr,curr_next;
        curr=start;
        curr_next=curr.next;

        while(curr!=null && curr_next!=null)
        {
            curr.next=curr_next.next;
            curr=curr.next;
            //Instead if we use curr_next=curr_next.next then at second iteration both point to same node and so create problem
            if(curr!=null)
                curr_next=curr.next;
        }

    }

    void insertinSortedOrder( Object data)
    {
        ListNode curr=start;
        ListNode newNode = new ListNode(data);

        int startData=(Integer)start.getData();
        int newNodedata =(Integer)newNode.getData();

        if(start==null|| startData > newNodedata)
        {
            newNode.next=start;
            start=newNode;
        }
        else
        {
            int curr_data= (Integer)curr.next.getData();
            while(curr.next!=null && curr_data < newNodedata)
            {
                curr=curr.next;
            }
            System.out.println("Start Data "+startData+" New Node data "+newNodedata+" Current Data "+curr_data);

            if(curr.next==null) {
                 System.out.println("curr next pointer is null");
             }
            else
             {
                 System.out.println("cuu next pointer in not null");
             }

            //Link is not being created...Here's a problem.
            newNode.next=curr.next;
            curr.next=newNode;

            if(newNode.next==null) {
                System.out.println("newnode next pointer is null");
            }
            else
            {
                System.out.println("newnode next pointer in not null");
            }
            //System.out.println("New Node Next Data "+curr.next.getData());

        }
    }

    void pairwiseSwap()
    {
        ListNode curr=start;
        ListNode tem =new ListNode(90);

        while(curr!=null && curr.next!=null)
        {
            tem.setData(curr.getData());
            curr.setData(curr.next.getData());
            curr.next.setData(tem.getData());

            curr=curr.next.next;

        }
    }

    void recursivereverseLL(ListNode start)
    {
        if(start==null)
            return;

        recursivereverseLL(start.next);
        System.out.println("Data in reverse is "+start.getData());
    }

    void alternateNode(ListNode start)
    {
        if(start==null)
            return;
        System.out.println("Data is "+start.getData());

        if(start.next!=null)
        {
            alternateNode(start.next.next);
        }
        System.out.println("Data after second if is "+start.getData());
    }

    void segregateEvnOdd()
    {
        ListNode End=start;
        ListNode new_end=null;
        ListNode curr=start;
        int curr_data ;
        ListNode prev=null;

        while (End!= null && End.next!=null)
        {
            End=End.next;
        }
        new_end=End;
        curr_data=(Integer)curr.getData();

        //Finds odd node and links them to new_end of last node of original list.
        while (curr_data %2 !=0 && curr !=End)
        {

            System.out.println("Current data "+curr_data);
            new_end.next=curr;
            curr=curr.next;
            new_end.next.next=null;
            new_end=new_end.next;
            curr_data=(Integer)curr.getData();

        }

        //For even node in list
        if(curr_data%2==0)
        {

            start=curr;
            while (curr!=End)
            {
                if(curr_data%2==0 && curr!= null)
                {
                    prev=curr;
                    curr=curr.next;
                    curr_data=(Integer)curr.getData();
                   // System.out.println("Current data ... "+curr_data);
                }
                else
                {
                       System.out.println("Current data ... "+curr_data);
                        prev.next = curr.next;
                        curr.next = null;
                        new_end.next = curr;
                        new_end = curr;
                        curr = prev.next;
                        curr_data=(Integer)curr.getData();
                        System.out.println("Current data !!! "+curr_data);
                }
            }
        }

        else
            prev =curr;

        int end_data=(Integer)End.getData();
        if (new_end != End && end_data%2 !=0)
        {
            prev.next=End.next;
            End.next=null;
            new_end.next=End;
        }
        return;

    }

    public void pairwiseSwapByLinks()
    {
        ListNode prev=start;
        ListNode curr=start.next;

        start=curr;

        while(true)
        {
            ListNode next1=curr.next;
            curr.next=prev;

            if(next1== null || next1.next==null)
            {
                prev.next=next1;
                break;
            }
            prev.next=next1.next;

            prev=next1;
            curr=prev.next;

        }

    }

    void rotateLL(int k)
    {
        ListNode curr=start;
        int count=1;
        ListNode kthNode;

        while (curr.next!=null && count< k)
        {
            curr=curr.next;
            count++;
        }

        kthNode=curr;

        while ( curr.next!=null && curr !=null)
        {
            curr=curr.next;
        }

        curr.next=start;
        start=kthNode.next;
        kthNode.next=null;

    }

    void delMNodeAftrNNode(int m,int n)
    {
        ListNode curr,temp1;
        curr=temp1=start;

        int count=1,count1=1;
        while (curr!=null && curr.next!=null)
        {
            while (curr.next != null && count < m) {
                curr = curr.next;
                temp1 = temp1.next;
                count++;
            }

            while (count1 < n && temp1.next != null ) {
                temp1 = temp1.next;
                count1++;
            }

            curr.next = temp1.next.next;
            temp1 = temp1.next;
            curr = temp1;
        }

    }

    void delLargeValue()
    {
        ListNode curr=start;
        ListNode curr1;
        int curr_data,curr_nxt_data;

        while(curr!=null && curr.next!=null)
        {
            curr_data=(Integer) curr.getData();
            curr_nxt_data=(Integer) curr.next.getData();

            curr1=curr;
            curr=curr.next;
            if(curr_data < curr_nxt_data)
            {
                start=curr;
                curr=curr.next;
                curr1=curr1.next;
            }
            curr=curr.next;

        }
    }

    public static void main(String[] args) {

        LinkedListDemo l=new LinkedListDemo();
        System.out.println("We'r going to insert a new node in our list");
        l.insertE(15);
        l.insertE(10);
        //l.insertS(20);
        l.insertE(11);
        l.insertE(5);
        l.insertE(6);
        l.insertE(2);
        l.insertE(3);
       // l.insertE(9);
        l.insertS(12);
        l.display();
       // l.insertE(70);
               //l.display();
       // l.insertM(60);

       // l.display();
        //l.deleteNode();
        //System.out.println("After deletion");
       // l.removeDuplicates();
       // l.addLastNodeToFirst();
       // l.delAlternateNodes();
       // l.insertinSortedOrder(25);     //Function doest work accordingly.
       // l.pairwiseSwap();
       // l.recursivereverseLL(start);
        //l.alternateNode(start);
        //l.segregateEvnOdd();
        //l.pairwiseSwapByLinks();
        //l.rotateLL(3);
        //l.delMNodeAftrNNode(2,2);
        l.delLargeValue();
        l.display();


          }




}
