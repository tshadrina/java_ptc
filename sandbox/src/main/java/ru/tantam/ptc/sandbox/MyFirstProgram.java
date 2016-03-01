package ru.tantam.ptc.sandbox;

public class MyFirstProgram {

  public static void main(String[] arg){
		hello("user");
    hello("world");
    double l=8.0;
    System.out.println("Площадь квадрата со стороной " + l  + " = "+ area(l));

    double a=6;
    double b=4;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = "+ area(a,b));
	}

  public static void hello(String somebody){
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double l){
    return l*l;
  }

  public static double area(double a, double b){
    return a*b;
  }

}