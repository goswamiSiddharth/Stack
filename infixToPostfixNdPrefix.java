package Stack;

import java.util.*;

public class infixToPostfixNdPrefix {
    public static void main(String argss[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string");
        String s=sc.nextLine();
        Stack<String> postFix=new Stack<>();
        Stack<String> preFix=new Stack<>();
        Stack<Character> ops=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                ops.push(ch);
            }else if((ch>='0'&&ch<='9')||
                    (ch>='a'&&ch<='z')||
                    (ch>='A'&&ch<='Z')){
                postFix.push(ch+""); // char to String
                preFix.push(ch+"");  // char to String

            }else if(ch==')'){
                while(ops.peek()!='('){
                    char op=ops.pop();
                    String post2=postFix.pop();
                    String post1=postFix.pop();
                    String postv=post1+post2+op;
                    postFix.push(postv);

                    String pre2=preFix.pop();
                    String pre1=preFix.pop();
                    String prev=op+pre1+pre2;
                    preFix.push(prev);
                }
                ops.pop();

            }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                while(ops.size()>0 &&
                 ops.peek()!='(' &&
                 precedence(ch)<=precedence(ops.peek())){
                    char op=ops.pop();
                    String post2=postFix.pop();
                    String post1=postFix.pop();
                    String postv=post1+post2+op;
                    postFix.push(postv);

                    String pre2=preFix.pop();
                    String pre1=preFix.pop();
                    String prev=op+pre1+pre2;
                    preFix.push(prev);
                 }
                 ops.push(ch);
            }
        }

        while(ops.size()>0){
            char op=ops.pop();
            String post2=postFix.pop();
            String post1=postFix.pop();
            String postv=post1+post2+op;
            postFix.push(postv);

            String pre2=preFix.pop();
            String pre1=preFix.pop();
            String prev=op+pre1+pre2;
            preFix.push(prev);
        }
        System.out.println(postFix.peek());
        System.out.println(preFix.peek());
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
