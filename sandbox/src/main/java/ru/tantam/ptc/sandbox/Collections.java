package ru.tantam.ptc.sandbox;

/**
 * Created by Tanya on 19.03.2016.
 */
public class Collections {
  public static void main(String[] arg) {

    //массив
    String[] s1 = new String[4];
    s1[0] = "a";
    s1[1] = "b";
    s1[2] = "c";
    s1[3] = "d";
    //или  эквивалентная запись:
    String[] letter = {"a", "b", "c", "d"};

    for (int i = 0; i < letter.length; i++) {
      System.out.println("буква " + letter[i]);
    }

    //цикл для перебора коллекции
    for (String l: letter) {
      System.out.println("буква " + l);
    }


  }
}
