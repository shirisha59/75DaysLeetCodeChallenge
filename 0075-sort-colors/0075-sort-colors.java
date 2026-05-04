class Solution {
    public void sortColors(int[] nums) {
        int[] res=new int[nums.length];
        int countOne=0,countTwo=0,countZero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) countZero++;
            else if(nums[i]==1) countOne++;
            else countTwo++;
        }
        int j=0;
        while(countZero>0){
            nums[j++]=0;
            countZero--;
        }
          while(countOne>0){
            nums[j++]=1;
            countOne--;
        }
          while(countTwo>0){
            nums[j++]=2;
            countTwo--;
        } 
    }
}