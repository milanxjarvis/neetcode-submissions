class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        
        int prev2=nums[0];
        int prev=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int taken=nums[i]+prev2;
            int notTaken=prev;
            int current=Math.max(taken,notTaken);
            prev2=prev;
            prev=current;
        }
        return prev;
    }
}
