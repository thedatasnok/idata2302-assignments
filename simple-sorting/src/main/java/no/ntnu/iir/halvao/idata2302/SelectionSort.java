package no.ntnu.iir.halvao.idata2302;

import java.util.List;

public class SelectionSort {
  private SelectionSort() {}

  public static List<Integer> sort(Integer... numbers) {
    return SelectionSort.sort(List.of(numbers));
  }

  public static List<Integer> sort(Iterable<Integer> numbers) {
    throw new UnsupportedOperationException("Not yet implemented!");
  }
}
