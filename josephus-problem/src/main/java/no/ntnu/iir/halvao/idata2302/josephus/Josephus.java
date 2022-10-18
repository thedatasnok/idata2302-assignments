package no.ntnu.iir.halvao.idata2302.josephus;

import java.util.ArrayList;
import java.util.List;

/**
 * Example from live session on campus. 
 * Not sure if this ends up being correct.
 */
public class Josephus {

  public static int josephus(int playersCount, int skip) {
    List<Integer> players = new ArrayList<>();
    
    for (int i = 0; i < playersCount; i++) {
      players.add(i + 1);
    }

    int currentIndex = 0;
    while (players.size() > 1) {
      players.remove(currentIndex + skip);
      currentIndex = (currentIndex + skip + 1) % players.size() - 1;
    }

    return players.get(0);
  }

  public static void main(String[] args) {
    int winner = Josephus.josephus(6, 2);
    System.out.println("Winning player has id: " + winner);
  }

}
