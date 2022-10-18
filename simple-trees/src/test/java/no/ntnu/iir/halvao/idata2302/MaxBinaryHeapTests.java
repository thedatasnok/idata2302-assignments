package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;

class MaxBinaryHeapTests {
  

  @Test
  void canInsertToHeap() {
    Heap<Integer> heap = new MaxBinaryHeap<>();
    heap.insert(1);
    heap.insert(2);
    heap.insert(3);
    heap.insert(4);

    assertEquals(4, heap.size());
  }

  @Test
  void maximumIsAtHead() {
    Heap<Integer> heap = new MaxBinaryHeap<>();
    heap.insert(1);
    heap.insert(2);
    heap.insert(3);
    heap.insert(4);

    assertEquals(4, heap.listCopy().get(0));
    assertEquals(Collections.max(heap.listCopy()), heap.poll());
  }

  @Test
  void maximumIsBubbledDownOnExtraction() {
    Heap<Integer> heap = new MaxBinaryHeap<>();
    heap.insert(1);
    heap.insert(2);
    heap.insert(3);
    heap.insert(4);

    heap.poll();

    assertEquals(3, heap.poll());
  }

}
