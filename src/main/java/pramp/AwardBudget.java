package pramp;

import java.util.*;


public class AwardBudget {

    static double findGrantsCap(double[] grantsArray, double newBudget) {

        List<Double> grantList = new ArrayList<>();
        for(double num : grantsArray) {
            grantList.add(new Double(num));
        }
        Collections.sort(grantList, Collections.reverseOrder());

        double surplus = sumOfArray(grantList) - newBudget;

        grantList.add(0d);

        if(surplus<=0) return grantsArray[0];


        int i=0;
        while(i<grantList.size()) {
                surplus = surplus - (i+1)*(grantList.get(i) - grantList.get(i+1));
                if(surplus <=0) break;
                i++;
        }


        return grantList.get(i+1) + (-surplus / (i+1));

    }

    private static Double sumOfArray(List<Double> grantsList) {
        Double sum = 0d;
        for(Double num : grantsList) {
            sum+=num;
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
