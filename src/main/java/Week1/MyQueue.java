package Week1;

import java.util.Stack;

/**
 * Created by lujxu on 2017/12/14.
 */
public class MyQueue {
    Stack s1=new Stack();
    Stack s2=new Stack();

    public static void main(String []args){
        MyQueue m=new MyQueue();
        m.enqueue(1);
        m.enqueue(2);
        m.enqueue(3);
        m.enqueue(4);
        for (int i=3;i>=0; i--){
            System.out.println(m.dequeue());
        }
    }

    public void enqueue(int x){
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public Object dequeue(){
        return s1.pop();
    }
}
