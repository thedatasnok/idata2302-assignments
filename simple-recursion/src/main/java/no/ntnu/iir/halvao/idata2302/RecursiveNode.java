package no.ntnu.iir.halvao.idata2302;

public class RecursiveNode<T> implements Sequence<T> {
  private T self;
  private Sequence<T> next;

  public RecursiveNode(T element, Sequence<T> next) {
    this.self = element;
    this.next = next;
  }

  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    if (index < 1) throw new IndexOutOfBoundsException("Cannot index element with index less than 1");
    if (index == 1) return this.self;

    return next.get(index - 1);
  }

  @Override
  public void set(int index, T element) {
    if (index < 1) throw new IndexOutOfBoundsException("Cannot insert element at index less than 1");

    if (index == 1) {
      this.self = element;
    } else {
      next.set(index - 1, element);
    }
  }

  @Override
  public int length() {
    return 1 + next.length();
  }

  @Override
  public void insert(int index, T element) {
    if (index < 1) throw new IndexOutOfBoundsException("Cannot insert at index less than 1");
  }

  @Override
  public void remove(int index) {
    // bye
  }

  @Override
  public int search(T element) {
    if (this.self == element) return 1;
    int result = this.next.search(element);
    return result == 0 ? 0 : 1 + result;
  }
  
}
