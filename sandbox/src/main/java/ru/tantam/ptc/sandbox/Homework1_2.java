package ru.tantam.ptc.sandbox;

/**
 * Created by Tanya on 02.03.2016.
 */
public class Homework1_2 {

  public static void main(String[] args) {
    Point p1 = new Point(1,2);
    Point p2 = new Point(4,6);

    System.out.println("Расстояние между точками с координатами (" + p1.x + ", " + p1.y + ")" +
            " и (" + p2.x + ", " + p2.y + ") = "+ distance(p1,p2));

    p1 = new Point(1,3);
    p2 = new Point(4,6);

    System.out.println(",а расстояние между точками с координатами (" + p1.x + ", " + p1.y + ")" +
            " и (" + p2.x + ", " + p2.y + ") = "+ p1.distance(p2));

  }

  public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y),2));
  }


}
