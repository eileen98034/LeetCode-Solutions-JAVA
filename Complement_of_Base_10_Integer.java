/*
1009 : Easy
*/
class Solution {
    public int bitwiseComplement(int N) {
        
        // get out quick
        if (N == 0) return 1;
        
        // init
        char one = '1', zero = '0';
        String newStr = "", candidates = "01";
        String bin = Integer.toBinaryString(N);
        
        // flip bits
        for (char c : bin.toCharArray()) {
            if (candidates.indexOf(c) == 0)
                newStr += String.valueOf(one);
            else 
                newStr += String.valueOf(zero);
        }

        // return
        return Integer.parseInt(newStr,2);
    }
}
