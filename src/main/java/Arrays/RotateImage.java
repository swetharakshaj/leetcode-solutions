package Arrays;

public class RotateImage {

    static void rotateImage(int[][] a) {
/*
1. Make columns -> rows
2. Iterate through every row to reverse elements from perimeter
*/

        for (int i=0; i<a.length; i++) {
            for (int j = i + 1; j < a[i].length; j++) {
                swap(a, i, j);
            }
        }

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length/2; j++)
            {
                swap(a, i, j, a[i].length-1-j);
            }
        }


    }

    static void swap(int[][] a, int i, int j) {
        int temp = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = temp;
    }

    static void swap(int[][] a, int i, int j1, int j2) {
        int temp = a[i][j1];
        a[i][j1] = a[i][j2];
        a[i][j2] = temp;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage(a);
        for (int i = 00; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

}
