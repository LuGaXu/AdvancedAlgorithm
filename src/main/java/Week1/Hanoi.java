package Week1;

import java.util.Stack;

/**
 * Created by lujxu on 2017/12/14.
 */
public class Hanoi {
    Pillars[] pillars=new Pillars[3];

    public static void main(String []args){
        Hanoi h=new Hanoi();
        h.hanoi(4);
    }

    private void init(int n){
        pillars[0]=new Pillars("A");
        if (n%2==0){
            pillars[1]=new Pillars("B");
            pillars[2]=new Pillars("C");
        }else{
            pillars[1]=new Pillars("C");
            pillars[2]=new Pillars("B");
        }
         for (int i=n;i>0;i--){
            pillars[0].push(i);
         }
    }

    public void hanoi(int n){
        init(n);
        int i=0;
        int count=0;
        int max=(int) Math.pow(2,n)-1;
        while (count<max){
            count++;
            int p=pillars[i%3].pop();
            pillars[(i+1)%3].push(p);
            System.out.println("move disk "+p+" from "+pillars[i%3].name+" to "+pillars[(i+1)%3].name);
            i++;
            if (pillars[(i+1)%3].isEmpty()||((!pillars[(i-1)%3].isEmpty())&&pillars[(i-1)%3].peek()<pillars[(i+1)%3].peek())){
                count++;
                if (count>=max) break;
                int p1=pillars[(i-1)%3].pop();
                pillars[(i+1)%3].push(p1);
                System.out.println("move disk "+p1+" from "+pillars[(i-1)%3].name+" to "+pillars[(i+1)%3].name);
            }else {
                count++;
                if (count>=max)break;
                int p2=pillars[(i+1)%3].pop();
                pillars[(i-1)%3].push(p2);
                System.out.println("move disk "+p2+" from "+pillars[(i+1)%3].name+" to "+pillars[(i-1)%3].name);
            }
        }
    }
}

class Pillars extends Stack<Integer>{
    String name;

    public Pillars(String name){
        this.name=name;
    }
}
