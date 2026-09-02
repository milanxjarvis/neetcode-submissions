class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int prev=0;
        int prev2=0;
        for(int i=2;i<=n;i++){
         int oneStep=cost[i-1]+prev;
        int twoStep=cost[i-2]+prev2;
            int current=Math.min(oneStep,twoStep);
            prev2=prev;
            prev=current;
        }
        return prev;
    }
}
