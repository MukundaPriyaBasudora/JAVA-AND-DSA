import java.util.Arrays;
import java.util.Scanner;

public class Arrayspractice {
    public static void insert(int[] a,int ele,int pos){
        for(int i=a.length-1;i>pos;i--){
            a[i]=a[i-1];
        }
        a[pos]=ele;

    }
    public static void delete(int[] a,int pos){
        for(int i=pos;i<a.length-1;i++){
            a[i]=a[i+1];
        }



    }

    public static void main(String[] args) {
        int[] a=new int[13];
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=s.nextInt();
        System.out.println("Enter array elements");
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        System.out.println(Arrays.toString(a));
        insert(a,7,6);
        System.out.println(Arrays.toString(a));
        delete(a,5);
        System.out.println(Arrays.toString(a));

    }
}
