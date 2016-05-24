import java.util.NoSuchElementException;

/**
 * Created by shivali on 23-May-16.
 */

class  StackNode1
{
    private Object data;
    StackNode1 next;

    StackNode1()
    {
        this.setData(data);
        next=null;
    }

    StackNode1(Object data, StackNode1 n)
    {
        this.setData(data);
        next=n;
    }

    public Object getData()
    {
        return  data;
    }
    public void setData(Object data)
    {
        this.data=data;
    }
    public StackNode1 getLink()
    {
        return next;
    }
}

public class SpecialStack
{
    StackNode1 top,min;
    int size=0;

    public StackNode1 push(Object data)
    {
        StackNode1 newNode=new StackNode1(data,null);
        if (top==null)
        {
            top=newNode;
        }
        else
        {
            newNode.next=top;
            top=newNode;
        }
        size++;
        return newNode;
    }

    public Object pop()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Underflow Exception");
        }
        StackNode1 temp=top;
        top=temp.getLink();
        size--;
        return  temp.getData();

    }

    public void SpecialPush(Object data)
    {
        StackNode1 newnode=new StackNode1(data,null);
        if(isEmpty())
        {
            top=push(data);
            min=push(data);
        }
        else
        {
            top=push(data);
            //Half implementation left .
        }
    }



    public boolean isEmpty() {
        return true;
    }
}

