package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MinBinaryHeapTests {
  
  @Test
  void canInsertToHeap() {
    MinBinaryHeap<Integer> heap = new MinBinaryHeap<>();
    heap.insert(1);
    heap.insert(2);
    heap.insert(3);
    heap.insert(4);

    assertEquals(4, heap.size());
  }

  @Test
  void isOrderedCorrectly() {
    MinBinaryHeap<Integer> heap = new MinBinaryHeap<>();

    heap.insert(2);
    heap.insert(3);
    heap.insert(1);
    heap.insert(4);
    heap.insert(6);
    heap.insert(5);
    
    assertArrayEquals(new Integer[]{ 1, 3, 2, 4, 6, 5 }, heap.listCopy().toArray(Integer[]::new));
  }

}
