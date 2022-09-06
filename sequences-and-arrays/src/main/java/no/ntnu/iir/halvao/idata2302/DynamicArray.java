package no.ntnu.iir.halvao.idata2302;

/**
 * Represents a dynamic array class.
 * Responsible for maintaining fixed size arrays, allocating space as needed.
 */
public class DynamicArray {
  private int[] elements;
  private int length;
  private int capacity;

  /**
   * Instantiates a dynamic array with a given starting capacity.
   * 
   * @param capacity the starting capacity of the array
   */
  public DynamicArray(int capacity) {
    this.elements = new int[capacity];
    this.capacity = capacity;
    this.length = 0;
  }

  /**
   * Instantiates a dynamic array with a default starting capacity of 100.
   */
  public DynamicArray() {
    this(100);
  }
  
  /**
   * Inserts an element at the end of the array.
   * 
   * @param element the element to insert at the end of the array
   */
  public void insert(int element) {
    if (this.length + 1 == elements.length) {
      this.capacity = this.capacity * 2;
      int[] intermediateArray = new int[this.capacity];

      for (int i = 0; i < this.elements.length; i++) {
        intermediateArray[i] = this.elements[i];
      }

      this.elements = intermediateArray;
    }

    this.elements[this.length] = element;
    this.length++;
  }

  /**
   * Deletes the last element of the array, reduces the size of the array, 
   * if the length is less than a fourth of the allocated size.
   */
  public void delete() {
    int[] intermediateArray;

    if (this.length <= elements.length / 4) {
      this.capacity = this.capacity / 2;
      intermediateArray = new int[this.capacity];
    } else {
      intermediateArray = new int[this.capacity];
    }

    for (int i = 0; i < this.length - 1; i++) {
      intermediateArray[i] = this.elements[i];
    }

    this.elements = intermediateArray;
    this.length--;
  }

  /**
   * Searches through the array to find the index of a given element.
   * 
   * @param element the element to find the index for
   * 
   * @return the index of the found element, or -1 if no index was found
   */
  public int lookup(int element) {
    int result = -1;
    int counter = 0;

    while (result == -1 && counter < this.elements.length) {
      if (this.elements[counter] == element) result = counter;
    }

    return result;
  }
  
  /**
   * Gets the element at a specific index. 
   * 
   * @param index the index of the element to retrieve
   * 
   * @return the element at the specified index
   * 
   * @throws IndexOutOfBoundsException if the index was outside the bounds of the dynamic array
   */
  public int get(int index) {
    if (index < 0 || index > elements.length) throw new IndexOutOfBoundsException();

    return this.elements[index];
  }

  /**
   * Returns the length of the dynamic array.
   * 
   * @return the length of the dynamic array
   */
  public int getLength() {
    return this.length;
  }

  /**
   * Returns the current capacity of the dynamic array.
   * 
   * @return the current capacity
   */
  public int getCapacity() {
    return this.capacity;
  }
}
