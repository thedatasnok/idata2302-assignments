package no.ntnu.iir.halvao.idata2302;

import java.util.ArrayList;
import java.util.List;

public abstract class Heap<T extends Comparable<T>> {
  protected final List<T> items;

  protected Heap() {
    this.items = new ArrayList<>();
  }

  /**
   * Inserts an element to the heap.
   * 
   * @param element the element to insert to the heap
   */
  public void insert(T element) {
    this.items.add(element);
    this.bubbleUp(this.lastIndex());
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
   * Returns a list copy of the elements in the heap.
   * 
   * @return a list copy of the elements in the heap
   */
  public List<T> listCopy() {
    return List.copyOf(this.items);
  }

  /**
   * Extracts the first element in the heap, removing it from the heap.
   * 
   * @return the first element in the heap
   */
  public T poll() {
    this.swap(this.lastIndex(), 0);
    T head = this.items.remove(this.lastIndex());
    this.bubbleDown(0);

    return head;
  }

  /**
   * Bubbles down the element at a given index.
   * 
   * @param index the index to bubble down from
   */
  protected abstract void bubbleDown(int index);

  /**
   * Bubbles up the element at a given index.
   * 
   * @param index the index to bubble up from
   */
  protected abstract void bubbleUp(int index);

  /**
   * Swaps two elements in the heap.
   * 
   * @param firstIndex the index of the first element to swap
   * @param secondIndex the index of the second element to swap
   */
  protected void swap(int firstIndex, int secondIndex) {
    T firstValue = this.items.get(firstIndex);
    this.items.set(firstIndex, this.items.get(secondIndex));
    this.items.set(secondIndex, firstValue);
  }

  /**
   * Returns the element at a given index.
   * 
   * @param index the index to retrieve the element from
   * 
   * @return the element at the given index
   */
  protected T elementAt(int index) {
    return this.items.get(index);
  }

  /**
   * Calculates the parent index of a child element.
   * 
   * @param childIndex the index of the child element
   * 
   * @return the index of the parent element
   */
  protected int parentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  /**
   * Returns true if a given child element has a parent.
   * 
   * @param childIndex the child index to check if a parent exists
   * 
   * @return true if a parent is present for the given index
   */
  protected boolean hasParent(int childIndex) {
    return this.parentIndex(childIndex) >= 0;
  }

  /**
   * Returns the parent element of a given childs index.
   * 
   * @param childIndex the child index to resolve a parent element from
   * 
   * @return the resolved parent element
   */
  protected T parent(int childIndex) {
    return this.items.get(this.parentIndex(childIndex));
  }

  /**
   * Returns the index of the left child of a given node.
   * 
   * @param parentIndex the index of the parent node to find a left child for
   * 
   * @return the resolved left child index
   */
  protected int leftChildIndex(int parentIndex) {
    return (parentIndex * 2) + 1;
  }

  /**
   * Checks if a parent index has a left child in the heap.
   * 
   * @param parentIndex the parent index to check if it has a left child
   * 
   * @return true if the parent index has a left child
   */
  protected boolean hasLeftChild(int parentIndex) {
    return this.leftChildIndex(parentIndex) < this.items.size();
  }

  /**
   * Finds the left child element from a given parent index.
   * 
   * @param parentIndex the parent index to find the left child element from
   * 
   * @return the left child element
   */
  protected T leftChild(int parentIndex) {
    return this.items.get(this.leftChildIndex(parentIndex));
  }

  /**
   * Returns the index of the right child of a given parent index.
   * 
   * @param parentIndex the parent index to find the right child index for
   * 
   * @return the right child index of the given parent index
   */
  protected int rightChildIndex(int parentIndex) {
    return (parentIndex * 2) + 2;
  }

  /**
   * Checks if a parent index has a right child.
   * 
   * @param parentIndex the parent index to check if has a right child
   * 
   * @return true if the parent index has a right child
   */
  protected boolean hasRightChild(int parentIndex) {
    return this.rightChildIndex(parentIndex) < this.items.size();
  }

  /**
   * Returns the right child element of a parent index.
   * 
   * @param parentIndex the parent index to resolve a right child element from
   * 
   * @return the right child element
   */
  protected T rightChild(int parentIndex) {
    return this.items.get(this.rightChildIndex(parentIndex));
  }

  /**
   * Returns the index of the last element in the heap.
   * 
   * @return the index of the last element in the heap
   */
  protected int lastIndex() {
    return this.items.size() - 1;
  }
}
