/*
#985 : Medium
You have an initial power of P, an initial score of 0, and a bag of tokens where tokens[i] is the value of the ith 
token (0-indexed).
Your goal is to maximize your total score by potentially playing each token in one of two ways:

1. If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
2. If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.

Each token may be played at most once and in any order. You do not have to play all the tokens.
Return the largest possible score you can achieve after playing any number of tokens.
*/



class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        if (tokens==null || tokens.length == 0)
            return 0;
        
        Arrays.sort(tokens);
        int score=0, points=0, i=0, j=tokens.length-1;
        
        while (i <= j) {
            if(P >= tokens[i]) {
                P = P-tokens[i++];
                score = Math.max(score,++points);
            } else if (points > 0) {
                points--;
                P = P + tokens[j--];  // user largest token here
            } else {
                break;
            }
        }
       
        return score;
    }
}
