package Week1;

/**
 * Created by lujxu on 2017/12/14.
 */
public class Matrix {

    public static void main(String []args){
        Matrix m=new Matrix();
        int n[][]=new int[][]{{1,1,0,1,0},{0,0,1,1,1},{0,0,0,1,0},{0,0,0,0,1}};
        System.out.println(m.getSize(n));
    }

    public  int[][] addMatrix(int [][] m){
        int [][] n=new int[m.length][m[0].length];
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                if (m[i][j]==0)
                    n[i][j]=0;
                else if (j>0)
                    n[i][j]=m[i][j]+n[i][j-1];
                else
                    n[i][j]=m[i][j];
            }
        }
        return n;
    }

    public int getSize(int [][]m){
        int max=0;
        int [][]n=addMatrix(m);
        for (int i=0;i<n.length;i++){
            for (int j=0;j<n[0].length;j++){
                if (n[i][j]>max)
                    max=n[i][j];
                if (n[i][j]!=0){
                    int u=1;
                    int a=i-1;
                    while (a>=0){
                        if (n[a][j]>=n[i][j])
                            u++;
                        else
                            break;
                        a--;
                    }
                    a=i+1;
                    while (a<n.length){
                        if (n[a][j]>=n[i][j])
                            u++;
                        else
                            break;
                        a++;
                    }
                    if (max<u*n[i][j])
                        max=u*n[i][j];
                }
            }
        }
        return max;
    }
}
