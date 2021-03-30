package algorithms.mazeGenerators;

public class Point {
    private int p_row;
    private int p_col;
    private Point parent;

    public Point(int p_row, int p_col, Point parent) {
        this.p_row = p_row;
        this.p_col = p_col;
        this.parent = parent;
    }


    public int getP_row() {
        return p_row;
    }

    public int getP_col() {
        return p_col;
    }

    public Point getParent() {
        return parent;
    }
    @Override
    public String toString() {
        return "Point{" +
                "p_row=" + p_row +
                ", p_col=" + p_col +
                ", parent=" + parent +
                '}';
    }


    // compute opposite node given that it is in the other direction from the parent
    public Point opposite() {
        if (p_row != parent.getP_row())
        {
            if (p_row > parent.getP_row())
            {
                return new Point(p_row + 1, p_col, this);

            }
            else
            {
                return new Point(p_row - 1, p_col, this);

            }
        }
        if (p_col != parent.getP_col())
        {
            if (p_col > parent.getP_col())
            {
                return new Point(p_row + 1, p_col+1, this);

            }
            else
            {
                return new Point(p_row , p_col-1, this);

            }
        }
        return null;
    }

}
