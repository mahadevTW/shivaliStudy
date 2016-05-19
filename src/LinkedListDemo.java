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

    LinkedListDemo()
    {
        start=null;
    }

    public Object insertE(Object data)
    {

        if(start==null)
        {
            start=new ListNode(data);
        }

        System.out.println("Data is: "+ start.data);
        return start;
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
        l.insertE(10);
        l.insertE(20);
        l.insertE(30);
       // l.display();
        System.out.println("We'll delete this current node now");
        l.deleteE();

    }
}
