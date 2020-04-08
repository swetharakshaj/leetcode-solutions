package codingProblems;

public class MergeSortedArray {

    static int[] nums1 = {1, 2, 3, 0, 0, 0};
    static int[] nums2 = {2, 5, 6};

    public  static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int nums1Size = m+n;
//        int nums2Size = n;
//        int numOfSwaps = 0;
//        int total = m+n;
//
//        while(m<0) {
//            if(n<0) {
//                if(nums1[nums1Size-m] < nums2[nums2Size-n]) {
//                    m--;
//                }
//                else {
//                    numOfSwaps++;
//                    nums1 = copyAndMove(nums1, nums1Size-m, nums2[nums2Size-n], m+numOfSwaps);
//                    n--;
//                    m--;
//                }
//            }

        int  i=0, j=0, z=0;
        int[] result = new int[m+n];
        if(m == 0) {
            System.arraycopy(result, 0, nums2, 0, m+n);
        }
        else if(n == 0) {
            System.arraycopy(result, 0, nums1, 0, m+n);
        }
        while(i<m) {
            if(j<n) {
                if(nums1[i] <= nums2[j]) {
                    result[z] = nums1[i];
                    i++;
                }
                else{
                    result[z] = nums2[j];
                    j++;
                }
                z++;
            }
        }

        while(j!=n) {
            result[z] = nums2[j];
            j++;
            z++;
        }

        System.arraycopy(result, 0, nums1, 0, m+n);

    }

//    private int[] copyAndMove(int[] arr, int pos, int eleToInsert, int newnums1ArrSize) {
//        int temp = arr[pos+1];
//        for(int i=newnums1ArrSize; i>=pos; i--) {
//            arr[i+1] = arr[i];
//        }
//        arr[pos] = eleToInsert;
//        return arr;
//    }

    public static void main(String args[]) {

    merge(nums1, 3, nums2, 3);
    for(int i=0; i<nums1.length; i++) {
        System.out.println(nums1[i]);
    }
    }
}
