package com.github.imaman.katas.life;

import java.util.HashSet;
import java.util.Set;


public class Grid {
  
  public enum State {
    DEAD {
      @Override
      public boolean shouldLive(int numLiveNeighbors) {
        return numLiveNeighbors == 3;
      }      
    },
    LIVE {
      @Override
      public boolean shouldLive(int numLiveNeighbors) {
        return numLiveNeighbors == 2 || numLiveNeighbors == 3;
      }
    };

    public abstract boolean shouldLive(int numLiveNeighbors);
  }

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
