package com.github.imaman.katas.life;

import java.util.HashSet;
import java.util.Set;

public class Location {

  private final int row;
  private final int col;

  public Location(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public boolean isNeighborOf(Location location) {
    return neighbors().contains(location);
  }

  Set<Location> neighbors() {
    HashSet<Location> result = new HashSet<Location>();
    result.add(new Location(row - 1, col - 1));
    result.add(new Location(row - 1, col));
    result.add(new Location(row - 1, col + 1));
    
    result.add(new Location(row, col - 1));
    result.add(new Location(row, col + 1));

    result.add(new Location(row + 1, col - 1));
    result.add(new Location(row + 1, col));
    result.add(new Location(row + 1, col + 1));

    return result;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + col;
    result = prime * result + row;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Location other = (Location) obj;
    if (col != other.col)
      return false;
    if (row != other.row)
      return false;
    return true;
  }
}
