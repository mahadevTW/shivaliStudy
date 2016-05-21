
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

    ListNode start;

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

    public static void main(String[] args) {

        LinkedListDemo l=new LinkedListDemo();
                System.out.println("We'r going to insert a new node in our list");
        l.insertE(20);
        l.insertE(30);
        l.insertS(20);
        l.insertE(40);
        l.insertS(10);
        l.display();
       // l.insertE(70);
               //l.display();
       // l.insertM(60);

       // l.display();
        //l.deleteNode();
        //System.out.println("After deletion");
       // l.removeDuplicates();
       // l.addLastNodeToFirst();
        l.delAlternateNodes();
        l.display();


          }




}
