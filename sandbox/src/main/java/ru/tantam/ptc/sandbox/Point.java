package ru.tantam.ptc.sandbox;

/**
 * Created by Tanya on 02.03.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p){
    return Math.sqrt(Math.pow((this.x - p.x),2) + Math.pow((this.y - p.y),2));
  }

}
