class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return robOrNotToRob(nums, nums.length-1, dp);
    }
    public int robOrNotToRob(int[] nums, int idx, int dp[]){
        if(idx<0) return 0;

        if(idx==0){
            dp[0] = nums[0];
            return dp[0];
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int notTake = robOrNotToRob(nums, idx-1, dp);

        int take = 0;

        if(idx>=1){
            take = nums[idx] + robOrNotToRob(nums, idx-2, dp);
        }

        dp[idx] = Math.max(take, notTake);

        return dp[idx];
    } 
}