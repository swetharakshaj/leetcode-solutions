package learning.Arrays;

class ArrayPlusOne {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len-1; i >=0; --i) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        if(digits[0] == 0) {
            int[] newArray = new int[len+1];
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }


    public static void main(String[] args) {
        int[] a ={1, 2, 3};
        int[] b ={4,3,2,1};
        int[] c = { 5, 7, 9};
        int[] d = { 9, 9};

        printArray(plusOne(a));
        printArray(plusOne(b));
        printArray(plusOne(c));
        printArray(plusOne(d));
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println();
    }

}
