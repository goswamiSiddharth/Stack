package Stack;
import java.util.*;
public class balancedBraackets {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Character> st=new Stack<>();
        System.out.println("enter string");
        String s=sc.nextLine();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(ch==')'){
                boolean val=handleClosing(st,'(');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch=='}'){
                boolean val=handleClosing(st,'{');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch==']'){
                boolean val=handleClosing(st,'[');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }
        }
        if(st.size()==0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
        public static boolean handleClosing(Stack<Character> st,char ch2){
            if(st.size()==0){
                return false;
            }else if(st.peek()!=ch2){
                return false;
            }else{
                st.pop();
                return true;
            }
        }
    
}
