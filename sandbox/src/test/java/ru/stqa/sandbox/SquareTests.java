package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;
import ru.stqa.pft.sandbox.Rectangle;
import ru.stqa.pft.sandbox.Square;


/**
 * Created by marru on 31.05.2017.
 */
public class SquareTests {
/*@Test
    public void testArea(){
        Square s = new Square(5);
    Assert.assertEquals(s.area(),24.0);
    }
@Test
    public void testArea2(){
        Rectangle r=new Rectangle(2,3);
        Assert.assertEquals(r.area(),5.0);
    }*/

@Test
    public void testDistance(){
    Point p=new Point(4,6);
    Point p2= new Point(7,6);
    Assert.assertEquals(p2.distance(p),3.0);
}
}
