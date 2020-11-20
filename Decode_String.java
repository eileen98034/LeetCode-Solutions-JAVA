/*
#394 : Medium
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string
inside the square brackets is being repeated exactly k times. Note 
that k is guaranteed to be a positive integer.  You may assume that 
the input string is always valid; No extra white spaces, square brackets 
are well-formed, etc. Furthermore, you may assume that the original data 
does not contain any digits and that digits are only for those repeat 
numbers, k. For example, there won't be input like 3a or 2[4].
*/

class Solution {
    public String decodeString(String s) {
        
        if (s.length() == 0 || s == null)
            return s;
        
        Stack<String> strStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();
        String decoded = "";
        
        char[] sChrArr = s.toCharArray();

        int j = 0;
        while (j < sChrArr.length) {
            if (Character.isDigit(sChrArr[j])) {
                int num = 0;
                while (Character.isDigit(sChrArr[j])) {
                    num = num*10 + (sChrArr[j]-'0');
                    j++;
                }
                numStk.push(num);
            } else if (sChrArr[j] == '[') { 
                strStk.push(decoded);
                decoded = "";
                j++;
            } else if (sChrArr[j] == ']') {
                String temp = strStk.pop();
                int multiplier = numStk.pop();
                for (int i=0; i < multiplier; i++)
                    temp = temp + decoded;
                decoded = temp;
                j++;
            } else {
                decoded += sChrArr[j++];
            }
        }
        return decoded;
    }
                
}
