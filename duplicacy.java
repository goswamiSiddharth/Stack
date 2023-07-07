package Stack;
import java.util.*;
public class duplicacy {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Character> st=new Stack<>();
        System.out.println("Enter string");
        String s=sc.nextLine();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(st.peek()=='('){
                    System.out.println(true);
                    return;
                }else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        System.out.println(false);
    }
}
