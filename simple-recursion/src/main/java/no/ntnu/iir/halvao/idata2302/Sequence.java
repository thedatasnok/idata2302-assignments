package no.ntnu.iir.halvao.idata2302;

public interface Sequence<T> {
  
  /**
   * Returns the length of the sequence.
   * 
   * @return the length of the sequence
   */
  public abstract int length();

  /**
   * Returns the element at a given index.
   * 
   * @param index the index of the element to get
   * 
   * @return the element at the given index
   * 
   * @throws IndexOutOfBoundsException if the index was outside the boundaries of the array
   */
  public abstract T get(int index) throws IndexOutOfBoundsException;

  /**
   * Sets the element value at a given index.
   * 
   * @param index the index to set the element value at
   * @param element the element value to set
   */
  public abstract void set(int index, T element);

  /**
   * Inserts an element at a given index, shifting the rest of the items toward the end.
   * 
   * @param index the index to insert the element value at
   * @param element the element value to insert
   */
  public abstract void insert(int index, T element);

  /**
   * Removes an element at a given index from the sequence.
   * 
   * @param index the index of the element to remove
   */
  public abstract void remove(int index);

  /**
   * Searches for the occurance of an element and returns the index of it.
   * 
   * @param element the element to search for in the sequence
   * 
   * @return the index of the found occurance
   */
  public abstract int search(T element);

  /**
   * Returns true if the sequence is empty.
   * 
   * @return true if the sequence is empty
   */
  default boolean isEmpty() {
    return this.length() == 0;
  }

  /**
   * Inserts an element to the start of the sequence.
   * 
   * @param element the element to insert at the start
   */
  default void prepend(T element) {
    this.insert(1, element);
  }

  /**
   * Inserts an element at the end of a sequence.
   * 
   * @param element the element ot insert at the end
   */
  default void append(T element) {
    this.insert(this.length() + 1, element);
  }
}
