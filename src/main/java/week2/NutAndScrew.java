package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 螺丝和螺母匹配问题
 * Created by lujxu on 2017/12/20.
 */
public class NutAndScrew {

    Map<Integer, Integer> map=new HashMap<>();

    public static void main(String []args) {
        int[] nuts = new int[]{4, 2,  1, 7,  9, 6, 5, 3};
        int[] screws = new int[]{2,  3, 7, 4, 1,  9, 6, 5};
        NutAndScrew n=new NutAndScrew();
        n.sort(nuts, screws, 0, nuts.length-1);
        Map<Integer, Integer> map=n.map;
        System.out.println("test");
    }

    public void sort(int []nuts, int [] screws, int start, int end){
        if (start>end)
            return;
        if (start==end){
                map.put(nuts[start],screws[start]);
                return;
        }
        int nut=nuts[start];
        int s=partition(screws, start, end, nut);
        partition(nuts, start, end, screws[s]);
        map.put(nut, screws[s]);
        sort(nuts, screws, start, s-1);
        sort(nuts, screws, s+1, end);
    }

    public int partition(int []  list, int start, int end, int pivot){
        if (start>=end)
            return 0;
        int [] array=list.clone();
        int s=0;
        int i=0;
        int j=0;
        for (int k=0;k<=end-start; k++){
            if (array[start+k]<pivot){
                list[i+start]=array[start+k];
                i++;
            }else if (array[start+k]>pivot){
                list[end-j]=array[start+k];
                j++;
            }else{
                s=array[start+k];
            }
        }
        list[i+start]=s;
        return i+start;
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
