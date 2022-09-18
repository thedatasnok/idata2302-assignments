package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SelectionSortTests {
  
  @Test
  void sortsListCorrectly() {
    List<Integer> sorted = SelectionSort.sort(1, 3, 2, 8, 4, 6);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 6, 8}, sorted.toArray(Integer[]::new));
  }

  @Test
  void cannotSortEmptyList() {
    assertThrows(IllegalArgumentException.class, () -> SelectionSort.sort());
    assertThrows(IllegalArgumentException.class, () -> SelectionSort.sort(List.of()));
  }
}
