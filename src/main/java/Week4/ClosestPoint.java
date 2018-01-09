package Week4;

import java.util.*;

/**
 * Created by lujxu on 2018/1/3.
 */
public class ClosestPoint {
    private Point a=new Point(0,0);
    private Point b=new Point(999,999);
    private double min;

    public static void main(String [] args){
        List<Point> points=new ArrayList<>();
        points.add( new Point(3, 4));
        points.add( new Point(2, 5));
        points.add( new Point(3, 8));
        points.add( new Point(13, 9));
        points.add(new Point(7, 8));
        points.add( new Point(7, 12));
        points.add( new Point(90, 0));
        points.add( new Point(5, 8));
        points.add( new Point(7, 9));
        points.add( new Point(3, 4.5));
        ClosestPoint p=new ClosestPoint();
        p.getCloestPointPair(points);
    }

    public void  getCloestPointPair(List<Point> points){
        min= Integer.MAX_VALUE;
        if (points==null||points.size()<=1)
            return;
        points.sort(new ComparatorY());
        points.sort(new ComparatorX());
        double min=getCloestPoint(points);
        System.out.println("the closest pair is ("+a.x+","+a.y+") and ("+ b.x+","+b.y+")");
        System.out.println(Math.sqrt(min));
    }

    private double getCloestPoint(List<Point> p){
        if (p.size()<=1){
            return 0;
        }else if (p.size()==2){
            double temp=p.get(0).sqrDistance(p.get(1));
            if (temp<min){
                a=p.get(0);
                b=p.get(1);
                min=temp;
            }
            return temp;
        }else if (p.size()==3){
            double d1= p.get(0).sqrDistance(p.get(1));
            double d2= p.get(0).sqrDistance(p.get(2));
            double d3= p.get(1).sqrDistance(p.get(2));
            double temp;
            if (d1<d2){
                temp=d1;
                if (temp<min){
                    a=p.get(0);
                    b=p.get(1);
                    min=temp;
                }
            }else{
                temp=d2;
                if (temp<min){
                    a=p.get(0);
                    b=p.get(2);
                    min=temp;
                }
            }
            if (d3<temp){
                temp=d3;
                if (temp<min){
                    a=p.get(1);
                    b=p.get(2);
                    min=temp;
                }
            }
            return temp;
        }
        int temp=p.size()/2 ;
        List<Point> p1=new ArrayList<>();
        List<Point> p2=new ArrayList<>();
        for (int i=0;i<temp;i++){
            p1.add(p.get(i).clone());
        }
        for (int i=temp;i<p.size();i++){
            p2.add(p.get(i).clone());
        }
        double d1=getCloestPoint(p1);
        double d2=getCloestPoint(p2);
        double d=Math.min(d1,d2);

        List<Point> s=new ArrayList<>();
        double m=p.get(temp).x;
        for (int i=p1.size()-1;i>=0; i--){
            if (m-p1.get(i).x<d)
                s.add(p1.get(i));
            else break;
        }
        for (int i=0;i<p2.size();i++){
            if (p2.get(i).x-m<d)
                s.add(p2.get(i));
        }
        s.sort(new ComparatorY());
        for (int i=0;i<s.size()-1;i++){
            if (s.get(i).sqrDistance(s.get(i+1))<d){
                d=s.get(i).sqrDistance(s.get(i+1));
                if (d<min){
                    a=s.get(i);
                    b=s.get(i+1);
                    min=d;
                }

            }
        }
        return d;
    }
}

class Point{
    double x;
    double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double sqrDistance(Point a){
        return Math.pow(this.x-a.x,2)+Math.pow(this.y-a.y,2);
    }

    public Point clone(){
        return new Point(this.x,this.y);
    }
}

class ComparatorX implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Point a=(Point)o1;
        Point b=(Point)o2;
        if (a.x<b.x)
            return -1;
        else if (a.x==b.x)
            return 0;
        return 1;
    }
}

class ComparatorY implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Point a=(Point)o1;
        Point b=(Point)o2;
        if (a.y<b.y)
            return -1;
        else if (a.y==b.y)
            return 0;
        return 1;
    }
}
