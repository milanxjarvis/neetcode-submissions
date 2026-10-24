class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int[][] dp=new int[n][2001];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,target,n-1,dp);
    }
    private int solve(int[] nums,int target,int i,int[][] dp){
        if( i==-1){
            return target==0 ? 1:0; 
        } 
        if(dp[i][target+1000]!=-1) return dp[i][target+1000];
        
        int positive=solve(nums,target+nums[i],i-1,dp);
        int negative=solve(nums,target-nums[i],i-1,dp);
     return dp[i][target+1000]=positive+negative;
    }
}
