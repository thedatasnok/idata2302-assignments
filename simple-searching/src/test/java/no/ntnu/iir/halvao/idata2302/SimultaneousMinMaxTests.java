package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SimultaneousMinMaxTests {

  @Test
  void canFindMinMax() {
    Pair<Integer> minMax = SimultaneousMinMax.findMinMax(1, 2, 3, 4, 5, 6, 7, 8);
    
    assertEquals(1, minMax.getFirst());
    assertEquals(8, minMax.getSecond());
    assertTrue(minMax.getFirst() < minMax.getSecond());
  }

}
