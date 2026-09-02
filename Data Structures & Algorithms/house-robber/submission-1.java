class Solution {
    private int solve(int index,int[] nums,int[] dp){
        if(index==0) return nums[0];
        if(index==1) return Math.max(nums[0],nums[1]);
        if(dp[index]!=-1) return dp[index];
        int taken=nums[index]+solve(index-2,nums,dp);
        int notTaken=solve(index-1,nums,dp);
        dp[index]=Math.max(taken,notTaken);
        return dp[index];
    } 
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }
}
