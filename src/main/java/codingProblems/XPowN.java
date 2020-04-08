package codingProblems;

public class XPowN {

    private static double pow(double x, long n)
    {
        if(n < 0)
        {
            x = 1/x;
            n = -n;
        }

        return fastPow(x, n);

    }

    private static double fastPow(double x, long n) {
        if(n == 0)
            return 1;

        double half = fastPow(x, n/2);
        if(n%2 == 0)
        {
            return half * half;
        }
        else
        {
            return half * half * x;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(pow(2, -4));
    }
}

