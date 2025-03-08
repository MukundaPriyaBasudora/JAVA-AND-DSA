import java.util.Scanner;
public class StackProblemSolving {
    Stacks s=new Stacks(20);
    public boolean balancecheck(String str){
        if(str==null||str.length()==0){
            return true;
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')'){
                if(!s.isEmpty()&&s.peek()=='('){
                    s.pop();
                }
                else{
                    return false;
                }
            }
            else if(str.charAt(i)=='}'){
                if(!s.isEmpty()&&s.peek()=='{'){
                    s.pop();
                }
                else{
                    return false;
                }
            }
            else if(str.charAt(i)==']'){
                if(!s.isEmpty()&&s.peek()=='['){
                    s.pop();
                }
                else{
                    return false;
                }
            }
            else{
                try{
                    s.push(str.charAt(i));
                }
                catch (Exception r){
                    System.out.println(r);
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }

    }
    public static void main(String[] args) {
//        Stacks s=new Stacks(5);
        StackProblemSolving p=new StackProblemSolving();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter symbols");
        String str=sc.next();
        boolean ans=p.balancecheck(str);
        if(ans){
            System.out.println("balanced");
        }
        else{
            System.out.println("not balanced");
        }



//
    }
}
