package Stack;
import java.util.*;
public class stockSpan {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        System.out.println("Enter n");
        int n=sc.nextInt();
        System.out.println("Enetr array");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int span[]=new int[n];
        st.push(0);
        span[0]=1;
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                span[i]=i+1;
            }else{
                span[i]=i-st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.println(span[i]);
        }
    }
}
