package Stack;
import java.util.*;
 class Stack1{
    public static class stackBuilt {
        int data[];
        int tos;
        public stackBuilt(int cap){
            data=new int[cap];
            tos=-1;
        }

        int size(){
            return tos+1;
        }

        void push(int val){
            if(tos==data.length-1){
                System.out.println("Stack OverFlow");
            }else{
                tos++;
                data[tos]=val;
            }
        }

        void display(){
            for(int i=data.length-1;i>=0;i--){
                System.out.println(data[i]);
            }
            System.out.println();
        }

        int top(){
            if(tos==-1){
                System.out.println("Stack UnderFlow");
                return -1;
            }else{
                int val=data[tos];
                return val;
                
            }
        }

        int pop(){
            if(tos==-1){
                System.out.println("Stack UnderFlow");
                return -1;
            }else{
                int val=data[tos];
                tos--;
                return val;
            }
        }
    }

    public static void main(String args[]){
        stackBuilt sb=new stackBuilt(5);
        System.out.println(sb.size());
        sb.push(10);
        sb.push(20);
        sb.push(30);
        sb.pop();
        sb.push(40);
        sb.push(50);
        sb.display();
        sb.top();
        
    }

}
