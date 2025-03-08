public class LL {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    public LL(){
        this.size=0;
    }
    public void insertfirst(int val){
        Node node =new Node(val);
        node.next=head;
        head=node;
        if(tail==null) {
            tail = head;
        }
        size++;
    }
    public void display(){
        System.out.println(size);
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-> ");
            temp=temp.next;
        }
        System.out.println("end");
    }
    public void insertLast(int val){
        if(tail==null){
            insertfirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;

    }
    public void insert(int val,int pos){
        if(pos==0){
            insertfirst(val);
            return;
        }
        if(pos==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for(int i=1;i<pos;i++){
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public int deleteFirst(){
        int value= head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }
    public Node getIdx(int idx){
        Node node=head;
        for(int i=0;i<idx;i++){
            node=node.next;
        }
        return node;
    }
    public int deleteLast(){
        int value=tail.value;
        Node secondlast=getIdx(size-2);
        secondlast.next=secondlast.next.next;
        size--;
        return value;
    }
    public int deleteATpos(int idx){
        Node prev=getIdx(idx);
        int value=prev.value;
        prev.next=prev.next.next;
        size--;
        return value;
    }




}
