class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        if(n==0) return 0;
        int cnt=1;
        int longest=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            else if((nums[i+1]-nums[i])==1){
                cnt++;
            }
            else {
                longest=Math.max(longest,cnt);
                cnt=1;
            }
        }
        return Math.max(longest,cnt);
    }
}