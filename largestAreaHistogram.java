package Stack;
import java.util.*;
public class largestAreaHistogram {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        System.out.println("enter n");
        int n=sc.nextInt();
        System.out.println("enter array");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int rb[]=new int[arr.length]; //next smaller element index to the right
        st.push(arr.length-1);
        rb[arr.length-1]=arr.length;
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i]=arr.length;
            }else{
                rb[i]=st.peek();
            }
            st.push(i);
        }
        int lb[]=new int[arr.length];// next smaller element index to the left
        st.push(0);
        lb[0]=-1;
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                lb[i]=-1;
            }else{
                lb[i]=st.peek();
            }
            st.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int width=rb[i]-lb[i]-1;
            int area=arr[i]*width;
            if(area>=maxArea){
                maxArea=area;
            }
        }
        System.out.println(maxArea);

    }
}
