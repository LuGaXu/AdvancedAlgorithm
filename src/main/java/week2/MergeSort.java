package week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算数组中的倒置数量
 * Created by lujxu on 2017/12/19.
 */
public class MergeSort {
    private int count;

    public static void  main(String [] args){
        MergeSort m=new MergeSort();
        int [] array=new int[]{6, 5, 4, 7, 3, 2, 8};
        System.out.println(m.mergeSort1(array));
        System.out.println("test");
    }

    /**
     *
     * @param list
     * @return 倒置元素对的数量
     */
    public int  mergeSort(int [] list){
        if (list.length<=1)
            return 0;
        int s=(int)list.length/2;
        int [] a1=new int[s];
        int [] a2=new int[list.length-s];
        //copy A1
        for (int i=0;i<s;i++){
            a1[i]=list[i];
        }
        for (int i=0;i<list.length-s;i++){
            a2[i]=list[s+i];
        }
        mergeSort(a1);
        mergeSort(a2);
        count+=merge(a1,a2,list, count);
        return count;
    }

    public int merge(int []a1, int [] a2, int [] result,int reverseNum){
        int i=0;
        int j=0;
        int index=0;
        while (i<a1.length&&j<a2.length){
            if (a1[i]<=a2[j])
                result[index]=a1[i++];
            else {
                result[index] = a2[j++];
                reverseNum+=a1.length-i;
            }
            index++;
        }
        while (i<a1.length) {
            result[index++] = a1[i++];
        }
        while (j<a2.length){
            result[index++]=a2[j++];
        }
        return reverseNum;
    }

    /**
     * 非递归形式实现归并排序
     * @param list
     * @return
     */
    public int [] mergeSort1(int [] list){
        if (list.length<=1)
            return list;
        int arraySize=1;
        while (arraySize<list.length){
            Queue<int[]> queue=new LinkedList<>();
            int i=0;
            while (i<list.length){
                int [] temp=new int[i<list.length-list.length%arraySize?arraySize:list.length%arraySize];
                int index=0;
                while (index<arraySize&&i<list.length){
                    temp[index++]=list[i++];
                }
                queue.add(temp);
            }
            int j=0;
            //sort
            while (queue.peek()!=null){
                merge1(queue.poll(),queue.peek()==null?new int[0]:queue.poll(),list,j);
                j+=2*arraySize;
            }
            arraySize=2*arraySize;
        }
        return list;
    }

    public void merge1(int []a1, int [] a2, int [] result,int start){
        int i=0;
        int j=0;
        int index=0;
        while (i<a1.length&&j<a2.length){
            if (a1[i]<=a2[j])
                result[index+start]=a1[i++];
            else {
                result[index+start] = a2[j++];
            }
            index++;
        }
        while (i<a1.length) {
            result[index+start] = a1[i++];
            index++;
        }
        while (j<a2.length){
            result[index+start]=a2[j++];
            index++;
        }
    }

}
