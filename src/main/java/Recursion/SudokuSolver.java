package Recursion;

public class SudokuSolver {

    public boolean solveSudoku(char[][] board) {

        int row = -1;
        int col = -1;
        int n = board.length;
        boolean isFilled = true;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == '.')
                {
                    isFilled = false;
                    row = i;
                    col = j;
                    break;
                }
            }


            if(!isFilled)
                break;

        }

        if(isFilled)
            return true;

        for(int num=1; num<=n; num++)
        {
            if(isSafe(row, col, board, num, n))
            {
                board[row][col] = (char)(num+'0');
                if(solveSudoku(board))
                    return true;
                else
                    board[row][col] = '.';
            }
        }

        return false;

    }

    private boolean isSafe(int row, int col, char[][] board, int num, int len) {
        // check col
        for(int i=0; i<len; i++)
        {
            if(board[row][i] == (char)(num+'0'))
                return false;
        }

        // check row
        for(int j=0; j<len; j++)
        {
            if(board[j][col] == (char)(num+'0'))
                return false;
        }

        // check subgrid

        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for(int i=rowStart; i<rowStart+3; i++)
        {
            for(int j=colStart; j<colStart+3; j++)
            {
                if(board[i][j] == (char)(num+'0'))
                    return false;
            }
        }
        return true;
    }



}
