package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DynamicArrayTests {

  @Test
  void capacityIncreasesWhenFull() {
    DynamicArray array = new DynamicArray(2);
    assertEquals(2, array.getCapacity());
    array.insert(1);
    array.insert(2);
    assertEquals(4, array.getCapacity());
  }

  @Test
  void capacityDecreasesWhenLengthIsLessThanAFourth() {
    int capacity = 100;
    DynamicArray array = new DynamicArray(capacity);
    array.insert(10);
    array.insert(10);
    array.insert(10);
    array.insert(10);
    array.insert(10);
    array.insert(10);
    assertEquals(capacity, array.getCapacity());
    array.delete();
    assertEquals(capacity / 2, array.getCapacity());
    array.delete();
    assertEquals(capacity / 4, array.getCapacity());
  }

  @Test
  void lengthIncreasesOnInsert() {
    DynamicArray array = new DynamicArray();
    array.insert(10);
    array.insert(2);
    assertEquals(2, array.getLength());

    array.insert(5);
    assertEquals(3, array.getLength());
  }

  @Test
  void lengthDecreasesOnDelete() {
    DynamicArray array = new DynamicArray(4);
    array.insert(1);
    array.insert(1);
    array.insert(1);
    assertEquals(3, array.getLength());
    array.delete();
    assertEquals(2, array.getLength());
  }

  @Test
  void containsPassedIntegers() {
    int constant = 12;
    DynamicArray array = new DynamicArray(16);

    for (int i = 0; i < constant; i++) {
      array.insert(i);
    }

    int[] collected = new int[constant];

    for (int i = 0; i < constant; i++) {
      collected[i] = array.get(i);
    }

    assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, collected);
  }

}
