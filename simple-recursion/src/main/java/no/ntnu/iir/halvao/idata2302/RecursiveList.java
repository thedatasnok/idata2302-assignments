package no.ntnu.iir.halvao.idata2302;

public class RecursiveList<T> implements Sequence<T> {
  private RecursiveSequence<T> head;

  public RecursiveList() {
    this.head = new Empty<>();
  }

  @Override
  public int length() {
    return this.head.length();
  }

  @Override
  public boolean isEmpty() {
    return this.length() == 0;
  }

  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    return this.head.get(index);
  }

  @Override
  public void set(int index, T element) {
    this.head.set(index, element);
  }

  @Override
  public void insert(int index, T element) {
    this.head = this.head.insert(index, element);
  }

  @Override
  public void remove(int index) {
    this.head = this.head.remove(index);
  }

  @Override
  public int search(T element) {
    return this.head.search(element);
  }

}
