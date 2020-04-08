package Feb8;

import java.util.Arrays;

public class HighestProductWith3Integers {

    // Not the right solution. In case the lowest two numbers are negative whose value is greater than the highest positive numbers
    // This method doesn't account for that

    private static int highestProduct(int[] array) {
     // array is null or empty
        if(array == null || array.length == 0)
            return 0;
        int prod = 1;
     // array.length <=3, return prod of all numbers
        if(array.length <=3) {
            for(int i=0; i<array.length;i++)
            {
                prod*=array[i];
            }
            return prod;
        }
        //sort & multiply last 3 numbers
     Arrays.sort(array);

        for(int i = 1; i<=3; i++){
            prod*=array[array.length-i];
        }
        return prod;

    }

    private static int highestProdWith3Nums(int[] array) {
        // array is null or empty
        if(array == null || array.length <3)
            throw  new IllegalArgumentException("Less than 3 elements in the array");
        int highestProdOf2 = array[0] * array[1];
        int lowestProdOf2 = array[0] * array[1];

        int highest = Math.max(array[0], array[1]);
        int lowest = Math.min(array[0], array[1]);

        int highestProdOf3 = array[0] * array[1] * array[2];

        for(int i =2; i< array.length; i++) {
            int curr = array[i];

            highestProdOf3 = Math.max(Math.max(highestProdOf3, highestProdOf2*curr), curr*lowestProdOf2);
            highestProdOf2 = Math.max(Math.max(highestProdOf2,curr*highest), curr*lowest);
            lowestProdOf2 = Math.min(Math.max(lowestProdOf2,curr*lowest), curr*highest);

            highest = Math.max(curr, highest);
            lowest = Math.min(curr, lowest);
        }

        return highestProdOf3;

    }

    public static void main(String[] args) {
        int[] arr1 = {-10, -10,1,3,2};
//        int[] arr2 = null;
//        int[] arr3 = {4,5};
        int[] arr4 = { -9, 3, 1};

        System.out.println(highestProdWith3Nums(arr1));
        System.out.println(highestProdWith3Nums(arr4));


    }
}
