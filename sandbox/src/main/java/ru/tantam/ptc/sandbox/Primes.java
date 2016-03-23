package ru.tantam.ptc.sandbox;

/**
 * Created by Tanya on 16.03.2016.
 */
public class Primes {

  public static boolean isPrime(int n) {
    for ( int i = 2; i < n ; i = i + 1){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n){
      if (n % i == 0) {
        return false;
      }
      i++;
    }
    return true;
  }

  public static boolean isPrimeFast(int n) {
    int m = ( int) Math.sqrt(n);
    for ( int i = 2; i < m ; i = i + 1){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrime(long n) {
    for ( long i = 2; i < n ; i = i + 1){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
