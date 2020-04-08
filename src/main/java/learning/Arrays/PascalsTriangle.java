package learning.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    private static List<List<Integer>> pascalsTriangle (int k) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();

        for (int i=0; i<k; i++ ){
            List<Integer> individualRows = new ArrayList<Integer>();
            individualRows.add(1);
            for(int j=1; j <=i; j++) {
                individualRows.add(j, getItem(rows, i, j, k));
            }
            rows.add(individualRows);
        }
        printLists(rows, k);
        return rows;
    }

    private static int getItem(List<List<Integer>> rows, int i, int j, int k) {

        int first = rows.get(i-1).get(j-1);
        int second = ( (j == k) || (i < j+1))? 0 : rows.get(i-1).get(j);

        return first + second ;
    }

    //alternative 0ms runtime code on leetcode
    private static List<List<Integer>> anotherapproach(int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(k == 0) return result;

        List<Integer> individualRow = new ArrayList<Integer>();
        individualRow.add(1);
        result.add(individualRow);

        for(int i =1; i < k; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for(int j=1; j<i; j++) {
                int val = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                temp.add(val);
            }
            temp.add(1);
            result.add(temp);
        }

        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if(numRows == 0) return result;
        result.add(Arrays.asList(1));
        for(int i=1; i<numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1; j<i; j++) {
                temp.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }


    private static void printLists(List<List<Integer>> lists, int k) {
        for(int i = 0; i <k; i++) {
            List<Integer> individualrow = lists.get(i);
            for(int j=0; j < individualrow.size(); j++) {
                System.out.print(individualrow.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printLists(generate(5), 5);

    }
}
