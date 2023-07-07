package Stack;
import java.util.*;
public class slidingWindowMaximum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        System.out.println("enter n");
        int n=sc.nextInt();
        System.out.println("enter k");
        int k=sc.nextInt();
        System.out.println("enter array");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int arr2[]=new int[n];

        st.push(arr.length-1);
        arr2[arr.length-1]=arr.length;
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                arr2[i]=arr.length;
            }else{
                arr2[i]=st.peek();
            }
            st.push(i);
        }

        int j=0;
        for(int i=0;i<=n-k;i++){
            if(j<i){
                j=i;
            }
            while(arr2[j]<i+k){
                j=arr2[j];
            }
            System.out.println(arr[j]);
        }
    }
}
