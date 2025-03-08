import java.util.Hashtable;
public class Problemsolving {
    ListNode head;
    public void insertFirst(ListNode node){

        if(head==null){
            head=node;
        }
        else{
            node.setNext(head);
            head=node;
        }
    }
    public void display(){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.getData()+"->");
            temp=temp.getNext();
        }
        System.out.println(temp);
    }
    public boolean loop(){
        ListNode temp=head;
        Hashtable<ListNode,Integer> ht=new Hashtable<ListNode,Integer>();
        while(temp!=null){
            if(ht.containsKey(temp)){
                return true;
            }
            ht.put(temp,temp.getData());
            temp=temp.getNext();
        }
        return false;
    }
    //using two pointers
    public boolean cycle(){
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.getNext()!=null)
        {
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){

                return true;
            }
        }
        return false;
    }
    public ListNode startcycle(){
        ListNode slow=head,fast=head;
        boolean found=true;
        while(fast!=null&&fast.getNext()!=null)
        {
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                found=true;
                break;
            }
        }
        if(found){
            while(fast!=slow){
                slow=slow.getNext();
                fast=fast.getNext();
            }
            return fast;
        }
        else{
            return null;
        }

    }
    //insert an element in sorted list
    public void insertinsortedlist(ListNode newnode){
        if(head==null){
            head=newnode;
        }
        else if(newnode.getData()<head.getData()){
            newnode.setNext(head);
            head=newnode;
        }else {
            ListNode curr = head;
            ListNode temp = null;
            while (curr != null && curr.getData() < newnode.getData()) {
                temp = curr;
                curr = curr.getNext();
            }
            temp.setNext(newnode);
            newnode.setNext(curr);
        }
    }
    public void reverse(){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.getNext();
            curr.setNext(prev);
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void reverseusingrecursion(ListNode curr){
        if(curr==null||curr.getNext()==null){
            head=curr;
            return;
        }
        ListNode next=curr.getNext();

        reverseusingrecursion(next);
        next.setNext(curr);
        curr.setNext(null);
    }
    //reverse pairs in a linked list using recursion
//    public ListNode reversepairs(ListNode head){
//        if(head==null||head.getNext()==null){
//            return;
//        }
//        else{
//            ListNode temp=head.getNext();
//            head.setNext(head.getNext().getNext());
//            temp.setNext(head);
//            head=temp;
//            head.getNext().setNext(reversepairs(head.getNext().getNext()));
//            return head;
//        }
//
//
//    }
    public void reversepairs(){
        ListNode temp1=null,temp3=null;
        ListNode temp2=head;
        while(temp2!=null&&temp2.getNext()!=null){
            if(temp1!=null){
                temp1.getNext().setNext(temp2.getNext());
            }
            temp1=temp2.getNext();
            temp2.setNext(temp2.getNext().getNext());
            temp1.setNext(temp2);
            if(temp3==null){
                head=temp1;
                temp3=head;
            }

            temp2=temp2.getNext();
        }

    }

    public static void main(String[] args) {
        Problemsolving l = new Problemsolving();
        Problemsolving l2=new Problemsolving();
        ListNode node1 = new ListNode(40);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(20);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(50);
        ListNode node6 = new ListNode(60);
        ListNode node7 = new ListNode(70);
        l.insertFirst(node1);
        l.insertFirst(node2);
        l.insertFirst(node3);
        l.insertFirst(node4);
        l2.insertFirst(node3);
        l2.insertFirst(node4);
        l2.insertFirst(node5);
        l2.insertFirst(node6);
        l2.insertFirst(node7);
//        ListNode[] nodes={node4,node3,node2,node1};
        l.display();
//        node1.setNext(node2);
//        l.display();
//        System.out.println(l.loop());
//        System.out.println(l.cycle());
//        System.out.println(l.startcycle().getData());
//        l.insertinsortedlist(node5);
//        l.display();
//        l.reverse();
//        l.display();
//        l.reverseusingrecursion(node4);
//        l2.display();
          l.reversepairs();
          l.display();
    }
}
