package Feb8;

public class ArrayProductExceptAtIndex {

    // time o(n)
    // space o(n)
    // ancillary space o(n)
    public int[] productArrayExceptAtindex(int[] array) {
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int[] prod = new int[array.length];

        left[0] = 1;
        right[array.length - 1] = 1;

        for (int i = 1; i < array.length; i++) {
            left[i] = array[i - 1] * left[i - 1];
        }

        for (int i = array.length - 2; i >= 0; i--) {
            left[i] = array[i + 1] * left[i + 1];
        }

        for (int i = 0; i < array.length; i++) {
            prod[i] = left[i] * right[i];
        }


        return prod;
    }

    public static int[] productArrayWithOnlyOneExtraArray(int[] array) {
        int[] prod = new int[array.length];
        prod[array.length-1] = 1;
        int temp = 1;

        for(int i = array.length-2; i>=0; i--) {
            prod[i] = prod[i+1] * array[i+1];
        }

        for(int i = 0; i< array.length; i++) {
            prod[i] = temp * prod[i];
            temp*=array[i];
        }
        return prod;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 1, 3, 4};
        int[] result = productArrayWithOnlyOneExtraArray(arr);


        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
