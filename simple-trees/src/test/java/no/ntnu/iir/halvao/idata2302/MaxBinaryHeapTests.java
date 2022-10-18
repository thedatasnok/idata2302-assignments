package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaxBinaryHeapTests {
  

  @Test
  void canInsertToHeap() {
    MinBinaryHeap<Integer> heap = new MinBinaryHeap<>();
    heap.insert(1);
    heap.insert(2);
    heap.insert(3);
    heap.insert(4);

    assertEquals(4, heap.size());
  }

}
