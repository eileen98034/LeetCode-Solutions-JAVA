/*
#1510 : Hard
Alice and Bob take turns playing a game, with Alice starting first.
Initially, there are n stones in a pile.  On each player's turn, that player \
makes a move consisting of removing any non-zero square number of stones in the pile.
Also, if a player cannot make a move, he/she loses the game.
Given a positive integer n. Return True if and only if Alice wins the game otherwise 
return False, assuming both players play optimally.
*/


class Solution {
    
    Map<Integer,Boolean> gameMap = new HashMap<>();

    public boolean winnerSquareGame(int n) {
        // get out quick
        if (n==0) 
            return false;
        
        if(gameMap.containsKey(n))
            return gameMap.get(n);
        
        boolean alice = false;
        for (int i = 1; i*i <= n; i++) {
            if (!winnerSquareGame(n - i*i)) {
                alice = true;
                break;
            }
        }
        gameMap.put(n,alice);
        return alice;
    }
    
}
