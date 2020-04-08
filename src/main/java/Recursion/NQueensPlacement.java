package Recursion;

import java.util.Arrays;

public class NQueensPlacement {

    int[][] solutionGrid;
    class Position
    {
        int row;
        int col;

        Position()
        {

        }

        Position(int r, int c){
            row = r;
            col = c;
        }
    }

    private void nQueenPlacement(int n)
    {
        if(n<3)
            throw new IllegalArgumentException("No placements for n queens possible");
        Position[] pos = new Position[n];
        solutionGrid = new int[n][n];
        if(nQueenBacktrack(0, n, pos))
        {
            populateGrid(pos);
        }
    }

    private boolean nQueenBacktrack(int row, int n, Position[] pos)
    {
        if(row == n)
            return true;

        for(int col=0; col<n; col++)
        {
            boolean isFound = true;

            // When you are at every row, you have to check if the previous rows' queens positions will attack the current row
            // That's why we iterate from row o to curr row here
            for(int q=0; q<row; q++)
            {
                if(pos[q].col == col || (pos[q].row + pos[q].col == row+col) || (pos[q].row - pos[q].col == row-col))
                {
                    isFound = false;
                    break;
                }
            }

            if(isFound)
            {
                pos[row] = new Position(row, col);
                if(nQueenBacktrack(row+1, n, pos))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private void populateGrid(Position[] pos)
    {
        for(int r=0; r<pos.length; r++)
        {
            for(int c=0; c<pos.length; c++)
            {
                if(pos[r].col == c)
                    solutionGrid[r][c] = 1;
                else
                    solutionGrid[r][c] = 0;
            }
        }
    }

    public static void main(String[] args)
    {
        NQueensPlacement obj = new NQueensPlacement();
        int n=4;
        obj.nQueenPlacement(n);

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(obj.solutionGrid[i][j] + " ");
            }

            System.out.println();
        }
    }

}
