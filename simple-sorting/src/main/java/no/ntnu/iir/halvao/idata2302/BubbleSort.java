package no.ntnu.iir.halvao.idata2302;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
  private BubbleSort() {}

  /**
   * Sorts a list of integers using the bubble sort algorithm.
   * 
   * @param numbers a variable list of numbers
   * 
   * @return a sorted list of the input numbers
   */
  public static List<Integer> sort(Integer... numbers) {
    return BubbleSort.sort(List.of(numbers));
  }

  /**
   * Sorts a list of integers using bubble sort.
   * 
   * @param numbers the list of numbers to sort
   * 
   * @return a new list with the sorted elements
   */
  public static List<Integer> sort(List<Integer> numbers) {
    if (numbers.isEmpty()) throw new IllegalArgumentException("Cannot sort an empty array!");

    List<Integer> sorted = new ArrayList<>(numbers);
    boolean isChanged = true;

    while (isChanged) {
      isChanged = false;

      for (int i = 0; i < numbers.size() - 1; i++) {
        int left = sorted.get(i);
        int right = sorted.get(i + 1);
  
        if (right < left) {
          sorted.set(i, right);
          sorted.set(i + 1, left);
          isChanged = true;
        }
      }
    }

    return sorted;
  }
}
