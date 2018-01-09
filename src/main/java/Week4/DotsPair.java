package Week4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lujxu on 2018/1/4.
 */
public class DotsPair {
    public void matchPair(List<Dot> wDots, List<Dot> bDots, List<Pair> pairs){
        List<Dot> dots=new ArrayList<>();
        dots.sort(new XComparator());
        dots.addAll(wDots);
        dots.addAll(dots);
        findPair(dots, pairs);
    }

    private void findPair(List<Dot> dots, List<Pair> pairs){
        if (dots.size()<=1) return;
        if (dots.size()==2){
            if (dots.get(0).color.equals(dots.get(1).color)) return;
            pairs.add(new Pair(dots.get(0),dots.get(1)));
            dots.clear();
        }
        int temp=dots.size()/2;
        List<Dot> d1=new ArrayList<>();
        List<Dot> d2=new ArrayList<>();
        for (int i=0;i<temp;i++){
            d1.add(dots.get(i));
        }
        for (int i=temp;i<dots.size(); i++){
            d2.add(dots.get(i));
        }
        findPair(d1, pairs);
        findPair(d2, pairs);
        //对剩下的dot进行连线
        if (!d1.isEmpty()&&!d2.isEmpty()&&!d1.get(0).color.equals(d2.get(0).color)){
            for (int i=0;i<d1.size();i++){
                for (int j=0;j<d2.size(); j++){
                    Pair p=null;
                    if (d1.get(i).color.equals(Color.WHITE))
                        p=new Pair(d1.get(i),d2.get(j));
                    else
                        p=new Pair(d2.get(j),d1.get(i));
                    List<Pair> cross=isCross(pairs, p);
                    //有相交
                    if (!cross.isEmpty()){
                        int k=0;
                        while (k<cross.size()){
                            Pair pair=cross.remove(k);
                            pair=p.swap(pair);
                            k++;
                            List<Pair> t=isCross(cross, pair);
                            if (t.isEmpty()){
                                t=isCross(pairs, p);
                                if (t.isEmpty()){
                                    cross.add(pair);
                                    cross.add(p);
                                    break;
                                }
                            }
                        }
                    }else{
                        d1.remove(i);
                        d2.remove(j);
                        pairs.add(p);
                    }
                }
            }
        }
    }

    private List<Pair> isCross(List<Pair> pairs, Pair p){
        int k=0;
        List<Pair> crossPair=new ArrayList<>();
        boolean isCross;
        while (k<pairs.size()){
            isCross=p.isCross(pairs.get(k));
            if (isCross){
                crossPair.add(pairs.get(k));
                pairs.remove(k);
            }
            k++;
        }
        return crossPair;
    }
}

class  Pair{
    Dot whiteDot;
    Dot blackDot;

    public Pair(Dot whiteDot, Dot blackDot){
        this.whiteDot=whiteDot;
        this.blackDot=blackDot;
    }

    /**
     * 交换whiteDot的位置
     * @param pair
     * @return
     */
    public Pair swap(Pair pair){
        Dot temp=whiteDot.clone();
        this.whiteDot=pair.whiteDot.clone();
        pair.whiteDot=temp;
        return pair;
    }

    /**
     * 判断两条线段是否相交， a,b 为线段1， c,d为线段2的顶点
     *
     * @return
     */
    public boolean isCross(Pair pair){
        Dot a=whiteDot;
        Dot b=blackDot;
        Dot c=pair.whiteDot;
        Dot d=pair.blackDot;
        Dot ac=a.constructVector(c);
        Dot ad=a.constructVector(d);
        Dot bc=b.constructVector(c);
        Dot bd=b.constructVector(d);
        Dot ca=c.constructVector(a);
        Dot cb=c.constructVector(b);
        Dot da=d.constructVector(a);
        Dot db=d.constructVector(b);
        double ab=crossProduct(ac,ad)*crossProduct(bc,bd);
        double cd=crossProduct(ca,cb)*crossProduct(da,db);
        if (ab<=0&&cd<=0)
            return true;
        return false;
    }

    /**
     * 计算叉乘
     * @return
     */
    private double crossProduct(Dot a, Dot b){
        return  a.x*b.y-a.y*b.x;
    }
}

class Dot{
    double x;
    double y;
    Color color;

    public Dot(double x,double y, Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }

    public Dot(double x,double y){
        this.x=x;
        this.y=y;
    }

    public Dot constructVector(Dot a){
        return new Dot(a.x-this.x, a.y-this.y);
    }

    public Dot clone(){
        return new Dot(x,y, color);
    }
}
enum Color{
    BLACK,WHITE
}
class XComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Dot a=(Dot)o1;
        Dot b=(Dot)o2;
        if (a.x<b.x)
            return -1;
        else if (a.x==b.x)
            return 0;
        return 1;
    }
}
