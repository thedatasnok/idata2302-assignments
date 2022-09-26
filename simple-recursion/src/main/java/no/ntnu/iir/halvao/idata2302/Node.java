package no.ntnu.iir.halvao.idata2302;

public class Node<T> {
  private T self;
  private Node<T> next;

  public Node(T self) {
    this.self = self;
  }

  public Node(T self, Node<T> next) {
    this(self);
    this.next = next;
  }

  public T get() {
    return this.self;
  }

  public void set(T value) {
    this.self = value;
  }

  public Node<T> getNext() {
    return this.next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public boolean hasNext() {
    return this.next != null;
  }

}
