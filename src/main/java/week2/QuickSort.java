package week2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
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
        System.out.println(q.quickSort(array,0, array.length-1));
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
        while (i<=j){
            while (list[i]<=s&&i<=j)
                i++;
            while (list[j]>=s&&i<=j)
                j--;
            swap(list,i,j);
        }
        swap(list,i,j);
        swap(list,j,start);
        return j;
    }

    public void swap(int []  list, int i, int j){
        if (list==null||list.length<j||list.length<i)
            return;
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
        return;
    }
}
