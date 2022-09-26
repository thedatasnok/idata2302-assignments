package no.ntnu.iir.halvao.idata2302;

import java.util.logging.Logger;

public class Benchmark {

  private static final Logger LOG = Logger.getLogger(Benchmark.class.getName());
  
  public static <T> int run(Sequence<T> sequence, int maximum, T dummyItem) {
    int index = 0;
    
    try {
      while (index < maximum) {
        sequence.append(dummyItem);
        index++;
      }
    } catch (Exception e) {
      // do nothing
    }

    return index;
  }

  public static void main(String[] args) {
    final int MAXIMUM  = 100000;
    int iterationLimit = Benchmark.run(new IterativeList<>(null), MAXIMUM, 55);
    String iterationError = (iterationLimit < MAXIMUM) ? "(error)" : "";
    String iterativeResult = "Iterative list: " + iterationLimit + " item(s) inserted. " + iterationError;
    LOG.info(iterativeResult);
  
    
    int recursionLimit = Benchmark.run(new RecursiveList<>(), MAXIMUM, 55);
    String recursionError = (recursionLimit < MAXIMUM) ? "(error)" : "";
    String recursiveResult = "Recursive list: " + recursionLimit + " item(s) inserted. " + recursionError;
    LOG.info(recursiveResult);
  }

}
