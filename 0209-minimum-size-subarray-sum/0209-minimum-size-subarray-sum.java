class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int minLen=Integer.MAX_VALUE;
        int low=0;
        int high=0;
        int currSum=0;
        for(high=0;high<n;high++){
            currSum+=nums[high];
            while(currSum>=target){
                int currLen=high-low+1;
                minLen=Math.min(currLen,minLen);
            
            currSum-=nums[low];
            low++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;

        
    }
}