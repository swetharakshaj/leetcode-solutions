package Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class MazeSourceToDestination {

    class Path {
        int row;
        int col;

        Path() {}
        Path(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    private ArrayList<Path> getPath(boolean[][] maze)
    {
        if(maze == null || maze.length == 0)
            return null;
        ArrayList<Path> result = new ArrayList<>();
        HashSet<Path> blockedCells = new HashSet<>();
        int row = maze.length;
        int col = maze[0].length;

        if(doesPathExist(maze, result, blockedCells, row-1, col-1))
        {
            return result;
        }
        return null;
    }

    private boolean doesPathExist(boolean[][] maze, ArrayList<Path> result, HashSet<Path> blockedCells, int row, int col) {

        if(row < 0 || col < 0 || !maze[row][col])
            return false;
        Path p = new Path(row, col);
        if(blockedCells.contains(p))
            return false;
        if((row == 0 && col == 0) || doesPathExist(maze, result, blockedCells, row-1, col) || doesPathExist(maze, result, blockedCells, row, col-1))
        {
            result.add(p);
            return true;
        }

        blockedCells.add(p);
        return false;

    }
}
