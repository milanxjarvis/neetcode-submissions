class Solution {
    private int solve(int index,int[] dp){
       if(index==0) return 1;
       if(index==1) return 1;
       if(dp[index]!=-1) return dp[index];
       int oneStep=solve(index-1,dp);
       int twoStep=0;
       if(index>1){
        twoStep=solve(index-2,dp); 
       }
        return dp[index]=oneStep+twoStep; 
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}
