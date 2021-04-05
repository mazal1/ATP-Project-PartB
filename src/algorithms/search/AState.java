package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Objects;

public abstract class AState {

  private boolean visited;
  private int cost;
  private AState cameFrom;
//  private ArrayList<AState> adjList;

//  public ArrayList<AState> getAdjList() {
//    return adjList;
//  }

//  public void setAdjList(AState state) {
//    this.adjList.add(state);
//  }

  public AState(int cost) {
    this.visited = false;
    this.cost = cost;
    this.cameFrom = null;
//    this.adjList = new ArrayList<AState>();
    }

  public boolean getVisited() {return this.visited; }
  public int getCost(){return this.cost;}
  public AState getCameFrom(){return this.cameFrom;}

  public void setVisited(boolean visit) {this.visited = visit;}
  public void setCost(int cost) {this.cost = cost;}
  public void setCameFrom(AState cameFrom) {this.cameFrom = cameFrom; }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
