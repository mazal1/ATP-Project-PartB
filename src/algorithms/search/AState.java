package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public abstract class AState {
  //  private Position state;
    private int cost;
    private AState cameFrom;

    public AState(int cost) {
      //  this.state = position;
        this.cost = cost;
    }
//    public AState(int cost){
//      //  this.state = new Position(row,col);
//        this.cost = cost;
//    }
//    public Position getState(){return this.state;}
    public int getCost(){return this.cost;}
    public AState getCameFrom(){return this.cameFrom;}

  //  public void setState(Position state) {this.state = state;}
    public void setCost(int cost) {this.cost = cost;}
    public void setCameFrom(AState cameFrom) {this.cameFrom = cameFrom; }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
