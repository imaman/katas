package com.github.imaman.katas.life;

import com.github.imaman.katas.life.Grid.State;

public class Life {

  public Life() {
    this(new Grid(), new RepdocutionPolicy());
  }
  
  public Life(Grid grid, RepdocutionPolicy policy) {
//    throw new UnsupportedOperationException();
  }

  boolean shouldLive(State state, int numLiveNeighbors) {
    return (numLiveNeighbors == 2 && state == State.LIVE) || numLiveNeighbors == 3;
  }

}
