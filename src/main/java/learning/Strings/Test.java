package learning.Strings;

import java.time.Duration;
import java.time.Instant;

public class Test {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String s = "";
        int n = 10000;
        for (int i = 0; i < n; i++) {
            s += "hello";
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
