package ru.tantam.ptc.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Tanya on 03.03.2016.
 */
public class PointTests {

  @Test
  public void testDistanceMethod(){
    Point p1 = new Point(1,2);
    Point p2 = new Point(4,6);
    Assert.assertEquals(p1.distance(p2),5.0);
    Assert.assertEquals(p1.distance(p1),0.0);
  }

  @Test
  public void testDistanceFunction(){
    Point p1 = new Point(1,2);
    Point p2 = new Point(4,6);
    Assert.assertEquals(Homework1_2.distance(p1,p2),5.0);
    Assert.assertEquals(Homework1_2.distance(p1,p1),0.0);
  }
}
