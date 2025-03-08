import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
public class Treeset {
    public static void main(String[] args) {
        new Treeset().go();
    }
    public void go(){
        Book b1=new Book("HeadFirst Java");
        Book b2=new Book("Dsa with Java");
        Book b3=new Book("sumit arora python");
        BookCompare books=new BookCompare();
        Set<Book> tree=new TreeSet<>(books);
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }
}
class Book{
    public String title;
    Book(String t){
        title=t;
    }
    public String toString(){
        return title;
    }
//    public int compareTo(Book other){
//        return title.compareTo(other.title);
//    }
}
class BookCompare implements Comparator<Book>{
    public int compare(Book one,Book two){
        return one.title.compareTo(two.title);
    }
}
