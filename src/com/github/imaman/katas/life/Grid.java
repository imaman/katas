package com.github.imaman.katas.life;

import java.util.HashSet;
import java.util.Set;

public class Grid {

  private Set<Location> live = new HashSet<Location>();

  public void liveAt(Location location) {
    live.add(location);
  }

  public Set<Location> liveNeighborsOf(Location location) {
    HashSet<Location> result = new HashSet<Location>(live);
    result.retainAll(location.neighbors());
    return result;
  }
  
  public int liveNeighborsCount(Location location) {
    throw new UnsupportedOperationException();
  }
}
