package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public abstract class AState {

  private String color;
  private int cost;
  private AState cameFrom;

  public AState(int cost) {
    this.color = "White";
    this.cost = cost;
    this.cameFrom=null;
    }

  public String getColor() {return color; }
  public int getCost(){return this.cost;}
  public AState getCameFrom(){return this.cameFrom;}

  public void setColor(String color) {this.color = color;}
  public void setCost(int cost) {this.cost = cost;}
  public void setCameFrom(AState cameFrom) {this.cameFrom = cameFrom; }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
