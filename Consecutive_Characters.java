/*
#1446 : Easy
Given a string s, the power of the string is the maximum length of a non-empty substring 
that contains only one unique character.  Return the power of the string.
*/

class Solution {
    public int maxPower(String s) {
        
        int maxPwr = 1;
        char[] chrArr = s.toCharArray();
        
        for (int i = 1; i < chrArr.length; i++) {
            int cnt = 1;
            while (i < chrArr.length && chrArr[i] == chrArr[i-1]) {
                maxPwr = Math.max(maxPwr,++cnt);
                i++;
            }
        }
        
        return maxPwr;
    }
}
