package no.ntnu.iir.halvao.idata2302;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
  private InsertionSort() {}

  /**
   * Sorts a list of integers using the insertion sort algorithm.
   * 
   * @param numbers a variable list of numbers
   * 
   * @return a sorted list of the input numbers
   */
  public static List<Integer> sort(Integer... numbers) {
    return InsertionSort.sort(List.of(numbers));
  }

  /**
   * Sorts a list of integers using insertion sort.
   * 
   * @param numbers the list of numbers to sort
   * 
   * @return a new list with the number in sorted order
   */
  public static List<Integer> sort(List<Integer> numbers) {
    if (numbers.isEmpty()) throw new IllegalArgumentException("Cannot sort an empty list!");

    List<Integer> unsorted = new ArrayList<>(numbers);
    List<Integer> sorted = new ArrayList<>();

    while (sorted.size() != numbers.size()) {
      int minimaIndex = 0;

      for (int i = 0; i < unsorted.size(); i++) {
        if (unsorted.get(i) < unsorted.get(minimaIndex)) minimaIndex = i;
      }

      sorted.add(unsorted.get(minimaIndex));
      unsorted.remove(unsorted.get(minimaIndex));
    }

    return sorted;
  }
}
