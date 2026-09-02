class Solution {
    private int solve(int index,int[] cost,int[] dp){
       if(index==0 || index==1){
        return 0;
       }
       if(dp[index]!=-1) return dp[index];
      int oneStep=solve(index-1,cost,dp)+cost[index-1];
       int twoStep=solve(index-2,cost,dp)+cost[index-2];
       dp[index]=Math.min(oneStep,twoStep);
       return dp[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,cost,dp);
    }
}
