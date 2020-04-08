package codingProblems;

public class RotateImage {

    private void rotateImage(int[][] matrix) {
//        [
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//]
//becomes
//        [
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]

        // Transpose the matrix, turn rows into columns
        //        [
        //  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//]
//becomes
        //        [
//  [1,4,7],
//  [2,5,8],
//  [3,6,9]
//]
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        // rearrange the columns
        //        [
//  [1,4,7],
//  [2,5,8],
//  [3,6,9]
//]
        //becomes
//        [
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
        for(int i=0; i<len;i++){
            for(int j=0; j<len/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = temp;
            }
        }
    }

}
