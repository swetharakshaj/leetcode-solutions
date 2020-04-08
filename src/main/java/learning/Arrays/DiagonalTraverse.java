package learning.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0) {
            return new int[0];
        }
        // m X n matrix, m = num of rows, n = num of columns

        int m = matrix.length;
        int n = matrix[0].length;

        // initialize the response array
        int[] returnArr = new int[m*n];
        int k =0;

        ArrayList<Integer> intermediate = new ArrayList<>();


        for(int i =0; i < m+n-1; i++) {

            intermediate.clear();

            int r = i < n ? 0: i-n+1;
            int c = i < n ? i : n-1;

            while(r<m && c > -1) {
                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            if(i%2 == 0) {
                Collections.reverse(intermediate);
            }

            for(int j = 0; j< intermediate.size(); j++) {
                returnArr[k++] = intermediate.get(j);
            }
        }

        return returnArr;

    }

    public static void main(String[] args) {

        int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayPlusOne.printArray(findDiagonalOrder(array1));
    }

}
