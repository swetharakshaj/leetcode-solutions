package codingProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleGetRow {

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) throw new IllegalArgumentException();
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<= rowIndex; i++) {
            result.add(1);
            for(int j=i-1; j>0; j--) {
                result.set(j, result.get(j-1)+ result.get(j));
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        List<Integer> result = getRow(3);
    }
}
