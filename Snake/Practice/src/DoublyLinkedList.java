public class DoublyLinkedList {
    private DoubleListNode head;
    private DoubleListNode tail;
    private int length;
    public DoublyLinkedList(){
        this.length=0;

    }
    public void insertFirst(DoubleListNode node){
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            node.setNext(head);
            node.getNext().setPrev(node);
            head=node;
        }
        length++;
    }
    public void insertLast(DoubleListNode node){
        if(head==null){
            insertFirst(node);
        }else{
            DoubleListNode temp=head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(node);
            node.setPrev(temp);
            tail=node;
        }
        length++;
    }
    public void insertPos(int data,int pos){
        if(pos<=0){
            insertFirst(new DoubleListNode(data));
        } else if (pos>=length) {
            insertLast(new DoubleListNode(data));

        }
        else{
            DoubleListNode temp=head;
            for(int i=1;i<pos-1;i++){
                temp=temp.getNext();
            }
            DoubleListNode node=new DoubleListNode(data,temp.getPrev(),temp.getNext());
            temp.setNext(node);
            node.setPrev(temp);
            node.getNext().setPrev(node);
        }
        length++;
    }
    public void deleteFirst(){
        if(head.getNext().equals(null)){
            head=null;
            tail=null;
        }
        else{
            head=head.getNext();
            head.setPrev(null);
        }
        length--;
    }
    public void deleteLast(){
        if(head.getNext()==null){
            deleteFirst();
        }
        else{
            DoubleListNode curr=head;
            DoubleListNode prev=null;
            while(curr.getNext()!=null){
                prev=curr;
                curr=curr.getNext();
            }
            curr.setPrev(null);
            prev.setNext(null);
            tail=prev;


        }
        length--;
    }
    public void deleteNode(DoubleListNode node){
        DoubleListNode curr=head;
        DoubleListNode next=head.getNext();
        if(head==null){
            return;
        }
        if(node.equals(head)){
            head=head.getNext();
            head.setPrev(null);
            return;
        }
        length--;
        while(next!=null) {
            if (node.equals(next)) {
                curr.setNext(next.getNext());
                next.getNext().setPrev(curr);
                return;
            }
            curr = next;
            next = curr.getNext();
        }
        curr=next;
        length--;
    }
    public void display(){
        System.out.println("Length is "+length);
        DoubleListNode temp=head;
        while(temp!=null){
            System.out.print(temp.getData()+"->");
            temp=temp.getNext();
        }
        System.out.println(temp);
    }
    public void revdisplay(){
        System.out.println("Length is "+length);
        DoubleListNode temp=tail;
        while(temp!=null){
            System.out.print(temp.getData()+"->");
            temp=temp.getPrev();
        }
        System.out.println(temp);
    }


    public static void main(String[] args) {
        DoublyLinkedList d=new DoublyLinkedList();
        DoubleListNode e1=new DoubleListNode(10);
        DoubleListNode e2=new DoubleListNode(20);
        DoubleListNode e3=new DoubleListNode(30);
        DoubleListNode e4=new DoubleListNode(40);
        DoubleListNode e5=new DoubleListNode(50);
        DoubleListNode e6=new DoubleListNode(60);
//        DoubleListNode e7=new DoubleListNode(70);
//        DoubleListNode e8=new DoubleListNode(80);
//        DoubleListNode e9=new DoubleListNode(90);
        d.insertFirst(e1);
        d.insertFirst(e2);
        d.insertFirst(e3);
        d.display();
        d.revdisplay();
        d.insertLast(e4);
        d.insertLast(e5);
        d.insertLast(e6);
        d.display();
        d.revdisplay();
        d.insertPos(15,4);
        d.display();
        d.revdisplay();
        d.deleteFirst();
        d.display();
        d.revdisplay();
        d.deleteLast();
        d.display();
        d.revdisplay();
        d.deleteNode(e4);
        d.display();
        d.revdisplay();


    }
}
