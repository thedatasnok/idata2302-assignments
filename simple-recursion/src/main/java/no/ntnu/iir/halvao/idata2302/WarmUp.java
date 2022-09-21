package no.ntnu.iir.halvao.idata2302;

import java.util.Arrays;

public class WarmUp {
  
  private static final String[] CHARACTERS = {
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
    "A", "B", "C", "D", "E", "F", "G", "H", "I"
  };

  private WarmUp() {}

  public static int power(int value, int exponent) {
    if (exponent < 0) throw new IllegalArgumentException("Cannot calculate power with a negative exponent");
    if (exponent == 0) return 1;
    if (exponent == 1) return value;

    return value * WarmUp.power(value, exponent - 1);
  }

  public static int sum(int[] array) {
    if (array.length == 0) return 0;
    if (array.length == 1) return array[0];
    return array[array.length - 1] + WarmUp.sum(Arrays.copyOfRange(array, 0, array.length - 1));
  }

  public static boolean isPalindrome(String text) {
    if (text == null) throw new IllegalArgumentException("Text cannot be null!");
    if (text.length() == 0 || text.length() == 1) return true;
    if (text.charAt(0) == text.charAt(text.length() - 1)) return WarmUp.isPalindrome(text.substring(1, text.length() - 1));

    return false;
  }

  public static String toBase(int number, int base) {
    if (number == 0) return "";
    
    return number <= 1 
      ? CHARACTERS[number % base]
      : WarmUp.toBase(number / base, base) + CHARACTERS[number % base];
  }

}
