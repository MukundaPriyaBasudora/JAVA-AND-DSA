
public class LLtrial {
    public static void main(String[] args) {
        LL List=new LL();
        List.insertfirst(10);
        List.insertfirst(20);
        List.insertfirst(30);
        List.insertfirst(40);
        List.display();
        List.insertLast(80);
        List.display();
        List.insert(90,0);
        List.display();
        List.insert(100,6);
        List.display();
        List.insert(200,4);
        List.display();
        System.out.println("First element deleted is "+List.deleteFirst());
        List.display();
        System.out.println("Last element deleted is "+ List.deleteLast());
        List.display();
        System.out.println("Last element deleted is "+ List.deleteATpos(2-1));
        List.display();


    }
}
