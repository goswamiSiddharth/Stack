package Stack;
import java.util.*;
public class nextGreaterElement {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        System.out.println("enter n");
        int n=sc.nextInt();
        System.out.println("Enter array");
        int arr1[]=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        int arr2[]=new int[n];
        st.push(arr1[arr1.length-1]);
        arr2[arr1.length-1]=-1;
        for(int i=arr1.length-2;i>=0;i--){
            // -a+
            while(st.size()>0 && arr1[i]>=st.peek()){
                st.pop();
            }
            if(st.size()==0){
                arr2[i]=-1;
            }else{
                arr2[i]=st.peek();
            }
            st.push(arr1[i]);
        }

        for(int i=0;i<n;i++){
            System.out.println(arr2[i]);
        }

    }
}
