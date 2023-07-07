package Stack;
import java.util.*;
public class preFixEvaluation {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String s=sc.nextLine();
        Stack<Integer> vs=new Stack<>();
        Stack<String> is=new Stack<>();
        Stack<String> pos=new Stack<>();

        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                int v1=vs.pop();
                int v2=vs.pop();
                int vals=operation(v1,v2,ch);
                vs.push(vals);

                String iv1=is.pop();
                String iv2=is.pop();
                String vali="("+iv1+ch+iv2+")";
                is.push(vali);

                String pov1=pos.pop();
                String pov2=pos.pop();
                String valpo=pov1+pov2+ch;
                pos.push(valpo);
            }else{
                vs.push(ch-'0');
                is.push(ch+"");
                pos.push(ch+"");

            }
        }
        System.out.println(vs.pop());
        System.out.println(is.pop());
        System.out.println(pos.pop());
    }

    public static int operation(int v1,int v2,char ch){
        if(ch=='+'){
            return v1+v2;
        }else if(ch=='-'){
            return v1-v2;
        }else if(ch=='*'){
            return v1*v2;
        }else{
            return v1/v2;
        }
    }
}
