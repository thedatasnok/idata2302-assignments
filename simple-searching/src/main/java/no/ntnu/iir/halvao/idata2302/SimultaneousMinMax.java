package no.ntnu.iir.halvao.idata2302;

import java.util.List;

public class SimultaneousMinMax {

  private SimultaneousMinMax() {}

  /**
   * Finds the minimum and maximum number from a variadic number of integers.
   * 
   * @param numbers a variable list of integer numbers
   * 
   * @return a pair with the min as the first element and the max as the second
   */
  public static Pair<Integer> findMinMax(Integer... numbers) {
    return SimultaneousMinMax.findMinMax(List.of(numbers));
  }

  /**
   * Finds the minimum and maximum number in the list.
   * 
   * @param numbers the list of numbers to find the min and max from
   *  
   * @return a pair with the min as the first element and the max as the second
   */
public static Pair<Integer> findMinMax(List<Integer> numbers) {
  if (numbers.isEmpty()) throw new IllegalArgumentException("Cannot find the minimum and maxima from an empty list");

  int min = numbers.get(0);
  int max = numbers.get(0);

  // pairwise loop through the array
  for (int i = 0; i < numbers.size() - 1; i += 2) {
    int left = numbers.get(i);
    int right = numbers.get(i + 1);
    
    if (left < right) {
      // could also use if condition - but this seemeed more readable
      max = Math.max(right, max);
      min = Math.min(left, min);
    } else {
      max = Math.max(left, max);
      min = Math.min(right, max);
    }
  }

  // account for the last element in the list cause it may be left out from the above loop
  // if the following condition returns true, it has been left out
  if (numbers.size() % 2 != 0) {
    int last = numbers.get(numbers.size() - 1);

    min = Math.min(last, min);
    max = Math.max(last, max);
  }

  return Pair.of(min, max);
}
}
