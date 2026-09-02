class Solution {
    private int solve(int index,List<Integer> nums,int[] dp){
        if(index==0) return nums.get(0);
        if(index==1) return Math.max(nums.get(0),nums.get(1));
        if(dp[index]!=-1) return dp[index];
        int taken=nums.get(index)+solve(index-2,nums,dp);
        int notTaken=solve(index-1,nums,dp);
        dp[index]=Math.max(taken,notTaken);
        return dp[index];
    } 
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0){
                arr1.add(nums[i]);
            }
            if(i!=n-1){
                arr2.add(nums[i]);
            }
        }
        int[] dp1=new int[arr1.size()];
        int[] dp2=new int[arr2.size()];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(solve(n-2,arr1,dp1),solve(n-2,arr2,dp2));
    }
}
