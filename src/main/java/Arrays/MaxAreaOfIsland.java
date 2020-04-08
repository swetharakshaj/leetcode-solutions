package Arrays;

public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }

        int maxArea = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    // sending grid, pointers to the starting location on grid and maxArea as 0
                    int temp = dfsHelper(grid, i, j, 0);
                    maxArea = Math.max(temp, maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int dfsHelper(int[][] grid, int i, int j, int maxArea)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0)
        {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfsHelper(grid, i-1, j, maxArea) + dfsHelper(grid, i+1, j, maxArea)
                + dfsHelper(grid, i, j-1, maxArea) + dfsHelper(grid, i, j+1, maxArea);
    }

    public static void main(String[] args)
    {
        int[][] input ={ {0,0,0,0,0,0,0,0}};
       // int[][] input = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(input));

    }
}
