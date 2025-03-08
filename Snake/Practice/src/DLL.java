public class DLL {
    private Node head;
    private int size;
    private class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next,Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
    }
    public DLL(){
        this.size=0;
    }
    public void insertFirst(int value){
        Node node= new Node(value);
        node.next=head;
        node.prev=null;
        if(head!=null) {
            head.prev = node;
        }
        head=node;
        size++;

    }
    public void display(){
        System.out.println("Size="+size);
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.print("end");
        System.out.println();
    }
    public void revdisplay(){
        System.out.println("Size="+size);
        Node node=head;
        Node last=null;
        while(node!=null){
           last=node;
           node=node.next;
        }
        while(last!=null){
            System.out.print(last.value+"->");
            last=last.prev;
        }

        System.out.print("Start");
        System.out.println();
    }
    public void insertLast(int value){
        if(head==null){
            insertFirst(value);
            return;
        }
        Node newnode=new Node(value);
        Node node=head;
        while(node.next!=null){
            node=node.next;
        }
        newnode.prev=node;
        newnode.next=null;
        node.next=newnode;
        size++;
    }
    public void insert(int val,int idx){
        if(idx==0) {
            insertFirst(val);
            return;
        }
        if(idx==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for(int i=1;i<idx;i++){
            temp=temp.next;
        }
        Node node=new Node(val);
        node.next=temp.next;
        node.prev=temp;
        temp.next=node;
        if (node.next != null) {
            node.next.prev = node;
        }
        size++;
    }

}
