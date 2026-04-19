class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res=0;
        int len1=nums1.length;
        int len2=nums2.length;
        int i=0,j=0;
        while(i<len1 && j<len2){
                if(nums1[i]<=nums2[j]){
                    res=Math.max(res,j-i);
                    j++;
                }
                else{
                    i++;
                }
        }
        return res;
    }
}