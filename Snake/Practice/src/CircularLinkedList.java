import java.util.List;

public class CircularLinkedList {
    ListNode head,tail;
    private int length;
    public CircularLinkedList(){
        this.length=0;
    }
    public void insertFirst(ListNode node){
        if(head==null){
            head=node;
            tail=node;
            head.setNext(node);
            length++;
            return ;
        }
        node.setNext(tail.getNext());
        tail.setNext(node);
        head=node;
        length++;
    }

    public void deleteFirst(){
        ListNode dummyhead=head;
        if(head==head.getNext()){
            head=null;
            tail=null;
        }
        else{
            head=head.getNext();
            tail.setNext(head);
            dummyhead.setNext(null);
        }

    }

    public void display(){
        ListNode dummyhead=head;
        while(dummyhead.getNext()!=head){
            System.out.print(dummyhead.getData()+"->");
            dummyhead=dummyhead.getNext();
        }
        System.out.println(dummyhead.getData()+" headnode ");
    }

    public static void main(String[] args) {
        CircularLinkedList c=new CircularLinkedList();
        ListNode a1=new ListNode(10);
        ListNode a2=new ListNode(20);
        ListNode a3=new ListNode(30);
        ListNode a4=new ListNode(40);
        c.insertFirst(a1);
        c.insertFirst(a2);
        c.insertFirst(a3);
        c.insertFirst(a4);
        c.display();
        c.deleteFirst();
        c.display();




    }


}
