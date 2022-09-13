package no.ntnu.iir.halvao.idata2302;

import java.util.List;

public class InsertionSort {
  private InsertionSort() {}

  public static List<Integer> sort(Integer... numbers) {
    return InsertionSort.sort(List.of(numbers));
  }

  public static List<Integer> sort(Iterable<Integer> numbers) {
    throw new UnsupportedOperationException();
  }
}
