package Feb10;

import java.util.*;

public class LuckBalance {

    // https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms

    public static int calculateLuckBalance (int k, int[][] contests) {
        if(contests == null || k < 0)
            return 0;
        List<Integer> importantList = new ArrayList<>();
        List<Integer> notImportantList = new ArrayList<>();

        for(int i=0; i<contests.length; i++) {
            if(contests[i][1] == 0) {
                notImportantList.add(contests[i][0]);
            }
            else {
                importantList.add(contests[i][0]);
            }
        }

        Collections.sort(importantList);

        int maxLuckBalance = 0;
        if(notImportantList.size() > 0) {
            for(Integer num : notImportantList) {
                maxLuckBalance+=num;
            }
        }

        if(importantList.size() > 0) {
            for(int i=0; i<importantList.size()-k; i++) {
                maxLuckBalance-=importantList.get(i);
            }

            for(int i=importantList.size()-k; i<importantList.size(); i++) {
                maxLuckBalance+=importantList.get(i);
            }
        }


        return maxLuckBalance;
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 0}, {2, 0}, {1, 0}, {8, 0}, {10, 0}, {5, 0}};
        int k = 6;

        System.out.println(calculateLuckBalance(k, arr));
    }
}
