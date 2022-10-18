package no.ntnu.iir.halvao.idata2302;

public class MaxBinaryHeap<T extends Comparable<T>> extends Heap<T> {

  public MaxBinaryHeap() {
    super();
  }

  @Override
  protected void bubbleUp(int startIndex) {
    int index = startIndex;
    int parentIndex = this.parentIndex(index);

    while (this.elementAt(index).compareTo(this.elementAt(parentIndex)) > 0) {
      this.swap(parentIndex, index);
      index = parentIndex;
      parentIndex = this.parentIndex(index);
    }
  }

  @Override
  protected void bubbleDown(int startIndex) {
    int index = startIndex; 

    while (this.hasLeftChild(index)) {
      int biggerChildIndex = this.leftChildIndex(index);

      if (this.hasRightChild(index) && this.rightChild(index).compareTo(this.leftChild(index)) > 0) {
        biggerChildIndex = this.rightChildIndex(index);
      }

      int difference = this.items.get(index).compareTo(this.items.get(biggerChildIndex));

      if (difference > 0) break;
    
      swap(index, biggerChildIndex);
      index = biggerChildIndex;
    }
  }
}
