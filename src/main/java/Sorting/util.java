package Sorting;

public class util {

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.println("**************  Array **************");
        System.out.print("[");
        for(int i=0; i < arr.length; i++){
            if(i != arr.length-1) {
                System.out.print(" "+ arr[i] + ",");
            }
            else {
                System.out.print(" "+ arr[i]);
            }
        }
        System.out.print(" ]\n");
    }
}
