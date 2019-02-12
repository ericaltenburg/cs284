package Maze;

/**
 * Author: Eric Altenburg
 * Date: 10/18/18
 **/
public class PairInt {
    //Data fields
    private int x;
    private int y;

    //Constructor
    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * checks to see if the two pairs are equal
     * @param p
     * @return true if equal, false if not
     */
    public boolean equals(Object p) {
        PairInt p2 = (PairInt) p;

        return this.x == p2.getX() && this.y == p2.getY();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("(" +this.x);
        s.append(", ");
        s.append(this.y +")");

        return s.toString();
    }

    /**
     * creates a copy of the pair
     * @return the copy of the pair
     */
    public PairInt copy() {
        PairInt p1 = new PairInt(this.x, this.y);
        return p1;
    }
}


