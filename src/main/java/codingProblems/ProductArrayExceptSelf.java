package codingProblems;


//This problem was asked by Uber.
//
//        Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
//
//        For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
//
//        Follow-up: what if you can't use division?

public class ProductArrayExceptSelf {
    private static int[] solutionUsingDivision(int[] array) {
        int product = 1;
        for(int i =0; i < array.length ; i++) {
            product*= array[i];
        }
        int[] result = new int[array.length];
        for(int i=0; i<array.length; i++) {
            result[i] = product/array[i];
        }
        return result;
    }

    // without using division

    // solution 1 - have a left array with product of all elements till then from left. have a right array with prod opf all elements from right till then
    // prod array will multiply ith element from left and right to return prod

    // time o(n), space o(n), auxillary space - o(n)

    private static int[] solutionWithoutDivision(int[] array) {
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int[] prod = new int[array.length];
        left[0] = 1;
        right[array.length-1] = 1;

        for(int i=1; i<array.length; i++) {
            left[i] = array[i-1] * left[i-1];
        }

        System.out.println("LEFT ARRAY");
        for (int i = 0; i < left.length; i++) {

            System.out.print(left[i] + " ");
        }
        System.out.println();

        for(int j=array.length-2; j>=0; j--){
            right[j] = array[j+1]* right[j+1];
        }

        System.out.println("RIGHT ARRAY");
        for (int i = 0; i < right.length; i++) {

            System.out.print(right[i] + " ");
        }
        System.out.println();


        for(int i=0; i< array.length; i++) {
            prod[i] = left[i] * right[i];
        }

        return prod;


    }

    // solution without division - directly calcualte the prod array with two passes cutting out the left and right intermediate arrays
    //  time o(n), space o(n), auxillary space - o(1)

    private static int[] solutionWithoutDivisionOptimal(int[] array) {
        int len  = array.length;
        int[] prod = new int[len];
        int temp = 1;
        prod[len-1] = 1;

        System.out.println("first loop ---> ");
        for(int i= len-2; i>=0; i--){
            prod[i] = prod[i+1]* array[i+1];

            System.out.println("Element at "+ i+"th position is :"+ prod[i]);

        }


        System.out.println("AFTER 1st loop");
        for (int i = 0; i < prod.length; i++) {

            System.out.print(prod[i] + " ");
        }
        System.out.println();

        System.out.println("Second loop -->");
        for(int i=1; i< len; i++) {
            prod[i] = prod[i]* temp;
            temp*=array[i];
            System.out.println("Element at "+ i+"th position is :"+ prod[i]+ " and temp is: "+ temp);
        }


        System.out.println("After 2nd loop");
        for (int i = 0; i < prod.length; i++) {

            System.out.print(prod[i] + " ");
        }
        System.out.println();
        return prod;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        int[] result = solutionWithoutDivisionOptimal(array);
        System.out.println("PROD ARRAY");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
