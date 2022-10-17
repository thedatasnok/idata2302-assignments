package no.ntnu.iir.halvao.idata2302;

import java.util.ArrayList;
import java.util.List;

public class MinBinaryHeap<T extends Comparable<T>> {
  private List<T> items;

  public MinBinaryHeap() {
    this.items = new ArrayList<>();
  }

  /**
   * Inserts a new value in the heap.
   * 
   * @param value the value to insert to the heap
   * 
   * @return this instance of the heap
   */
  public void insert(T value) {
    this.items.add(value);
    this.bubbleUp(this.lastIndex());
  }

  /**
   * Extracts the minimum of the heap. 
   * 
   * @return the minimum of the heap
   */
  public T extractMin() {
    this.swap(this.lastIndex(), 0);
    T nextItem = this.items.remove(this.items.size());
    this.bubbleDown(0);
    
    return nextItem;
  }

  /**
   * Returns the size of the heap.
   * 
   * @return the size of the heap
   */
  public int size() {
    return this.items.size();
  }

  /**
   * Returns a copy of the list used by the heap.
   * 
   * @return a copy of the list used by the heap
   */
  public List<T> listCopy() {
    return List.copyOf(this.items);
  }

  private void bubbleUp(int nodeIndex) {
    int index = nodeIndex;
    int parentIndex = this.parentIndex(index);

    while (this.hasParent(nodeIndex) && this.parent(index).compareTo(this.itemAt(index)) > 0) {
      this.swap(parentIndex, index);
      index = parentIndex;
    }
  }

  private void bubbleDown(int parentIndex) {
    int index = parentIndex; 

    while (this.hasLeftChild(index)) {
      int smallerChildIndex = this.leftChildIndex(index);

      if (this.hasRightChild(index) && this.rightChild(index).compareTo(this.leftChild(index)) <= 0) {
        smallerChildIndex = this.rightChildIndex(index);
      }

      int difference = this.items.get(index).compareTo(this.items.get(smallerChildIndex));

      if (difference < 0) break;
    
      swap(index, smallerChildIndex);
      index = smallerChildIndex;
    }
  }

  private void swap(int firstIndex, int secondIndex) {
    T firstValue = this.items.get(firstIndex);
    this.items.set(firstIndex, this.items.get(secondIndex));
    this.items.set(secondIndex, firstValue);
  }

  private T itemAt(int index) {
    return this.items.get(index);
  }

  private int parentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasParent(int childIndex) {
    return this.parentIndex(childIndex) >= 0;
  }

  private T parent(int childIndex) {
    return this.items.get(this.parentIndex(childIndex));
  }

  private int leftChildIndex(int parentIndex) {
    return (parentIndex * 2) + 1;
  }

  private boolean hasLeftChild(int parentIndex) {
    return this.leftChildIndex(parentIndex) < this.items.size();
  }

  private T leftChild(int parentIndex) {
    return this.items.get(this.leftChildIndex(parentIndex));
  }

  private int rightChildIndex(int parentIndex) {
    return (parentIndex * 2) + 2;
  }

  private boolean hasRightChild(int parentIndex) {
    return this.rightChildIndex(parentIndex) < this.items.size();
  }

  private T rightChild(int parentIndex) {
    return this.items.get(this.rightChildIndex(parentIndex));
  }

  private int lastIndex() {
    return this.items.size() - 1;
  }
}
