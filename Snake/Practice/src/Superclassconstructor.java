class Superclass{
//    private int n;
    public Superclass(int i){

    }
    public Superclass(String s){
//        this.n=n;
//        System.out.println("value of n:"+n);
    }
    public Superclass(String s,int n){

    }

//    public int getN() {
//        return n;
//    }
}
class Subclass extends Superclass{
    public Subclass(){
        super("mukunda");
    }
    public Subclass(int n){
      super("priya");

    }
    public Subclass(String s){
        super(80);
    }
    public Subclass(int i,String s){
        super(10);
    }
    public Subclass(String i,String s,String k){
        super(i,5);
    }
    public Subclass(int i,int j){
        super("muk",10);
    }
    public Subclass(int i,int x,int y){
        super("hi",8);
    }

}



public class Superclassconstructor {
    public static void main(String[] args) {
        Subclass s=new Subclass(7);
//        System.out.println(s.getN());
    }

}
