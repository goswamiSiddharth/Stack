package Stack;
import java.util.*;
public class nextGreaterElement2 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        System.out.println("Enter n");
        int n=sc.nextInt();
        System.out.println("enter array");
        int arr1[]=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }

        int arr2[]=new int[n];
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr1[i]>arr1[st.peek()]){
                int pos=st.peek();
                arr2[pos]=arr1[i];
                st.pop();
            }
            st.push(i);
        }

        while(st.size()>0){
            int pos=st.peek();
            arr2[pos]=-1;
            st.pop();
        }

        for(int i=0;i<n;i++){
            System.out.println(arr2[i]);
        }
    }
}
