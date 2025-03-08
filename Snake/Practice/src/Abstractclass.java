abstract class Myname{
    abstract public void surname();
    public void lastname(){
        System.out.println("Mukunda priya");
    }

}
class Fullname extends Myname{
    public void surname(){
        System.out.println("Basudora");
    }


}
public class Abstractclass {
    public static void main(String[] args) {
       // Myname m=new Fullname();
        Fullname f=new Fullname();
//        m.surname();
//        m.lastname();
        f.surname();
        f.lastname();
    }
}
