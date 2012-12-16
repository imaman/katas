package com.github.imaman.katas.life;

import java.util.HashSet;
import java.util.Set;


public class Grid {
  
  public enum State {
    DEAD {
      @Override
      public State shouldLive(int numLiveNeighbors) {
        return stateFromBoolean(numLiveNeighbors == 3);
      }
    },
    LIVE {
      @Override
      public State shouldLive(int numLiveNeighbors) {
        return stateFromBoolean(numLiveNeighbors == 2 || numLiveNeighbors == 3);
      }
    };

    public static State stateFromBoolean(boolean b) {
      return b ? LIVE : DEAD;
    }      
    
    public abstract State shouldLive(int numLiveNeighbors);
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

  public State peek(Location location) {
    if (live.contains(location)) {
      return State.LIVE;
    }
    return State.DEAD;
  }
}
