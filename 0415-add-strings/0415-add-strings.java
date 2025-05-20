import java.math.BigInteger;

class Solution {
    public String addStrings(String num1, String num2) {
        // Convert to BigInteger
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);

        // Add the numbers
        BigInteger n3 = n1.add(n2);

        // Convert to String
        String sum = String.valueOf(n3);
        return sum;
    }
}
