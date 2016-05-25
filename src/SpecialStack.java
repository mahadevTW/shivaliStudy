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
    StackNode1 top;
    SpecialStack min;
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
            System.out.println("Top "+top.getData());
            min.push(data);
        }
        else
        {
            top=push(data);
            int  top_data=(Integer) data;
            int y=(Integer) pop();//Half implementation left .
            min.push(y);
            if(top_data < y)
            {
                min.push(top_data);
            }
            else
            {
                min.push(y);
            }
        }
    }

    public Object SpecialPop()
    {
        int x=(Integer) pop();
        min.pop();
        return  x;

    }

    public Object SpecialGetMin()
    {
        if (min==null)
            System.out.println("Stack is empty");

        Object x= min.pop();
        int x_data=0;
        if(x!=null)
            x_data=(Integer)x;
        min.push(x_data);
        return x;
    }

    public boolean isEmpty() {
        return true;
    }

    public static void main(String[] args)
    {
        SpecialStack specialStack=new SpecialStack();

        specialStack.SpecialPush(10);
        specialStack.SpecialPush(20);
        specialStack.SpecialPush(30);

        System.out.println("Minimum is "+specialStack.SpecialGetMin());

        specialStack.SpecialPush(5);
        System.out.println("Minimum is "+specialStack.SpecialGetMin());
    }
}

