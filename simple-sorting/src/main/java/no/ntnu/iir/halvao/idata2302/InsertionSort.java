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

    List<Integer> sorted = new ArrayList<>();

    for (int i = 0; i < numbers.size(); i++) {
      int element = numbers.get(i);
      int insertionIndex = sorted.size();
      int j = 0;

      while (j < sorted.size() && insertionIndex == sorted.size()) {
        if (element < sorted.get(j)) insertionIndex = j;
        j++;
      }

      sorted.add(insertionIndex, element);
    }

    return sorted;
  }
}
