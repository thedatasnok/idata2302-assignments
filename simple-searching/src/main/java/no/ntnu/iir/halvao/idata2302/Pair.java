package no.ntnu.iir.halvao.idata2302;

import java.util.List;

public class Pair<T> {
  private T first;
  private T second;

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Returns the first value in the pair.
   * 
   * @return the first value in the pair
   */
  public T getFirst() {
    return this.first;
  }

  /**
   * Returns the second value in the pair.
   * 
   * @return the second value in the pair
   */
  public T getSecond() {
    return this.second;
  }

  /**
   * Returns an immutable list of the values in the pair.
   * 
   * @return an immutable list of the values in the pair
   */
  public List<T> toList() {
    return List.of(this.first, this.second);
  }

  /**
   * Creates a new pair instance of two elements.
   * 
   * @param <T> the type of the pair elements
   * @param first the first element of the pair
   * @param second the second element of the pair
   * 
   * @return a new pair instance of the two values
   */
  public static <T> Pair<T> of(T first, T second) {
    return new Pair<>(first, second);
  }
}
