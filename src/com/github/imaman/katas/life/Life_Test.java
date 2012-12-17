package com.github.imaman.katas.life;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.github.imaman.katas.life.Grid.State;

@RunWith(Enclosed.class)
public class Life_Test {
  
  public static class LivenessRules {
    @Test
    public void aLiveCellWithOneNeighborDiesOfLonliness() {
      assertSame(State.DEAD, State.DEAD.shouldLive(1));
    }
  
    @Test
    public void aLiveCellWithTwoOrThtreeNeighborKeepsLiving() {
      assertSame(State.LIVE, State.LIVE.shouldLive(2));
      assertSame(State.LIVE, State.LIVE.shouldLive(3));
    }
    
    @Test
    public void aLiveCellWithFourOrMoreNeighborDies() {
      assertSame(State.DEAD, State.LIVE.shouldLive(4));
    }
  
    @Test
    public void aDeadCellWithThreeNeighborsBecomesLive() {
      assertSame(State.LIVE, State.DEAD.shouldLive(3));
    }
  
    @Test
    public void aDeadCellWithTwoNeighborsKeepsDying() {
      assertSame(State.DEAD, State.DEAD.shouldLive(2));
    }
  }
  
  public static class Grid_Test {
    @Test
    public void whenEmptyAllCellsAreDead() {
      Grid grid = new Grid();
      assertEquals(State.DEAD, grid.peek(new Location(4, 10)));
    }

    @Test
    public void returnsLiveForLiveCells() {
      Grid grid = new Grid();
      grid.liveAt(new Location(2, 10));
      assertEquals(State.LIVE, grid.peek(new Location(2, 10)));
    }

    @Test
    public void returnsDeadIfNoLiveCellAtThatLocation() {
      Grid grid = new Grid();
      grid.liveAt(new Location(2, 10));
      assertEquals(State.DEAD, grid.peek(new Location(3, 10)));
    }
  }
  
  public static class NeighborCount {    
    @Test
    public void findsNeighbors() {
      Location loc23 = new Location(2, 3);
      assertTrue(loc23.isNeighborOf(new Location(1, 2)));
      assertTrue(loc23.isNeighborOf(new Location(1, 3)));
      assertTrue(loc23.isNeighborOf(new Location(1, 4)));
      
      assertTrue(loc23.isNeighborOf(new Location(2, 2)));
      assertTrue(loc23.isNeighborOf(new Location(2, 4)));
      
      assertTrue(loc23.isNeighborOf(new Location(3, 2)));
      assertTrue(loc23.isNeighborOf(new Location(3, 3)));
      assertTrue(loc23.isNeighborOf(new Location(3, 4)));
    }

    @Test
    public void emptyGridHasNoNeighbors() {
      Grid grid = new Grid();
      assertEquals(0, grid.liveNeighborsOf(new Location(10, 10)).size());      
    }

    @Test
    public void findsLiveNeighbors() {
      Grid grid = new Grid();
      grid.liveAt(new Location(10, 5));
      assertEquals(1, grid.liveNeighborsOf(new Location(10, 6)).size());      
    }

    @Test
    public void doesNotIncludeLiveCellsThatAreNotNeighbors() {
      Grid grid = new Grid();
      grid.liveAt(new Location(9, 5));
      grid.liveAt(new Location(10, 5));
      grid.liveAt(new Location(11, 5));
      assertEquals(2, grid.liveNeighborsOf(new Location(11, 6)).size());      
    }

    @Test
    public void returnsZeroIfAllLiveCellsAreNotNeighbors() {
      Grid grid = new Grid();
      grid.liveAt(new Location(9, 5));
      grid.liveAt(new Location(10, 5));
      grid.liveAt(new Location(11, 5));
      assertEquals(0, grid.liveNeighborsOf(new Location(0, 0)).size());      
    }
  }
  
  public static class ComputeNextState {
    
    @Test
    public void ofSingleCell() {
      Grid grid = Mockito.mock(Grid.class);
      
      Location aLocation = new Location(2, 5);
      Mockito.when(grid.liveNeighborsCount(aLocation)).thenReturn(1000);
      
      State state = Mockito.mock(State.class);
      Mockito.when(grid.peek(aLocation)).thenReturn(state);
      
      State nextState = Mockito.mock(State.class);
      Mockito.when(state.shouldLive(1000)).thenReturn(nextState);

      Life life = new Life(grid, null);
      assertSame(nextState, life.nextStateOf(aLocation));
    }
    
    @Test
    public void ofGrid() {
      Grid grid = new Grid();
      assertEquals(0, grid.count());
      grid.liveAt(new Location(0, 1));
      grid.liveAt(new Location(1, 1));
      grid.liveAt(new Location(2, 1));
      assertEquals(3, grid.count());
      
      Life life = new Life(grid, null);
      Grid nextGrid = life.next();
            
      assertEquals(3, grid.count());
      assertSame(State.LIVE, nextGrid.peek(new Location(1, 0)));
      assertSame(State.LIVE, nextGrid.peek(new Location(1, 1)));
      assertSame(State.LIVE, nextGrid.peek(new Location(1, 2)));
      
    }    
  }
    
    
//    grid.liveNeighborsCount(new Location(2, 5));
//    Mockito.when();
    
//    Life life = new Life(grid);
//    life.
//  }
  
  
}
