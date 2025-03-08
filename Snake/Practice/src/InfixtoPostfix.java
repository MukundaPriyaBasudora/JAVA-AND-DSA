public class InfixtoPostfix {
    public int precedence(char ch){
        if(ch=='^'){
            return 3;
        }
        else if(ch=='*'||ch=='/'){
            return 2;
        }
        else if(ch=='+'||ch=='-'){
            return 1;
        }
        else{
            return -1;
        }
    }
    public String conversion(String str){
         StringBuilder result=new StringBuilder();
         Stacks st=new Stacks(30);
         for(int i=0;i<str.length();i++){
             char ch=str.charAt(i);
             if(ch>='a'&&ch<='z'||ch>='A'&&ch<='z'||ch>='0'&&ch<='9'){
                 result.append(ch);
             }
             else if(ch=='('){
                 st.push(ch);
             }
             else if(ch==')'){
                 while(st.peek()!='('){
                     result.append(st.pop());
                 }
                 st.pop();
             }
             else{
                 if(!st.isEmpty()&&(precedence(ch)<=precedence(st.peek()))){
                     result.append(st.pop());
                 }
                 st.push(ch);

             }
         }
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        InfixtoPostfix exp=new InfixtoPostfix();
        String res=exp.conversion("A*B-(C+D)+E");
        System.out.println("result= "+res);
    }
}
