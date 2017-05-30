package ru.stqa.pft.sandbox;

/**
 * Created by marru on 30.05.2017.
 */
public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public double distance(Point p2){

        int x=p2.x-this.x;
        int x2= x*x;
        int y=p2.y-this.y;
        int y2= y*y;
        int xy= x2+y2;
        double z=Math.sqrt(xy);
        return z;
    }

}


