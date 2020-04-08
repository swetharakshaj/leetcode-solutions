package Arrays;

public class FindFirstDup {

    static int firstDuplicate(int[] a) {

        for(int i=0; i< a.length; i++) {
            if(a[Math.abs(a[i]) -1] > 0)
            {
                a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
            }
            return
                    Math.abs(a[i]);
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] a = {2, 1, 3, 5, 3, 2};
        System.out.println(firstDuplicate((a)));

    }
}
