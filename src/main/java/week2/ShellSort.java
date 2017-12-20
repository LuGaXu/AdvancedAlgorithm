package week2;

/**
 * Created by lujxu on 2017/12/21.
 */
public class ShellSort {

    public static void main(String []args){
        int [] array=new int[]{2,4,1,4,2,9,6,5,3,5};
        ShellSort s=new ShellSort();
        s.shellsort(array);
        System.out.println("test");
    }

    public int [] shellsort(int [] list){
        int gap=(int)list.length/2;
        while (gap!=0){
            shellInsert(list, gap);
            gap=(int)gap/2;
        }
        return list;
    }

    public void shellInsert(int [] list, int gap){
        for (int i=gap;i<list.length;i++){
            int temp=list[i];
            int j=i;
            while (j>=gap&&temp<list[j-gap]){
                list[j]=list[j-gap];
                j=j-gap;
            }
            list[j]=temp;
        }
    }
}
