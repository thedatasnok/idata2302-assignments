package no.ntnu.iir.halvao.idata2302;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
  void cannotDeletePastZeroLength() {
    DynamicArray array = new DynamicArray(4);
    assertThrows(IllegalStateException.class, () -> array.delete());
    array.insert(10);
    array.delete();
    assertThrows(IllegalStateException.class, () -> array.delete());
  }
  
  @Test
  void capacityDoesNotDecreaseToZero() {
    DynamicArray array = new DynamicArray(2);
    array.insert(1);
    array.delete();
    array.insert(1);
    array.delete();
    assertEquals(2, array.getCapacity()); 
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

  @Test
  void lookupReturnsCorrectIndex() {
    DynamicArray array = new DynamicArray();
    array.insert(2);
    array.insert(2);
    array.insert(24);
    array.insert(22);
    array.insert(23);
    array.insert(2);

    assertEquals(0, array.lookup(2));
    assertEquals(2, array.lookup(24));
    assertEquals(4, array.lookup(23));
    assertNotEquals(5, array.lookup(2));
  }

  @Test
  void getReturnsLookedUpElement() {
    DynamicArray array = new DynamicArray();
    int elementToFind = 5;

    array.insert(1);
    array.insert(1);
    array.insert(elementToFind);
    array.insert(1);
    array.insert(1);

    int lookedUpIndex = array.lookup(elementToFind);
    assertEquals(2, lookedUpIndex);
    assertEquals(elementToFind, array.get(lookedUpIndex));
  }

}
