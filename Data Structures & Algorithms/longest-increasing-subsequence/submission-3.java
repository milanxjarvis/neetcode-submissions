class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        int maxLis=1;
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        for(int i=0;i<nums.length;i++){
            maxLis=Math.max(maxLis,dfs(nums,i));
        }
        return maxLis;
    }
    private int dfs(int[] nums,int i){
        if(memo[i]!=-1){
            return memo[i];
        }
        int lis=1;
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                lis=Math.max(lis,1+dfs(nums,j));
            }
        }
        return memo[i]=lis;
    }
}
