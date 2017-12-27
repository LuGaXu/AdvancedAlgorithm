package week3;


/**
 * Created by lujxu on 2017/12/24.
 */
public class LetterDigit {
    int digit[]=new int[26];

    public LetterDigit(){
        for (int i=0; i<digit.length;i++){
            digit[i]=-1;
        }
    }

    public static void main(String []args){
        LetterDigit l=new LetterDigit();
        l.generateDigit("ABCAB","A","DDDDDD");
       // l.generateDigit("AB","A","AB");
    }

    /**
     *
     * @param multi1
     * @param multi2 假定只有一个字母
     * @param product
     */
    public void calDigit(String multi1, char multi2, String product){
        char [] temp1=reverse(multi1.toCharArray());
        //String[] temp2=reverse(multi2.split(""));
        int multi=multi2-'A';
        char[] letterProduct=reverse(product.toCharArray());
        int add=0;
        for (int i=0;i<temp1.length;i++){
            int c=temp1[i]-'A';
            if (digit[c]==-1){
                for (int j=0; j<9; j++){
                    digit[c]=j;
                    if ( digit[multi]==-1){
                        for (int k=0; k<9; k++){
                            digit[multi]=k;
                            int result=digit[multi]*digit[j]+add;
                            int product1=0;
                            if (result>=10){
                                add=result/10;
                                product1=result%10;
                            }else{
                                product1=result;
                            }
                            if (digit[letterProduct[i]-'A']!=-1&&digit[letterProduct[i]-'A']!=product1){
                                //错误

                            }else if (digit[letterProduct[i]-'A']==-1){
                                digit[letterProduct[i]-'A']=product1;
                            }
                        }
                    }

                }
            }
        }
    }

    public char[] reverse(char [] str){
        char temp[]=new char[str.length];
        for (int i=str.length-1; i>=0; i--){
            temp[str.length-i-1]=str[i];
        }
        return temp;
    }

    public void generateDigit(String multi1, String multi2, String product){
        for (int i=1; i<10; i++){
            Digit.A.setNum(i);
            for (int j=0;j<10;j++){
                if (j==Digit.A.getNum()) continue;
                Digit.B.setNum(j);
                for (int k=0; k<10; k++){
                    if (k==Digit.A.getNum()||k==Digit.B.getNum()) continue;
                    Digit.C.setNum(k);
                    for (int m=1;m<=9;m++){
                        if (m==Digit.A.getNum()||m==Digit.B.getNum()||m==Digit.C.getNum()) continue;
                        Digit.D.setNum(m);
                        int num =getNum(multi1);
                        int result=getNum(product);
                        int multi=Digit.valueOf(multi2).getNum();
                        if (num*multi==result){
                            System.out.println("A="+Digit.A.getNum()+" B="+Digit.B.getNum()+" C="+Digit.C.getNum()+" D="+Digit.D.getNum());
                        }
                    }
                }
            }
        }
    }

    public  int getNum(String str){
        int result=0;
        String []temp=str.split("");
        for (int i=0;i<temp.length;i++){
            result=result*10+Digit.valueOf(temp[i]).getNum();
        }
        return result;
    }
}
enum Digit{
    A,B,C, D;

    private int num;

    private Digit(){
        this.num=-1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
