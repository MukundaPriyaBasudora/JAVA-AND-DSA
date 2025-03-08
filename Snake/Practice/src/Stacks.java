
public class Stacks {
    protected int capacity;
    public static final int CAPACITY=10;
    protected char[] stack;
    public Stacks(){
        this.capacity=CAPACITY;
        stack=new char[capacity];
    }
    public Stacks(int CAPACITY){
        this.capacity=CAPACITY;
        stack=new char[capacity];
    }
    protected int top=-1;
    public int size(){
         return top+1;
    }
    public boolean isEmpty(){
        return top<0;
    }
    public void push(char ele){
        stack[++top]=ele;
    }
    public char  pop(){
        return stack[top--];

    }
    public char peek(){
        return stack[top];
    }

}
