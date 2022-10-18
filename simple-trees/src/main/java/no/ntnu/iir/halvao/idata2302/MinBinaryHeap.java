package no.ntnu.iir.halvao.idata2302;

public class MinBinaryHeap<T extends Comparable<T>> extends Heap<T> {

  public MinBinaryHeap() {
    super();
  }

  public static void main(String[] args) {
    Heap<Integer> heap = new MinBinaryHeap<>();
    heap.insert(3);
    heap.insert(2);
    heap.insert(4);
    heap.insert(1);
  }

  @Override
  protected void bubbleUp(int nodeIndex) {
    int index = nodeIndex;
    int parentIndex = this.parentIndex(index);
    
    while (this.elementAt(index).compareTo(this.elementAt(parentIndex)) < 0) {
      this.swap(index, parentIndex);
      index = parentIndex;
      parentIndex = this.parentIndex(index);
    }
  }

  @Override
  protected void bubbleDown(int parentIndex) {
    int index = parentIndex; 

    while (this.hasLeftChild(index)) {
      int smallerChildIndex = this.leftChildIndex(index);

      if (this.hasRightChild(index) && this.rightChild(index).compareTo(this.leftChild(index)) < 0) {
        smallerChildIndex = this.rightChildIndex(index);
      }

      int difference = this.items.get(index).compareTo(this.items.get(smallerChildIndex));

      if (difference < 0) break;
    
      swap(index, smallerChildIndex);
      index = smallerChildIndex;
    }
  }
}
