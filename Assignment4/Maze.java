package Maze;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
        // COMPLETE HERE FOR PROBLEM 1
        if (x >= maze.getNRows() || y >= maze.getNCols()) {
            return false;
        }
        if (x < 0 || y < 0) {
            return false;
        }
        if (maze.getColor(x, y) != NON_BACKGROUND) {
            return false;
        }
        if (x == maze.getNRows()-1 && y == maze.getNCols()-1) {
            maze.recolor(x, y, PATH);
            return true;
        }

        maze.recolor(x, y, TEMPORARY);
        boolean z = findMazePath(x-1, y) || findMazePath(x+1, y) || findMazePath(x, y-1) || findMazePath(x, y+1);
        if (z) {
            maze.recolor(x, y, PATH);
        }
        return z;
    }

    // ADD METHOD FOR PROBLEM 2 HERE

    /**
     * Helper method for problem 2.
     * @param x - x coordinate being visited
     * @param y - y coordinate being visited
     * @param result - list of successful paths being recorded up to now
     * @param trace - the trace of the current path being explored
     */
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
        if (x >= maze.getNRows() || y >= maze.getNCols()) {
            return;
        }
        if (x < 0 || y < 0) {
            return;
        }
        if (maze.getColor(x, y) != NON_BACKGROUND) {
            return;
        }
        if (x == maze.getNRows()-1 && y == maze.getNCols()-1) {
            maze.recolor(x, y, PATH);
            PairInt p = new PairInt(x, y);
            trace.push(p);
            ArrayList<PairInt> list = new ArrayList<PairInt>();
            list.addAll(trace);
            result.add(list);
            trace.pop();
        }
        maze.recolor(x,y, PATH);
        PairInt p2 = new PairInt(x, y);
        trace.push(p2);
        findMazePathStackBased(x+1, y, result, trace);
        findMazePathStackBased(x-1, y, result, trace);
        findMazePathStackBased(x, y+1, result, trace);
        findMazePathStackBased(x, y-1, result, trace);
        maze.recolor(x, y, NON_BACKGROUND);
        trace.pop();
    }

    /**
     * Creates a list of solutions to the maze.
     * @param x
     * @param y
     * @return the list of solutions
     */
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
        Stack<PairInt> trace = new Stack<>();
        findMazePathStackBased(0, 0, result, trace);
        return result;
    }

    // ADD METHOD FOR PROBLEM 3 HERE
    /**
     * finds the shortest path in the list of paths
     * @param x
     * @param y
     * @return - shortest path
     */
    public ArrayList<PairInt> findMazePathMin(int x, int y) {
        if (!findMazePath(x, y)) {
            return null;
        }

        maze.recolor(PATH, NON_BACKGROUND);
        maze.recolor(TEMPORARY, NON_BACKGROUND);

        ArrayList<ArrayList<PairInt>> list = findAllMazePaths(x,y);
        int min = list.get(0).size();
        ArrayList<PairInt> yes = list.get(0);

        for (int i = 0; i < list.size(); i ++) {
            int size = list.get(i).size();

            if (size < min){
                min = size;
                yes = list.get(i);
            }
        }

        return yes;
    }

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
