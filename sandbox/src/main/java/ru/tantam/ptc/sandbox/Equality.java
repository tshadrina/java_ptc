package ru.tantam.ptc.sandbox;

/**
 * Created by Tanya on 14.03.2016.
 */
public class Equality {

  public static void main(String[] args){
    String a1 = "a2.0";
    String a2 = new String(a1);
    String a3 = a1;
    String a4 = "a2.0";
    String a5 = "a" + 2.0;
    String a6 = "a" + Math.sqrt(4.0);

    System.out.println(a1==a2);
    System.out.println(a1.equals(a2));

    System.out.println(a1==a3);
    System.out.println(a1.equals(a3));

    System.out.println(a1==a4);
    System.out.println(a1.equals(a4));

    System.out.println(a1==a5);
    System.out.println(a1.equals(a5));

    System.out.println(a1==a6);
    System.out.println(a1.equals(a6));

  }


}
