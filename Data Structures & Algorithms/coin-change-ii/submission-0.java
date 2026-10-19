class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        } 

        return solve(coins.length-1,amount,coins,dp);
    }
    private int solve(int index,int amount,int[] coins,int[][] dp){
        if(amount==0) return 1;
        if(index<0) return 0;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int skip=solve(index-1,amount,coins,dp);
        int take=0;
        if(amount-coins[index]>=0){
             take=solve(index,amount-coins[index],coins,dp);
        }
        return dp[index][amount]=skip+take;
    }
}
