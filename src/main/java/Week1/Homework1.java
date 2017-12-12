package Week1;

public class Homework1 {

    public static void main(String []args){
        Homework1 h=new Homework1();
        System.out.println(h.calFloorSqrt(5));
    }

    /**
     *
     * @param n n>=1
     * @return
     */
    public int calFloorSqrt(int n){
        int i=1;
        for (;; i++){
            int j=i+1;
            if (i*i<=n&&j*j>n){
                return i;
            }
        }
    }
}
