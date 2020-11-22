/*
#902 : Hard
Given an array of digits, you can write numbers using each digits[i] as many times as we want.  
For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
Return the number of positive integers that can be generated that are less than or equal to a given integer n.
*/

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        
        String s = String.valueOf(n+1);
        int[] dp = new int[s.length()+1];
        
        for (int i=s.length()-1; i>=0; i--) {
            int j = s.charAt(i)-'0';
            for (int k=0; k<digits.length; k++) {
                int m = digits[k].charAt(0)-'0';
                if (m > j)
                    break;
                if (m < j)
                    dp[i] += (int)Math.pow(digits.length, s.length()-1-i);
                else if (m == j) {
                    dp[i] += dp[i+1];
                    break;
                }
            }
        }
        
        for (int i=1; i<s.length(); i++)
            dp[0] += Math.pow(digits.length,i);
        
        return dp[0];
        
    }
}
