
import java.util.ArrayList;
import java.util.Objects;

class Animal{
   public void sound(){
       System.out.println("All animals make sound");
   }
   public void eat(){
       System.out.println("All animals eat food");
   }
   public int legs(int a,int b){
       System.out.println("animals has "+a*b+ " legs");
       return a*b;
   }
}
class Vet{
    public void getShot(Animal a){
        a.eat();
    }
}
class Dog extends Animal{
    public void sound(){
        System.out.println("Dog says Bow Bow");

    }
    public float legs(float a,float b){      //Method overloading .
        System.out.println("animals has "+a*b+ " legs");
        return a*b;
    }

}
class Cat extends Animal{
    public void sound(){
        System.out.println("Dog says meow meow");
    }
}
class Wolf extends Animal{
    public void sound(){
        System.out.println("Wolf says kuuuu kuuuuu");
    }
}

public class Inheritance extends Animal {
    public static void main(String[] args) {
        Object o=new Dog();
        if( o instanceof Dog){
            System.out.println("Hello");
        }

    }
}
