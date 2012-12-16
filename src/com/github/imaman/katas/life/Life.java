package com.github.imaman.katas.life;

public class Life {

  public Life() {
    this(new Grid(), new RepdocutionPolicy());
  }
  
  public Life(Grid grid, RepdocutionPolicy policy) {
//    throw new UnsupportedOperationException();
  }

  boolean shouldLive(boolean isAlive, int numLiveNeighbors) {
    return (numLiveNeighbors == 2 && isAlive) || numLiveNeighbors == 3;
  }

}
