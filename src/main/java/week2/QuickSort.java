package week2;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 使用递归和非递归的方式实现快速排序
 * Created by lujxu on 2017/12/18.
 */
public class QuickSort {

    public static void main(String []args){
        List<Integer> list=new ArrayList<Integer>();
        int [] array=new int[]{2,4,1,4,2,9,6,5,3,5};
        for (int i:array){
            list.add(i);
        }
        QuickSort q=new QuickSort();
       // System.out.println(q.quickSort(array,0, array.length-1));
       // q.getPivot(new int[]{5,5},0,1);
        System.out.println(q.quickSort(array));
        System.out.println("test");
    }

    public int []  quickSort(int [] list, int start, int end){

        if (start<end) {
            int pivot = getPivot(list, start, end);
            quickSort(list, start, pivot - 1);
            quickSort(list, pivot + 1, end);
        }
        return list;
    }

    public int getPivot(int []  list, int start, int end){
        if (start>=end)
            return 0;
        int s=list[start];
        int i=start;
        int j=end;
        while (i!=j){
            while (i<j&&list[j]>s)
                j--;
            if (i<j){
                list[i]=list[j];
                i++;
            }
            while (i<j&&list[i]<s)
                i++;
           if (i<j){
               list[j]=list[i];
               j--;
           }
        }
        list[i]=s;
        return i;
    }

    public void swap(int []  list, int i, int j){
        if (list==null||list.length<j||list.length<i)
            return;
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
        return;
    }

    public int[] quickSort(int [] list){
        Stack<int []> stack=new Stack<>();
        stack.push(list);
        int index=0;
        while (!stack.isEmpty()){
            int [] array=stack.pop();
            if (array.length==0)
                continue;
            if (array.length==1){
                list[index++]=array[0];
                continue;
            }
            int pivot=getPivot(array,0,array.length-1);
            int [] a=null;
            int [] b=null;
            if (pivot!=0)
                a=new int[pivot];
            if (array.length-1!=pivot)
                b=new int[array.length-1-pivot];
            for (int i=0;a!=null&&i<a.length;i++){
                a[i]=array[i];
            }
            for (int i=0;b!=null&&i<b.length;i++){
                b[i]=array[pivot+1+i];
            }
            if (b!=null)
                stack.push(b);
            stack.push(new int[]{array[pivot]});
            if (a!=null)
                stack.push(a);
        }
        return list;
    }
}
