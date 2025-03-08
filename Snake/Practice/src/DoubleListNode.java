public class DoubleListNode {
    private int data;
    private DoubleListNode next;
    private DoubleListNode prev;
    public DoubleListNode(int data){
        this.data=data;
        next=null;
        prev=null;
    }
    public DoubleListNode(int data,DoubleListNode prev,DoubleListNode next){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data=data;
    }
    public DoubleListNode getNext(){
        return next;
    }

    public DoubleListNode getPrev() {
        return prev;
    }
    public void setNext(DoubleListNode node){
        next=node;
    }
    public void setPrev(DoubleListNode node){
        prev=node;
    }
}
