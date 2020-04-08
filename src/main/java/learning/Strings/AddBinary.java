package learning.Strings;

import java.math.BigInteger;

public class AddBinary {

    private static String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1, carry = 0;
        StringBuilder str = new StringBuilder();
        while(i >= 0 || j >=0)
        {
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
            }
            if(j >=0) {
                sum +=b.charAt(j) - '0';
            }
            carry = sum / 2;
            str.append(sum%2);
            i--;
            j--;
        }
        if(carry != 0) str.append(carry);
        return str.reverse().toString();
    }

    private static String addbinaryBitManipulation(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }


    public static void main(String[] args) {
        System.out.println("Add Binary");
        System.out.println(addBinary("1111", "0010"));
        System.out.println("Add binary with Bit manipulation");
        System.out.println(addBinary("1111", "0010"));
    }
}
