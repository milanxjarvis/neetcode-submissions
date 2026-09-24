class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int curMin=1,curMax=1;
        for(int num:nums){
            int oldMin=curMin;
            int oldMax=curMax;
            curMax=Math.max(num,Math.max(oldMax*num,oldMin*num));
            curMin=Math.min(num,Math.min(oldMax*num,oldMin*num));
            res=Math.max(res,curMax);
        }
        return res;
    }
}
