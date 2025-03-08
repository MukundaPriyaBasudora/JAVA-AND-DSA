import java.util.Hashtable;
public class LinkedList {
    private int length;
    private int c=0;
    public LinkedList(){
        this.length=0;
    }
    ListNode head;
    public void insertFirst(ListNode node){
        if(head==null){
            head=node;
        }
        else{
            node.setNext(head);
            head=node;
        }
        length++;
    }
    public void insertEnd(ListNode node){
        if (head==null){
            insertFirst(node);
            return;
        }
        ListNode curr=head;
        while(curr.getNext()!=null){
            curr=curr.getNext();
        }
        curr.setNext(node);
        node.setNext(null);
        length++;
    }
    public void insertAtPos(int data, int pos){
        if(pos<0){
            pos=0;
        } if (pos>length) {
            pos=length;

        }
        if(head==null){
            head=new ListNode(data);
        }
        else if(pos==0){
            insertFirst(new ListNode(data));
        }
        else{
            ListNode temp=head;
            for(int i=1;i<pos-1;i++){
                temp=temp.getNext();
            }
            ListNode node=new ListNode(data);
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        length++;
    }
    public ListNode deleteBegin(){
        ListNode node=head;
        if (head.getNext()==null){
            head=null;
            node.setNext(null);
            length--;
            return node;
        }
        head=head.getNext();
        node.setNext(null);
        length--;
        return node;

    }
    public ListNode deleteEnd(){
        ListNode curr=head,prev=null,next=head.getNext();
        if(head.getNext()==null){
            head=null;
            length--;
            return curr;
        }
        while(next!=null){
            prev=curr;
            curr=next;
            next=curr.getNext();
        }
        prev.setNext(null);
        length--;
        return prev;
    }
    public void deleteNode(ListNode node){
        ListNode curr=head;
        ListNode next=head.getNext();
        if(head==null){
            return;
        }
        if(node.equals(head)){
            head=head.getNext();
            return;
        }
        length--;
        while(next!=null) {
            if (node.equals(next)) {
                curr.setNext(next.getNext());
                return;
            }
            curr = next;
            next = curr.getNext();
        }
        curr=next;


    }
    public void display(){
        System.out.println("length="+length);
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.getData()+"->");
            temp=temp.getNext();
        }
        System.out.println(temp);
    }
    //Brute Force approach
    public int find(int n){
        ListNode curr=head;
        while(curr!=null){
            int c=0;
            ListNode next=curr.getNext();
            while(next!=null){
                c++;
                next=next.getNext();
            }
            if(c<n-1){
                return 0;
            }
            else if(c>n-1){
                curr=curr.getNext();
            }
            else{
                return curr.getData();
            }
        }
        return 0;
    }
    // Hashing
    public int findhash(int n){
        Hashtable<Integer,ListNode> table=new Hashtable<Integer,ListNode>();
        ListNode curr=head;
        int len=0;
        int pos=1;
        while(curr!=null){
            table.put(pos++,curr);
            curr=curr.getNext();
            len++;
        }
        return (table.get(len-n+1)).getData();

    }
    //Two pointer approach-efficient approach
    public int findnode(int n){
        ListNode first=head;
        ListNode second=null;
        for(int c=1;c<n;c++){
            first=first.getNext();
        }
        while(first!=null){
            if(second==null){
                second=head;
            }
            else{
                second=second.getNext();
            }
            first=first.getNext();

        }
        if(second!=null){
            return second.getData();
        }
        return -1;
    }
    //without hashtable
    public int findnohash(int n){
        int c=0;
        ListNode temp=head;
        while(temp!=null){
            c++;
            temp=temp.getNext();
        }
        temp=head;
        for(int i=1;i<c-n+1;i++){
            temp=temp.getNext();
        }
        return temp.getData();
    }
    //using recurision
    public ListNode findusingrecursion(ListNode head,int n){
        //int c=0;
        if(head==null){
            return null;
        }
        ListNode node=findusingrecursion(head.getNext(),n);
        c++;
        if(c==n){
            return head;
        }
        return node;
    }
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        ListNode node1=new ListNode(10);
        ListNode node2=new ListNode(20);
        ListNode node3=new ListNode(30);
        ListNode node4 =new ListNode(40);
        l.insertFirst(node1);
        l.insertFirst(node2);
        l.insertFirst(node3);
        l.insertFirst(node4);
        l.display();
        System.out.println(l.findhash(3));
        System.out.println(l.findnode(3));
        System.out.println(l.findnohash(2));
        System.out.println(l.findusingrecursion(node4,4).getData());




    }


}
