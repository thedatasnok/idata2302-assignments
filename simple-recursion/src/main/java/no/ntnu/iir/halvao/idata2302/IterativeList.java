package no.ntnu.iir.halvao.idata2302;

public class IterativeList<T> implements Sequence<T> {
  private Node<T> head;

  public IterativeList(Node<T> head) {
    this.head = head;
  }

  public IterativeList(T head) {
    this.head = new Node<>(head);
  }

  @Override
  public int length() {
    int length = 0;
    Node<T> currentNode = this.head;

    while (currentNode != null) {
      currentNode = currentNode.getNext();
      length++;
    }

    return length;
  }

  @Override
  public boolean isEmpty() {
    return this.length() == 0;
  }

  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    return this.getNode(index).get();
  }

  private Node<T> getNode(int index) {
    if (index < 0) throw new IllegalArgumentException("Cannot get element from a negative index");

    int counter = 0;
    Node<T> currentNode = this.head;

    while (currentNode.hasNext()) {
      currentNode = currentNode.getNext();
      counter++;
    }

    if (counter != index) throw new IndexOutOfBoundsException(
      "Could not find an element with index: " + index
    );

    return currentNode;
  }

  @Override
  public void set(int index, T element) {
    this.getNode(index).set(element);
  }

  @Override
  public void insert(int index, T element) {
    if (index < 0) throw new IllegalArgumentException("Cannot insert element at a negative index");

    Node<T> insertAfter = this.getNode(index - 1);
    Node<T> node = null;

    if (insertAfter.hasNext()) {
      node = new Node<>(element, insertAfter.getNext());
    } else {
      node = new Node<>(element);
    }

    insertAfter.setNext(node);
  }

  @Override
  public void remove(int index) {
    if (index == 1) {
      this.head = head.getNext();
    } else {
      Node<T> before = this.getNode(index - 1);

      if (before.hasNext() && before.getNext().hasNext()) {
        before.setNext(before.getNext().getNext());
      } else {
        before.setNext(null);
      }
    }
  }

  @Override
  public int search(T element) {
    int index = -1;
    int counter = 0;
    Node<T> currentNode = this.head;

    while (currentNode.hasNext() && index == -1) {
      counter++;
      currentNode = currentNode.getNext();
      if (currentNode.get() == element) {
        index = counter;
      }
    }
    
    return index;
  }

}
