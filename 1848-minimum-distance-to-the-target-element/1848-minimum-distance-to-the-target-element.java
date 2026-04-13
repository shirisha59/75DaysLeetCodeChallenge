class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                res= Math.min(res,Math.abs(i-start));
            
            }
        }
        return res;
    }
}