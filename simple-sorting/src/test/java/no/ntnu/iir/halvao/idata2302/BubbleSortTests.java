package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;

class BubbleSortTests {

  private static final List<Integer> EMPTY_LIST = List.of();

  @Test
  void sortsListCorrectly() {
    List<Integer> sorted = BubbleSort.sort(3, 8, 10, 1, 4);
    assertArrayEquals(new Integer[]{1, 3, 4, 8, 10}, sorted.toArray(Integer[]::new));
  }

  @Test
  void cannotSortEmptyList() {
    assertThrows(IllegalArgumentException.class, () -> BubbleSort.sort());
    assertThrows(IllegalArgumentException.class, () -> BubbleSort.sort(EMPTY_LIST));
  }

}
