package no.ntnu.iir.halvao.idata2302;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
  private SelectionSort() {}

  /**
   * Sorts a variadic number of integers using the selection sort algorithm.
   * 
   * @param numbers a variable list of numbers
   * 
   * @return a sorted list of the input numbers
   */
  public static List<Integer> sort(Integer... numbers) {
    return SelectionSort.sort(List.of(numbers));
  }

  /**
   * Sorts a list of integers using the selection sort algorithm.
   * 
   * @param numbers the list of integers to sort
   * 
   * @return a new sorted list with the numbers in sorted order
   */
  public static List<Integer> sort(List<Integer> numbers) {
    if (numbers.isEmpty()) throw new IllegalArgumentException("Cannot sort an empty list!");

    List<Integer> sorted = new ArrayList<>(numbers);

    for (int i = 0; i < sorted.size(); i++) {
      int current = sorted.get(i); // left side
      int minimum = sorted.get(i); // right side
      int minimumIndex = i;

      // find the minimum value along with its index
      // we start at the current value of i, everything to the
      // left of the index i should already be in sorted order
      for (int j = i; j < sorted.size(); j++) {
        if (sorted.get(j) < minimum) {
          minimum = sorted.get(j);
          minimumIndex = j;
        }
      }

      // swap the two values in the array
      sorted.set(i, minimum);
      sorted.set(minimumIndex, current);
    }

    return sorted;
  }
}
