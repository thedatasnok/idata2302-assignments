package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class WarmUpTests {

  @Test
  void canCalculatePower() {
    assertEquals(1, WarmUp.power(25, 0));
    assertEquals(25, WarmUp.power(25, 1));
    assertEquals(4*4, WarmUp.power(4,2));
    assertEquals(4*4*4*4, WarmUp.power(4, 4));
  }

  @Test
  void canSumArray() {
    assertEquals(0, WarmUp.sum(new int[] {}));
    assertEquals(3, WarmUp.sum(new int[] {1, 1, 1}));
    assertEquals(0, WarmUp.sum(new int[] {0, 0, 0}));
    assertEquals(55, WarmUp.sum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    assertEquals(-5, WarmUp.sum(new int[] {4, 6, -10, -5}));
  }

  @Test
  void canConvertBase() {
    assertEquals("5", WarmUp.toBase(5, 6));
    assertEquals("11", WarmUp.toBase(6, 5));
    assertEquals("22", WarmUp.toBase(10, 4));
    assertEquals("400", WarmUp.toBase(100, 5));
    assertEquals("10201", WarmUp.toBase(100, 3));
    assertEquals("BEEF", WarmUp.toBase(48879, 16));
  }

  @Test
  void canDetectPalindrome() {
    assertTrue(WarmUp.isPalindrome("kayak"));
    assertTrue(WarmUp.isPalindrome("madam"));
    assertTrue(WarmUp.isPalindrome("redivider"));
    assertTrue(WarmUp.isPalindrome("racecar"));
    assertFalse(WarmUp.isPalindrome("algorithm"));
    assertFalse(WarmUp.isPalindrome("ntnu"));
  }
}
