package no.ntnu.iir.halvao.idata2302;

public interface RecursiveSequence<T> {
  
  /**
   * Returns the length of the sequence.
   * 
   * @return the length of the sequence
   */
  int length();

  /**
   * Finds and returns the element at a given index in the sequence.
   * 
   * @param index the index of the element to find
   * 
   * @return the found element
   * 
   * @throws IndexOutOfBoundsException if the requested elements index was outside the sequence boundaries
   */
  T get(int index) throws IndexOutOfBoundsException;

  /**
   * Sets the element at a specific index in the sequence.
   * 
   * @param index the index to set the element at
   * @param element the element value to set at the given index
   * 
   * @throws IndexOutOfBoundsException if the index to set the element at was outside the sequence boundaries
   */
  void set(int index, T element) throws IndexOutOfBoundsException;

  /**
   * Inserts an element at a given index.
   * 
   * @param index the index to insert the element at
   * @param element the element to insert at the index
   * 
   * @return the new sequence
   * 
   * @throws IndexOutOfBoundsException if the index is outside the allowed sequence boundaries
   */
  RecursiveSequence<T> insert(int index, T element) throws IndexOutOfBoundsException;

  /**
   * Removes an element from a given index.
   * 
   * @param index the index to remove the element from
   * 
   * @return the new sequence
   * 
   * @throws IndexOutOfBoundsException
   */
  RecursiveSequence<T> remove(int index) throws IndexOutOfBoundsException;

  /**
   * Searches through the sequence to find the index of a given element.
   * 
   * @param element the element to find the index of
   * 
   * @return the index of the found element, or -1 if it was not found
   */
  int search(T element);

}
