package com.github.imaman.katas.life;

import com.github.imaman.katas.life.Grid.State;


public class Life {

  private final Grid grid;

  public Life() {
    this(new Grid(), new RepdocutionPolicy());
  }
  
  public Life(Grid grid, RepdocutionPolicy policy) {
    this.grid = grid;
  }

  public State nextStateOf(Location location) {
    State state = grid.peek(location);
    int liveCount = grid.liveNeighborsCount(location);
    return state.shouldLive(liveCount);
  }

  public Grid next() {
    Grid nextGrid = new Grid();
    
    for (Location location : grid) {
      for (Location l : location.neighbors()) {
        int n = grid.liveNeighborsCount(l);
        State nextState = grid.peek(l).shouldLive(n);
        if (nextState == State.LIVE) {
          nextGrid.liveAt(l);
        }
      }
    }
    
    return nextGrid;
  }

}
