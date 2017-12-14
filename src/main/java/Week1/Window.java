package Week1;

import java.util.LinkedList;

/**
 * Created by lujxu on 2017/12/14.
 */
public class Window {

    LinkedList<Integer> qmin=new LinkedList<>();
    LinkedList<Integer> qmax=new LinkedList<>();


    public static void main(String []args){
        Window w=new Window();
        int []l=new int[]{3,2,1,10,5,4};
        System.out.println(w.getSum(l,3));
    }

    public int getSum(int[] array, int num){
        int i=0;
        int j=0;
        int sum=0;
        while (i<array.length){
            int max=array[i];
            int min=array[i];
            while (j<array.length){
                while (!qmax.isEmpty()&&array[j]>qmax.peekLast())
                    qmax.pollLast();
                qmax.addLast(array[j]);
                while (!qmin.isEmpty()&&array[j]<qmin.peekLast())
                    qmin.pollLast();
                qmin.addLast(array[j]);
                if (qmax.peekFirst()-qmin.peekFirst()>num)
                    break;

                j++;
            }
            sum+=j-i;
            while (!qmax.isEmpty()&&qmax.peekFirst() == array[i]) {
                qmax.pollFirst();
            }
            while (!qmin.isEmpty()&&qmin.peekFirst() == array[i]) {
                qmin.pollFirst();
            }
            i++;
        }
        return sum;
    }
}
