package week5;

/**
 * 三分法解决假币问题
 */
public class CounterfeitCoin {

    public static void main(String [] args){
        int coins []=new int[]{2,2,2,2,2,1,2,2,2,2,2,2,2,2};
        CounterfeitCoin c=new CounterfeitCoin();
        c.checkCoin(coins, 0, coins.length-1);
    }

    public void  checkCoin(int [] coins, int from, int to){
        if (from>to)
            return;
        int n=to-from+1;
        if (from==to){
            System.out.println("第"+(from+1) +"个硬币为假币");
            return;
        }
        int gap=(int)Math.ceil(n/3);
        int to1=from+gap-1;
        int to2=from+2*gap-1;
        int w1=weight(coins, from, to1);
        int w2=weight(coins, to1+1, to2);
        if (w1==w2){
            checkCoin(coins, to2+1, to);
        }else if (w1>w2){
            checkCoin(coins, to1+1, to2);
        }else {
            checkCoin(coins, from, to1);
        }
    }

    private int weight(int [] coins, int from ,int to){
        int weight=0;
        if (from>to||coins.length==0)
            return 0;
        for (int i=from; i<=to; i++){
            weight+=coins[i];
        }
        return  weight;
    }
}
