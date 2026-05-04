class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int count=0;
        for(int i=0;i<len;i++){
            if(i<len-2 && nums[i]==nums[i+2]) continue;
            else{
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
}