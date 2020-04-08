package DynamicProgramming;

public class KnapSack01 {

    private static int findMaxweight(int[] val, int[] wt, int maxweight)
    {
        int[][] matrix = new int[val.length+1][maxweight+1];

        for(int i=0; i<=val.length; i++)
        {
            for(int j=0; j<=maxweight; j++)
            {
                if(i==0 || j==0)
                {
                    matrix[i][j] = 0;
                    continue;
                }

                if(j >= wt[i-1])
                {
                    matrix[i][j] = Math.max(matrix[i-1][j], val[i-1]+ matrix[i-1][j-wt[i-1]]);
                }
            else {
                    matrix[i][j] = matrix[i-1][j];
            }
        }
        }
        return matrix[val.length][maxweight];

        }

        public static void main(String[] args){
    int[] val = {1, 4, 5, 7};
    int[] wt = {1, 3, 4, 5};
    int maxWeight = 7;
    System.out.println(findMaxweight(val, wt, maxWeight));
    }


    /*
    Plan :

    1. create a matrix with num of rows = num of elements in weight/ val array +1 and num of columns = maxWeight+1
    2. Loop through with i as row and j as column
        - Initialize all entries of matrix with either row = 0 or column = 0 as 0
        - if column j > wt[row-1], apply formula matrix[i][j] = Math.max(matrix[i-1][j], val[i-1]+ matrix[i-1][i-wt[i-1]])
        - else matrix[i][j] = matrix[i-1][j]

     3. return matrix[val.length][maxWeight] or the last entry
     */
}


