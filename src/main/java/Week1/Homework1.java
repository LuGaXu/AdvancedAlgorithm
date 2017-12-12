package Week1;

public class Homework1 {

    public static void main(String []args){
        Homework1 h=new Homework1();
        //System.out.println(h.calFloorSqrt(5));
        Point a=new Point(2,1);
        Point b=new Point(-1,-2);
        Point c=new Point(-1,-2);
        Point d=new Point(4,5);
        //System.out.println(h.isCross(a,b,c,d));
        double list[]=new double[]{1, -2, 3, 10, -4, 7, 2, -5};
        list=h.maxSum(list);
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

    /**
     * 计算叉乘
     *
     * @return
     */
    private double crossProduct(Point a, Point b){
        return  a.x*b.y-a.y*b.x;
    }

    /**
     * 判断两条线段是否相交， a,b 为线段1， c,d为线段2的顶点
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public boolean isCross(Point a, Point b, Point c, Point d){
        Point ac=a.constructVector(c);
        Point ad=a.constructVector(d);
        Point bc=b.constructVector(c);
        Point bd=b.constructVector(d);
        Point ca=c.constructVector(a);
        Point cb=c.constructVector(b);
        Point da=d.constructVector(a);
        Point db=d.constructVector(b);
        double ab=crossProduct(ac,ad)*crossProduct(bc,bd);
        double cd=crossProduct(ca,cb)*crossProduct(da,db);
        if (ab<=0&&cd<=0)
            return true;
        return false;
    }

    /**
     * 求子数组使得其有最大连续子数组和
     * @param a
     * @return
     */
    public double[] maxSum(double []a){
        int start=0;
        int end=0;
        int temp=0;
        double current=0;
        double max=a[0];
        double b[]=new double[a.length];
        b[0]=a[0];
        for (int i=1;i<a.length; i++){
            if (b[i-1]<=0){
                b[i]=a[i];
                temp=i;
            }else{
                b[i]=a[i]+b[i-1];
            }
            if (b[i]>max){
                start=temp;
                end=i;
                max=b[i];
            }
        }
        double[] result=new double[end-start+1];
        for (int i=0;i<result.length; i++){
             result[i]=a[start+i];
        }
        return result;
    }
}

class Point{
    double x;
    double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Point constructVector(Point a){
        return new Point(a.x-this.x, a.y-this.y);
    }
}
