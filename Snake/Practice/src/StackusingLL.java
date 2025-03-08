public class StackusingLL {
    private int length;
    private ListNode top;
    StackusingLL(){
        length=0;
        top=null;
    }
    public void push(int data){
        ListNode temp=new ListNode(data);
        temp.setNext(top);
        top=temp;
        length++;
    }
    public int pop() throws  Exception{
        if(isEmpty()){
            throw new Exception("Stack underflow");

        }
        int res=top.getData();
        top=top.getNext();
        length--;
        return res;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public String toString(){
        String res="";
        ListNode temp=top;
        while(temp!=null){
            res=res+temp.toString()+"\n";
            temp=temp.getNext();
        }
        return res;
    }
}
