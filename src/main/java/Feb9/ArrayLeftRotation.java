package Feb9;

public class ArrayLeftRotation {

    public static String leftRotateArray(int[] arr, int d) {

        if(arr == null || arr.length == 0 || d < 0)
            throw new IllegalArgumentException("Invalid input");
        if(arr.length == 1)
            return String.valueOf(arr[0]);
        d = d % arr.length;

        StringBuilder str = new StringBuilder();

        appendToString(str, arr,  d, arr.length-1);
        appendToString(str, arr, 0, d-1);
        return str.toString().trim();

    }

    private static void appendToString(StringBuilder str, int[] arr, int start, int end) {
        for(int i=start; i<= end; i++ ) {
            str.append(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 8, 11, 6, 14, 3, 1};
        System.out.println(leftRotateArray(arr1, -1));
    }
}
