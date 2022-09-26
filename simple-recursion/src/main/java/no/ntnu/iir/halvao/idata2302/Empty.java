package no.ntnu.iir.halvao.idata2302;

public class Empty<T> implements RecursiveSequence<T> {
  
  public Empty() {
    // do nothing
  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    throw new IndexOutOfBoundsException("Cannot index an empty sequence");
  }

  @Override
  public void set(int index, T element) {
    throw new IndexOutOfBoundsException("Cannot set an element in an empty sequence");
  }

  @Override
  public RecursiveSequence<T> insert(int index, T element) {
    throw new UnsupportedOperationException("");
  }

  @Override
  public RecursiveSequence<T> remove(int index) {
    throw new IndexOutOfBoundsException("Cannot remove element by index from an empty sequence");
  }

  @Override
  public int search(T element) {
    return 0;
  }

}
