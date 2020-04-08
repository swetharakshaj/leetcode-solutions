package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class sudoku2 {

//    boolean sudoku2(char[][] grid) {
//
//        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
//
//        resetMap(charMap);
//
//        int uniqueCounter = 0;
//
//
//// column checks
//        for(int i=0; i< grid.length; i++) {
//            for(int j=0; j<9; j++) {
//                if(charMap.containsKey(grid[j][i]))
//                {
//                    charMap.replace(grid[j][i],charMap.get(grid[j][i]) + 1);
//                }
//                if(!resultCheck(charMap)) return false;
//                resetMap(charMap);
//            }
//        }
//// row checks
//
//        for(int i=0; i< grid.length; i++) {
//            for(int j=0; j<9; j++) {
//                if(charMap.containsKey(grid[i][j]))
//                {
//                    charMap.replace(grid[i][j],charMap.get(grid[i][j]) + 1);
//                }
//                if(!resultCheck(charMap)) return false;
//                resetMap(charMap);
//            }
//        }
//
//// sub matrix checks
//        for(int i=0; i<grid.length; i+=3)
//        {
//            for(int j=0; j<grid[i].length; j+=3)
//            {
//
//            }
//        }
//
//        return true;
//    }

    boolean sudoku2(char[][] grid) {
        int n = grid.length;

        Set<String> set = new HashSet<String>();

        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row/3 + " " + col/3))
                    return false;
            }
        }

        return true;
    }


    private boolean resultCheck(HashMap<Character, Integer> charMap) {
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if(entry.getValue() > 1) return false;
        }
        return true;
    }

    static void resetMap(HashMap<Character, Integer> map) {
        if(map.isEmpty()) {
            for(int i=1; i<=9; i++) {
                map.put((char)i, 0);
            }
        }
        else {
            for(int i=1; i<=9; i++) {
                map.replace((char)i, 0);
            }
        }

    }
}
