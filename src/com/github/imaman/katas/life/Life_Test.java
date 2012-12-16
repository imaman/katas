package com.github.imaman.katas.life;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.github.imaman.katas.life.Grid.State;

@RunWith(Enclosed.class)
public class Life_Test {
  
  public static class LivenessRules {
    @Test
    public void aLiveCellWithOneNeighborDiesOfLonliness() {
      assertFalse(State.DEAD.shouldLive(1));
    }
  
    @Test
    public void aLiveCellWithTwoOrThtreeNeighborKeepsLiving() {
      assertTrue(State.LIVE.shouldLive(2));
      assertTrue(State.LIVE.shouldLive(3));
    }
    
    @Test
    public void aLiveCellWithFourOrMoreNeighborDies() {
      assertFalse(State.LIVE.shouldLive(4));
    }
  
    @Test
    public void aDeadCellWithThreeNeighborsBecomesLive() {
      assertTrue(State.DEAD.shouldLive(3));
    }
  
    @Test
    public void aDeadCellWithTwoNeighborsKeepsDying() {
      assertFalse(State.DEAD.shouldLive(2));
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
  
//  public static class ComputeNextStateOfCell {
//    public void f() {
//      Grid grid = Mockito.mock(Grid.class);
//      RepdocutionPolicy repdocutionPolicy = Mockito.mock(RepdocutionPolicy.class);
//      
//      Location location25 = new Location(2, 5);
//      Mockito.when(grid.liveNeighborsCount(location25)).thenReturn(1000);
//      Mockito.when(repdocutionPolicy.shouldLive(1000)).thenReturn(true);
//      
//
//      Life life = new Life(grid, repdocutionPolicy);
//      life.nextStateOf()
//      
//
//      
//      
//
//    }
    
    
//    grid.liveNeighborsCount(new Location(2, 5));
//    Mockito.when();
    
//    Life life = new Life(grid);
//    life.
//  }
  
  
}
