import java.util.* ;
import java.io.*; 

public class Stack {
    int size ;
    //int cap;
    int[] arr ;
    int idx = 0;
    Stack(int cap){
        size = cap;
        arr = new int[size];
    }
    void push(int num) {
        // Write your code here.
        if(idx == size) return ;
        //idx++;
        arr[idx] = num;
        idx++;
    }
    int pop() {
        // Write your code here.
        if(isEmpty() == 1) return -1;
        idx--;
        return arr[idx];
    }
    int top() {
        // Write your code here.
        if(isEmpty() == 1) return -1;
        return arr[idx-1];
    }
    int isEmpty() {
        // Write your code here.
        if(idx == 0) return 1;
        return 0;
    }
    int isFull() {
        // Write your code here.
        if(idx == size) return 1;
        return 0;
    }
}

Time Complexity : O(N)
Space Complexity : O(N)