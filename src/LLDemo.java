/**
 * Created by shivali on 19-May-16.
 */

class ListNode1 {
    private Object data;
    ListNode1 next;

    ListNode1(Object data) {
        this.setData(data);
        next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
public class LLDemo {

    ListNode1 start;
    ListNode1 current;

    /*LLDemo()
    {
        start=null;
    }
*/
    public Object insertE(Object data)
    {

        ListNode1 temp,current;

        if(start==null)
        {
            temp = new ListNode1(data);
            start = temp;
           //System.out.println("Data in start node :"+ temp.getData());
        }

            temp = new ListNode1(data);
            current=start;
            current.next = temp;
            while (current.next != null) {
                current = current.next;

        //    System.out.println(current.getData());
        }
        return current;

    }

    public  void display()
    {
        ListNode1 current;
        current=start;
        while(current.next!=null)
        {
            current=current.next;
            System.out.println("Data : "+ current.getData());

        }
    }

    public static void main(String[] args)
    {
        LLDemo llDemo=new LLDemo();
        llDemo.insertE(10);
        llDemo.insertE(20);
        llDemo.insertE(30);
        llDemo.insertE(40);
        llDemo.insertE(50);

        llDemo.display();


    }
}
