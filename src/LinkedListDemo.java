import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Constructor;
import java.net.SocketPermission;

/**
 * Created by shivali on 18-May-16.
 */

class ListNode
{
    Object data;
    ListNode next;

    ListNode(Object data)
    {
        this.data=data;
        next=null;
    }

    ListNode()
    {
        data=null;
        next=null;
    }

}
public class LinkedListDemo {

    ListNode start;
    ListNode temp;
    ListNode current;

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
            System.out.println("Data in start node :"+start.data);
        }

        else {
            temp = new ListNode(data);
            current = start;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
            System.out.println("Data is: "+ current.data);
        }

       // return start;
    }


    public  Object  deleteE()
    {
        if(start==null) {
            return null;
        }

         temp=start;
        start.next=start;
        System.out.println("Deleted Data is: "+temp.data);
        return temp.data;


    }

    public static void main(String[] args) {

        LinkedListDemo l=new LinkedListDemo();

        System.out.println("We'r going to insert a new node in our list");
       // l.insertE(10);
        l.insertE(20);
        l.insertE(30);

        System.out.println("We'll delete this current node now");
        l.deleteE();

    }
}
