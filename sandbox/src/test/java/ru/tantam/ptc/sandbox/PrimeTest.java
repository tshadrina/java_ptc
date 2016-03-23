package ru.tantam.ptc.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Tanya on 16.03.2016.
 */
public class PrimeTest {

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test (enabled = false)
  public void testPrimeLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test
  public void testNotPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE -2 ));
  }
}
